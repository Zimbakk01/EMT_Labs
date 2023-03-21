package mk.finki.ukim.eshop.repository;

import mk.finki.ukim.eshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}
