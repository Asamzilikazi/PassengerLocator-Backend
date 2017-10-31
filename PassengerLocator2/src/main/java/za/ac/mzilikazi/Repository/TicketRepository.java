package za.ac.mzilikazi.Repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.mzilikazi.Domain.Ticket;

/**
 * Created by Asavela on 2017/08/10.
 */
public interface TicketRepository extends CrudRepository<Ticket, String> {

}
