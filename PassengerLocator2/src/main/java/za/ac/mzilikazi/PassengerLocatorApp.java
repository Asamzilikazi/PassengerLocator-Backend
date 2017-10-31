package za.ac.mzilikazi;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.mzilikazi.Domain.*;
import za.ac.mzilikazi.Factory.*;
import za.ac.mzilikazi.Services.Impl.*;

import java.util.Date;


@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/PassengerLocator")
public class PassengerLocatorApp {

    @Autowired
    protected AdminServiceImpl adminService;

    @Autowired
    protected FlightServiceImpl flightService;

    @Autowired
    protected PassengerServiceImpl passengerService;

    @Autowired
    protected TicketServiceImpl ticketService;

    @Autowired
    protected LuggageServiceImpl luggageService;

    //*****************************************Admin********************************
    @GetMapping(path = "/addAdmin/{adminId}/{adminName}/{adminPassword}")
    public @ResponseBody
    String addAdmin(@PathVariable String adminId, @PathVariable String adminName, @PathVariable String adminPassword)
    {
        Admin admin = AdminFactory.buildAdmin(adminId, adminName, adminPassword);
        adminService.save(admin);
        return new Gson().toJson(admin);
    }

    @GetMapping(path = "readAdmin/{adminId}")
    public @ResponseBody String readAdmin(@PathVariable String adminId)
    {
        Admin admin = adminService.findById(adminId);
        return new Gson().toJson(admin);
    }

    @GetMapping(path = "/updateAdmin/{adminId}/{adminName}/{adminPassword}")
    public @ResponseBody String updateAdmin(@PathVariable String adminId, @PathVariable String adminName, @PathVariable String adminPassword)
    {
        Admin admin = adminService.findById(adminId);

        if(admin == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Admin adminInsert = AdminFactory.buildAdmin(adminId, adminName, adminPassword);
        adminService.update(adminInsert);
        return new Gson().toJson(adminInsert);
    }
    @GetMapping(path = "deleteAdmin/{adminId}")
    public @ResponseBody void deleteAdmin(@PathVariable String adminId) {
        Admin adminw = adminService.findById(adminId);
        if (adminw == null) {
            System.out.println("Record does not exist");
        } else {
            adminService.delete(adminw);
            System.out.println("Record deleted");
        }
    }
    //***********************************Passenger********************************
    @GetMapping(path = "/addPassenger/{id}/{firstName}/{lastName}/{dob}/{contactNumber}/{fly_id}")
    public @ResponseBody
    String addPassenger(@PathVariable String id, @PathVariable String firstName, @PathVariable String lastName, @PathVariable String dob, @PathVariable String contactNumber, @PathVariable String fly_id)
    {
        Flight fly = new Flight.Builder()
                .id(fly_id)
                .airline("")
                .destination("")
                .departureTime("")
                .arrivalTime("")
                .flightDate("")
                .build();

        Passenger passengerAdd = PassengerFactory.buildPassenger(id, firstName, lastName, dob, contactNumber,fly);
        passengerService.save(passengerAdd);
        return new Gson().toJson(passengerAdd);
    }

    @GetMapping(path = "readPassenger/{id}")
    public @ResponseBody String readPassenger(@PathVariable String id)
    {
        Passenger passengerRead = passengerService.findById(id);
        return new Gson().toJson(passengerRead);
    }

    @GetMapping(path = "/updatePassenger/{id}/{firstName}/{lastName}/{dob}/{contactNumber}")
    public @ResponseBody String updatePassenger(@PathVariable String id, @PathVariable String firstName, @PathVariable String lastName, @PathVariable String dob, @PathVariable String contactNumber ,@PathVariable String fly_id )
    {
        Passenger passengerUpdate = passengerService.findById(id);

        if(passengerUpdate== null)
        {
            return new Gson().toJson("Record does not exist");
        }
        Flight fly = new Flight.Builder()
                .id(fly_id)
                .airline("")
                .destination("")
                .departureTime("")
                .arrivalTime("")
                .flightDate("")
                .build();

        Passenger passenger = PassengerFactory.buildPassenger(id, firstName, lastName, dob, contactNumber, fly);
        passengerService.update(passenger);
        return new Gson().toJson(passenger);
    }

    @GetMapping(path = "/deletePassenger/{id}")
    public @ResponseBody void deletePassenger(@PathVariable String id) {
        Passenger passengerDelete = passengerService.findById(id);
        if (passengerDelete == null) {
            System.out.println("Record does not exist");
        } else {
            passengerService.delete(passengerDelete);
            System.out.println("Record deleted");
        }
    }

    //***********************************Flight************************************

    @GetMapping(path = "/addFlight/{id}/{airline}/{flightDate}/{destination}/{departureTime}/{arrivalTime}")
    public @ResponseBody
    String addFlight(@PathVariable String id, @PathVariable String airline, @PathVariable String flightDate, @PathVariable String destination, @PathVariable String departureTime, @PathVariable String arrivalTime)
    {
        Flight flightAdd = FlightFactory.buildFlight(id, airline, flightDate, destination, departureTime, arrivalTime);
        flightService.save(flightAdd);
        return new Gson().toJson(flightAdd);
    }


    @GetMapping(path = "/readFlight/{id}")
    public @ResponseBody String readFlight(@PathVariable String id)
    {
        Flight flightRead = flightService.findById(id);
        return new Gson().toJson(flightRead);
    }

    @GetMapping(path = "/updateFlight/{id}/{airline}/{flightDate}/{destination}/{departureTime}/{arrivalTime}")
    public @ResponseBody String updateFlight(@PathVariable String id, @PathVariable String airline, @PathVariable String flightDate, @PathVariable String destination, @PathVariable String departureTime, @PathVariable String arrivalTime)
    {
        Flight flightUpdate = flightService.findById(id);

        if(flightUpdate == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Flight flight = FlightFactory.buildFlight(id, airline, flightDate, destination, departureTime, arrivalTime);
        flightService.update(flight);
        return new Gson().toJson(flight);
    }

    @GetMapping(path = "/deleteFlight/{id}")
    public @ResponseBody void deleteFlight(@PathVariable String id) {
        Flight flightDelete = flightService.findById(id);
        if (flightDelete == null) {
            System.out.println("Record does not exist");
        } else {
            flightService.delete(flightDelete);
            System.out.println("Record deleted");
        }
    }
    //**************************************Ticket***************************************

    @GetMapping(path = "/addTicket/{id}/{number}/{pass_id}")
    public @ResponseBody
    String addTicket(@PathVariable String id, @PathVariable int number, @PathVariable String pass_id)
    {
        Passenger pass = new Passenger.Builder()
                .id(pass_id)
                .firstName("")
                .lastName("")
                .dob("")
                .contactNumber("")
                .build();

        Ticket ticketAdd = TicketFactory.buildTicket(id, number, pass);
        ticketService.save(ticketAdd);
        return new Gson().toJson(ticketAdd);
    }

    @GetMapping(path = "/readTicket/{id}")
    public @ResponseBody String readTicket(@PathVariable String id)
    {
        Ticket ticketRead = ticketService.findById(id);
        return new Gson().toJson(ticketRead);
    }

    @GetMapping(path = "/updateTicket/{id}/{number}/{pass_id}")
    public @ResponseBody String updateTicket(@PathVariable String id, @PathVariable int number, @PathVariable String pass_id)
    {
        Ticket ticketUpdate = ticketService.findById(id);

        if(ticketUpdate == null)
        {
            return new Gson().toJson("Record does not exist");
        }
        Passenger pass = new Passenger.Builder()
                .id(pass_id)
                .firstName("")
                .lastName("")
                .dob("")
                .contactNumber("")
                .build();

        Ticket ticket = TicketFactory.buildTicket(id, number, pass);
        ticketService.update(ticket);
        return new Gson().toJson(ticket);
    }
    @GetMapping(path = "/deleteTicket/{id}")
    public @ResponseBody void deleteTicket(@PathVariable String id) {
        Ticket ticketDelete = ticketService.findById(id);
        if (ticketDelete == null) {
            System.out.println("Record does not exist");
        } else {
            ticketService.delete(ticketDelete);
            System.out.println("Record deleted");
        }
    }
    //******************************************Luggage***************************************************
    @GetMapping(path = "/addLuggage/{id}/{weight}/{description}/{pass_id}")
    public @ResponseBody
    String addLuggage(@PathVariable String id, @PathVariable String weight, @PathVariable String description, @PathVariable String pass_id)
    {
        Passenger pass = new Passenger.Builder()
                .id(pass_id)
                .firstName("")
                .lastName("")
                .dob("")
                .contactNumber("")
                .build();

        Luggage luggageAdd = LuggageFactory.buildLuggage(id, weight, description, pass);
        luggageService.save(luggageAdd);
        return new Gson().toJson(luggageAdd);
    }

    @GetMapping(path = "readLuggage/{id}")
    public @ResponseBody String readLuggage(@PathVariable String id)
    {
        Luggage luggageRead = luggageService.findById(id);
        return new Gson().toJson(luggageRead);
    }

    @GetMapping(path = "/updateLuggage/{id}/{weight}/{description}/{pass_id}")
    public @ResponseBody String updateLuggage(@PathVariable String id, @PathVariable String weight, @PathVariable String description, @PathVariable String pass_id)
    {
        Luggage luggageUpdate = luggageService.findById(id);

        if(luggageUpdate== null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Passenger pass = new Passenger.Builder()
                .id(pass_id)
                .firstName("")
                .lastName("")
                .dob("")
                .contactNumber("")
                .build();

        Luggage luggage = LuggageFactory.buildLuggage(id, weight, description, pass);
        luggageService.update(luggage);
        return new Gson().toJson(luggage);
    }

    @GetMapping(path = "/deleteLuggage/{id}")
    public @ResponseBody void deleteLuggage(@PathVariable String id) {
        Luggage luggageDelete = luggageService.findById(id);
        if (luggageDelete == null) {
            System.out.println("Record does not exist");
        } else {
            luggageService.delete(luggageDelete);
            System.out.println("Record deleted");
        }
    }
}

