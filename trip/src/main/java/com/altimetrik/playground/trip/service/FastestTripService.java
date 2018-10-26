package com.altimetrik.playground.trip.service;

import com.altimetrik.playground.trip.model.Inputs;
import com.altimetrik.playground.trip.model.Trip;
import org.springframework.stereotype.Service;

@Service("fastestTripService")
public class FastestTripService implements IFastestTripService {
    @Override
    public Trip findFastestTrip(Inputs inputs) {
        return null;
    }
}
