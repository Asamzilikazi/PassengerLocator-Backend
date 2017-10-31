package za.ac.mzilikazi.Domain;

/**
 * Created by Asavela on 2017/08/08.
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Passenger  {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String dob;
    private String contactNumber;

    @ManyToOne
    private Flight fly;

    public Passenger()
    {

    }

    public Passenger(Builder builder) {

        this.id = builder.id;
        this.contactNumber = builder.contactNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dob = builder.dob;
        this.fly = builder.fly;


    }
    public static class Builder {

        private String id;
        private String contactNumber;
        private String firstName;
        private String lastName;
        private String dob;
        private Flight fly;


        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder contactNumber(String value) {
            this.contactNumber = value;
            return this;
        }

        public Builder firstName(String value) {
            this.firstName = value;
            return this;
        }

        public Builder lastName(String value) {
            this.lastName = value;
            return this;
        }

        public Builder dob(String value) {
            this.dob = value;
            return this;
        }

        public Builder fly(Flight fly) {
            this.fly = fly;
            return this;
        }

        public Passenger build(){

            return new Passenger(this);
        }

    }
    public String getId() {return id;}

    public String getContactNumber() {
        return contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }




}
