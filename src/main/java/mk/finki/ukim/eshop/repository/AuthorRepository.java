package mk.finki.ukim.eshop.repository;

import mk.finki.ukim.eshop.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
