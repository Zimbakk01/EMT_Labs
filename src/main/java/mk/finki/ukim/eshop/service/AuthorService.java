package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.model.AuthorDto;
import mk.finki.ukim.eshop.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
    List<Author> findAll();
    Optional<Author> save(String name, String surname, Long countryId);
    void deleteById(Long id);
    Optional<Author> save(AuthorDto authorDto);
}