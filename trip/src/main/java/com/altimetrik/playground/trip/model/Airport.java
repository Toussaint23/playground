package com.altimetrik.playground.trip.model;

public class Airport {

    private String airportOrigin;
    private String airportDestination;
    private String outDuration;
    private String returnDuration;
    private long outFlightNumber;
    private long returnFlightNumber;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAirportOrigin() {
        return airportOrigin;
    }

    public void setAirportOrigin(String airportOrigin) {
        this.airportOrigin = airportOrigin;
    }

    public String getAirportDestination() {
        return airportDestination;
    }

    public void setAirportDestination(String airportDestination) {
        this.airportDestination = airportDestination;
    }

    public String getOutDuration() {
        return outDuration;
    }

    public void setOutDuration(String outDuration) {
        this.outDuration = outDuration;
    }

    public String getReturnDuration() {
        return returnDuration;
    }

    public void setReturnDuration(String returnDuration) {
        this.returnDuration = returnDuration;
    }

    public long getOutFlightNumber() {
        return outFlightNumber;
    }

    public void setOutFlightNumber(long outFlightNumber) {
        this.outFlightNumber = outFlightNumber;
    }

    public long getReturnFlightNumber() {
        return returnFlightNumber;
    }

    public void setReturnFlightNumber(long returnFlightNumber) {
        this.returnFlightNumber = returnFlightNumber;
    }
}

