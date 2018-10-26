package com.altimetrik.playground.trip.model;

import java.time.LocalDate;

public class Inputs {
    private String origin;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;

    public Inputs(String origin, String destination, String startDate, int days) {
        this.origin = origin;
        this.destination = destination;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(startDate).plusDays(days);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
