package mk.finki.ukim.eshop.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String continent;

    public Country(){}

    public Country(String name, String continent){
        this.name=name;
        this.continent=continent;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }
}
