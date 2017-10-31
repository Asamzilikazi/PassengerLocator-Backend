package za.ac.mzilikazi.Repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.mzilikazi.Domain.Passenger;

/**
 * Created by Asavela on 2017/08/10.
 */
public interface PassengerRepository extends CrudRepository<Passenger,String> {

}
