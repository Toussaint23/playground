package com.altimetrik.playground.trip.model;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inputs {
    private String origin;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;

    public Inputs(){}

    public Inputs(String origin, String destination, String startDate, int days) {
        this.origin = origin;
        this.destination = destination;
        this.startDate = LocalDate.parse(startDate);
        this.days = days;
        this.endDate = LocalDate.parse(startDate).plusDays(this.getDays());
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

    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate);
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate() {
        this.endDate = this.startDate.plusDays(this.getDays());
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Boolean isNull(){
        return days == 0;
    }

    public boolean regex(String startdate){

        String regex = "^\\d{4}-\\d{2}-\\d{2}$";

        Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(startdate);
            return matcher.matches();
    }
}
