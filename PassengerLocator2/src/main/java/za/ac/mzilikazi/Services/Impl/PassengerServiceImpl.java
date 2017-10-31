package za.ac.mzilikazi.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.mzilikazi.Domain.Passenger;
import za.ac.mzilikazi.Factory.PassengerFactory;
import za.ac.mzilikazi.Repository.PassengerRepository;
import za.ac.mzilikazi.Services.PassengerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    protected PassengerRepository repository;

    @Override
    public Passenger save(Passenger entity) {return repository.save(entity);}

    @Override
    public Passenger findById(String s) {return repository.findOne(s);}

    @Override
    public Passenger update(Passenger entity) {return repository.save(entity);}

    @Override
    public void delete(Passenger entity) {repository.delete(entity);}

    public List<Passenger> getPassenger() {
        List<Passenger> allPassengers = new ArrayList<Passenger>();

        Iterable<Passenger> customers = repository.findAll();
        for (Passenger passenger : customers) {
            allPassengers.add(passenger);
        }
        return allPassengers;
    }
}
