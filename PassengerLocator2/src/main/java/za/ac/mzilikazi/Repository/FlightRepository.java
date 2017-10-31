package za.ac.mzilikazi.Repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.mzilikazi.Domain.Flight;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight,String> {
    public List<Flight> findById(String id);
}
