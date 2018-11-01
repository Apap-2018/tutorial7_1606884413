package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.FlightModel;

/**
 * FlightService
 */
public interface FlightService {
    FlightModel addFlight(FlightModel flight);
    
    void deleteByFlightNumber(String flightNumber);

    FlightModel getFlightDetailByFlightNumber(String flightNumber);
    
    FlightModel getFlightDetailById(long id);
    
    void deleteFlight(FlightModel flight);
    
    List<FlightModel> getAll();
}