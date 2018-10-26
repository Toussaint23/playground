package com.altimetrik.playground.trip.service;

import com.altimetrik.playground.trip.model.Inputs;
import com.altimetrik.playground.trip.model.Trip;

public interface ICheapestTripService {
    public Trip findCheapestTrip(Inputs inputs);

}
