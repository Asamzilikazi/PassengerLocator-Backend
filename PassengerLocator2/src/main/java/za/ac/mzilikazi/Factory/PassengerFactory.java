package za.ac.mzilikazi.Factory;


import za.ac.mzilikazi.Domain.Flight;
import za.ac.mzilikazi.Domain.Passenger;


/**
 * Created by Asavela on 2017/08/13.
 */
public class PassengerFactory {
    public static Passenger buildPassenger (String id, String firstName, String lastName, String dob, String contactNumber, Flight fly)
    {
        Passenger passenger = new Passenger.Builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .dob(dob)
                .contactNumber(contactNumber)
                .fly(fly)
                .build();
        return passenger;
    }
}
