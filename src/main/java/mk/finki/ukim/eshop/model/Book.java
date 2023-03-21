package mk.finki.ukim.eshop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.finki.ukim.eshop.model.enums.Category;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private int availableCopies;

    public Book(int availableCopies, Category category, String name, Author author) {
        this.availableCopies = availableCopies;
        this.category = category;
        this.name = name;
        this.author = author;
    }

    public Book() {

    }
}
