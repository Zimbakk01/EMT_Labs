package mk.finki.ukim.eshop.repository;

import mk.finki.ukim.eshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository  extends JpaRepository<Book, Long> {
    void deleteByName(String name);
    Optional<Book> findByName(String name);
}
