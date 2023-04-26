package mk.finki.ukim.eshop.init;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.model.Book;
import mk.finki.ukim.eshop.model.Country;
import mk.finki.ukim.eshop.model.enums.Category;
import mk.finki.ukim.eshop.repository.AuthorRepository;
import mk.finki.ukim.eshop.repository.BookRepository;
import mk.finki.ukim.eshop.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init ()
    {
        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("Serbia", "Europe");
        Country country3 = new Country("Netherlands", "Europe");
        countryRepository.save(country1);
        countryRepository.save(country2);
        countryRepository.save(country3);
        Author author1 = new Author("Bojan", "Vladevski", country1);
        Author author2 = new Author("Mirza", "Lazarevic", country2);
        Author author3 = new Author("Makadis", "Amerlaan", country3);
        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
        bookRepository.save(new Book("How to become a millionare",Category.HISTORY,author1,15));
        bookRepository.save(new Book( "Tajniot most",Category.HISTORY, author2,250));
        bookRepository.save(new Book(  "The Bird and the fox",Category.DRAMA, author3,100));

    }
}
