package com.altimetrik.playground.trip.model;

public class Trip {
    private Airport airport;
    private Car car;
    private Hotel hotel;
    private double price;

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = airport.getPrice() + car.getAmount() + hotel.getPrice();
    }
}
