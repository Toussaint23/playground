package com.altimetrik.playground.trip.service;

import com.altimetrik.playground.trip.model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;

@Service("cheapestTripService")
public class CheapestTripService implements ICheapestTripService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper objectMapper;
    private static final String API_KEY = "nA9fqxtYJDLRlTXHF76kQobqJ2WKGTNd";
    private String baseUrlAirport = "https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?apikey={0}&origin={1}&destination={2}&departure_date={3}&return_date={4}";
    private String baseUrlHotel = "https://api.sandbox.amadeus.com/v1.2/hotels/search-airport?apikey={0}&location={1}&check_in={2}&check_out={3}";
    private String baseUrlCar = "https://api.sandbox.amadeus.com/v1.2/cars/search-airport?apikey={0}&location={1}&pick_up={2}&drop_off={3}";

    @Override
    public Trip findCheapestTrip(Inputs inputs) {

        Trip trip = new Trip();
        Airport airport = findCheapestAirport(inputs);
        Car car = findCheapestCar(inputs);
        Hotel hotel = findCheapestHotel(inputs);
        trip.setAirport(airport);
        trip.setCar(car);
        trip.setHotel(hotel);
        trip.setPrice();
        return trip;
    }

    private Hotel findCheapestHotel(Inputs inputs) {
        Hotel hotel = new Hotel();
        String urlHotel = MessageFormat.format(baseUrlHotel, API_KEY, inputs.getDestination(), inputs.getStartDate(), inputs.getEndDate());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlHotel, String.class);
        String responseJson = responseEntity.getBody();
        try {
            JsonNode root = objectMapper.readTree(responseJson).get("results");
            JsonNode cheapestNode =  root.get(0);
            Iterator<JsonNode> nodeIterator = root.iterator();

            while (nodeIterator.hasNext()){
                JsonNode tempNode = nodeIterator.next();
                Double cheapest = cheapestNode.path("total_price").get("amount").asDouble();
                Double temp = tempNode.path("total_price").get("amount").asDouble();
                if(temp < cheapest)
                    cheapestNode = tempNode;
            }

            hotel.setCity(cheapestNode.path("address").get("city").asText());
            hotel.setLine(cheapestNode.path("address").get("line1").asText());
            hotel.setName(cheapestNode.path("property_name").asText());
            hotel.setPrice(cheapestNode.path("total_price").get("amount").asDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hotel;
    }

    private Car findCheapestCar(Inputs inputs) {
        Car car = new Car();
        String urlCar = MessageFormat.format(baseUrlCar, API_KEY, inputs.getDestination(), inputs.getStartDate(), inputs.getEndDate());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlCar, String.class);
        String responseJson = responseEntity.getBody();
        try {
            JsonNode root = objectMapper.readTree(responseJson).get("results");
            JsonNode cheapestNode =  root.get(0);
            JsonNode cheapestCar = cheapestNode.path("cars").get(0);
            Iterator<JsonNode> nodeIterator = root.iterator();

          /*  while (nodeIterator.hasNext()){
                Iterator<JsonNode> carNode = nodeIterator.next().path("cars").iterator();
                while (carNode.hasNext()){
                    JsonNode tempNode = carNode.next();
                    Double cheapest = cheapestNode.path("fare").get("total_price").asDouble();
                    Double temp = tempNode.path("fare").get("total_price").asDouble();
                    if(temp < cheapest)
                        cheapestNode = tempNode;
                }
                JsonNode tempNode = nodeIterator.next();
                Double cheapest = cheapestNode.path("fare").get("total_price").asDouble();
                Double temp = tempNode.path("fare").get("total_price").asDouble();
                if(temp < cheapest)
                    cheapestNode = tempNode;
            }*/

            car.setAmount(cheapestCar.path("estimated_total").get("amount").asDouble());
            car.setCity(cheapestNode.path("address").get("city").asText());
            car.setCompany(cheapestNode.path("provider").get("company_name").asText());
            car.setUrl(cheapestCar.path("images").path(0).get("url").asText());
            System.out.println(cheapestNode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return car;
    }

    private Airport findCheapestAirport(Inputs inputs) {
        Airport airport = new Airport();
        String urlAirport = MessageFormat.format(baseUrlAirport, API_KEY, inputs.getOrigin(), inputs.getDestination(), inputs.getStartDate(), inputs.getEndDate());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlAirport, String.class);
        String responseJson = responseEntity.getBody();
        try {
            JsonNode root = objectMapper.readTree(responseJson).get("results");
            JsonNode cheapestNode =  root.get(0);
            Iterator<JsonNode> nodeIterator = root.iterator();

            while (nodeIterator.hasNext()){
                JsonNode tempNode = nodeIterator.next();
                Double cheapest = cheapestNode.path("fare").get("total_price").asDouble();
                Double temp = tempNode.path("fare").get("total_price").asDouble();
                if(temp < cheapest)
                    cheapestNode = tempNode;
            }
            airport.setAirportOrigin(inputs.getOrigin());
            airport.setAirportDestination(inputs.getDestination());
            airport.setPrice(cheapestNode.path("fare").get("total_price").asDouble());
            airport.setOutDuration(cheapestNode.path("itineraries").path(0).path("outbound").get("duration").asText());
            airport.setReturnDuration(cheapestNode.path("itineraries").path(0).path("inbound").get("duration").asText());
            airport.setOutFlightNumber(cheapestNode.path("itineraries").path(0).path("outbound").path("flights").path(0).get("flight_number").asLong());
            airport.setReturnFlightNumber(cheapestNode.path("itineraries").path(0).path("inbound").path("flights").path(0).get("flight_number").asLong());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return airport;
    }
}
