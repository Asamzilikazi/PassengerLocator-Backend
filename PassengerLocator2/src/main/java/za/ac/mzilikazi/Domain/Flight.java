package za.ac.mzilikazi.Domain;

/**
 * Created by Asavela on 2017/08/08.
 */
import javax.persistence.*;
import java.lang.String;

@Entity
public class Flight {

    @Id
    private String id;
    private String airline;
    private String flightDate;
    private String destination;
    private String departureTime;
    private String arrivalTime;


    public Flight()
    {

    }

    public Flight(Builder builder) {

        this.id = builder.id;
        this.airline = builder.airline;
        this.flightDate = builder.flightDate;
        this.destination = builder.destination;
        this.departureTime = builder.departureTime;
        this.arrivalTime = builder.arrivalTime;

    }
    public static class Builder {



        private String id;
        private String airline;
        private String flightDate;
        private String destination;
        private String departureTime;
        private String arrivalTime;

        public Builder id(String value) {
            this.id = value;
            return this;
        }
        public Builder airline(String value) {
            this.airline = value;
            return this;
        }
        public Builder flightDate(String value) {
            this.flightDate = value;
            return this;
        }
        public Builder destination(String value) {
            this.destination = value;
            return this;
        }

        public Builder departureTime(String value) {
            this.departureTime = value;
            return this;
        }

        public Builder arrivalTime(String value) {
            this.arrivalTime = value;
            return this;
        }
        public Flight build(){

            return new Flight(this);
        }
    }



    public String getId() {
        return id;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public String getAirline() {
        return airline;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }


}
