package za.ac.mzilikazi.Factory;

import za.ac.mzilikazi.Domain.Passenger;
import za.ac.mzilikazi.Domain.Ticket;

/**
 * Created by Asavela on 2017/08/10.
 */
public class TicketFactory {
    public static Ticket buildTicket (String id, int number, Passenger pass)
    {
        Ticket ticket = new Ticket.Builder()
                .id(id)
                .number(number)
                .pass(pass)
                .build();

        return ticket;

    }
}
