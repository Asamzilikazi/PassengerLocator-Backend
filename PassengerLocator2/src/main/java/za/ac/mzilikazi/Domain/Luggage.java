package za.ac.mzilikazi.Domain;

/**
 * Created by Asavela on 2017/08/08.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Luggage {

    @Id
    private String id;
    private String weight;
    private String description;

    @ManyToOne
    private Passenger pass;

    public Luggage()
    {

    }

    public Luggage(Builder builder) {

        this.id = builder.id;
        this.weight = builder.weight;
        this.description = builder.description;
        this.pass = builder.pass;

    }
    public static class Builder {

        private String id;
        private String weight;
        private String description;
        private Passenger pass;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder weight(String value) {
            this.weight = value;
            return this;
        }

        public Builder description(String value) {
            this.description = value;
            return this;
        }

        public Builder pass(Passenger pass) {
            this.pass = pass;
            return this;
        }

        public Luggage build(){

            return new Luggage(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getWeight() {
        return weight;
    }

    public String getDescription(){return description;}





}

