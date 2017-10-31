package za.ac.mzilikazi.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.mzilikazi.Domain.Luggage;
import za.ac.mzilikazi.Repository.LuggageRepository;
import za.ac.mzilikazi.Services.LuggageService;

import java.util.List;

/**
 * Created by Asavela on 2017/08/10.
 */
@Component
public class LuggageServiceImpl implements LuggageService {
    @Autowired
    private LuggageRepository repository;

    public List<Luggage> getLuggage(String id){return repository.findById(id);}

    @Override
    public Luggage save(Luggage entity) {return repository.save(entity);}

    @Override
    public Luggage findById(String s) {return repository.findOne(s);}

    @Override
    public Luggage update(Luggage entity) {return repository.save(entity);}

    @Override
    public void delete(Luggage entity) {repository.delete(entity);}
}
