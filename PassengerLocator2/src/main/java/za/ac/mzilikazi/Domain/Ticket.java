package za.ac.mzilikazi.Domain;

/**
 * Created by Asavela on 2017/08/08.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ticket {

    @Id
    private String id;
    private int number;

    @OneToOne
    private Passenger pass;

    public Ticket()
    {

    }

    public Ticket(Builder builder) {

        this.id = builder.id;
        this.number = builder.number;
        this.pass = builder.pass;


    }
    public static class Builder {

        private String id;
        private int number;
        private Passenger pass;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder number(int value) {
            this.number = value;
            return this;
        }
        public Builder pass(Passenger pass) {
            this.pass = pass;
            return this;
        }



        public Ticket build(){

            return new Ticket(this);
        }
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }




}
