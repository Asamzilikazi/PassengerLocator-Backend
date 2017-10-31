package za.ac.mzilikazi.Factory;

import za.ac.mzilikazi.Domain.Flight;

import java.util.Date;

public class FlightFactory {
    public static Flight buildFlight(String id, String airline, String flightDate, String destination,String departureTime,String arrivalTime){
        Flight flight = new Flight.Builder()
                .id(id)
                .airline(airline)
                .flightDate(flightDate)
                .destination(destination)
                .departureTime(departureTime)
                .arrivalTime(arrivalTime)
                .build();
        return flight;
    }
}



