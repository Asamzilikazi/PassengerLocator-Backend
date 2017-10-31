package za.ac.mzilikazi.Repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.mzilikazi.Domain.Luggage;

import java.util.List;

/**
 * Created by Asavela on 2017/08/10.
 */
public interface LuggageRepository extends CrudRepository<Luggage,String>{
    public List<Luggage> findById(String id);

}
