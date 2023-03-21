package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.model.Book;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    void deleteAllAuthors();
    void deleteAuthor(Long id);
    Author getAuthorById(Long id);
}