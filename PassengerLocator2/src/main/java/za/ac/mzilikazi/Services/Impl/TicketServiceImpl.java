package za.ac.mzilikazi.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.mzilikazi.Domain.Ticket;
import za.ac.mzilikazi.Repository.TicketRepository;
import za.ac.mzilikazi.Services.TicketService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asavela on 2017/08/10.
 */
@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    protected TicketRepository repository;

    @Override
    public Ticket save(Ticket entity) {return repository.save(entity);}

    @Override
    public Ticket findById(String s) {return repository.findOne(s);}

    @Override
    public Ticket update(Ticket entity) {return repository.save(entity);}

    @Override
    public void delete(Ticket entity) {repository.delete(entity);}

    public List<Ticket> getPassenger() {
        List<Ticket> allTickets = new ArrayList<Ticket>();

        Iterable<Ticket> passengers = repository.findAll();
        for (Ticket ticket : passengers) {
            allTickets.add(ticket);
        }
        return allTickets;
    }

}
