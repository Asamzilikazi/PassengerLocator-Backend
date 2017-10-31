package za.ac.mzilikazi.Factory;

import za.ac.mzilikazi.Domain.Luggage;
import za.ac.mzilikazi.Domain.Passenger;

/**
 * Created by Asavela on 2017/08/10.
 */
public class LuggageFactory {
    public static Luggage buildLuggage (String id, String weight, String description, Passenger pass)
    {
        Luggage luggage = new Luggage.Builder()
                .id(id)
                .weight(weight)
                .description(description)
                .pass(pass)
                .build();
        return luggage;
    }
}
