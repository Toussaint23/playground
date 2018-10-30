package com.altimetrik.playground.trip.controller;

import com.altimetrik.playground.trip.model.Inputs;
import com.altimetrik.playground.trip.model.Trip;
import com.altimetrik.playground.trip.service.ICheapestTripService;
import com.altimetrik.playground.trip.service.IFastestTripService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/trip", produces = MediaType.APPLICATION_JSON_VALUE)
public class Api {
    @Autowired
    ICheapestTripService cheapestTripService;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(value = "/search/cheapest")
    @ResponseBody
    public Trip searchCheapestTrip(@RequestParam String origin, @RequestParam String destination, @RequestParam int days,
                                    @ApiParam(value = "YYYY-mm-dd")@RequestParam String startdate){
        if(new Inputs().regex(startdate)){
            Inputs inputs = new Inputs(origin, destination, startdate, days);
            return (inputs.isNull()) ? new Trip() : cheapestTripService.findCheapestTrip(inputs);
        }
        return new Trip();
    }




    /*@Autowired
  IFastestTripService fastestTripService;

    @GetMapping("/search/fastest")
    @ResponseBody
    public Trip  searchFastestTrip(@RequestParam String origin, @RequestParam String destination, @RequestParam int days,
                                   @ApiParam(value = "YYYY-mm-dd")@RequestParam String startdate){
        Inputs inputs = new Inputs(origin, destination, startdate, days);
        return fastestTripService.findFastestTrip(inputs);
        return null;
    }
*/


}
