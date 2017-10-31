package za.ac.mzilikazi.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.mzilikazi.Repository.FlightRepository;
import za.ac.mzilikazi.Domain.Flight;
import za.ac.mzilikazi.Services.BaseService;
import za.ac.mzilikazi.Services.FlightService;

import java.util.List;

@Component
public class FlightServiceImpl implements FlightService{


    @Autowired
    private FlightRepository repository;

    public List<Flight> getFlight(String id){return repository.findById(id);}

    @Override
    public Flight save(Flight entity) {return repository.save(entity);}

    @Override
    public Flight findById(String s) {return repository.findOne(s);}

    @Override
    public Flight update(Flight entity) {return repository.save(entity);}

    @Override
    public void delete(Flight entity) {repository.delete(entity);}
}
