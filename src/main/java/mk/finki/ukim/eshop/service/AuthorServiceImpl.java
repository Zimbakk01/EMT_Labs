package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;


    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public void deleteAllAuthors() {
        this.authorRepository.deleteAll();
    }

    @Override
    public void deleteAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public Author getAuthorById(Long id) {
        return this.authorRepository.findById(id).orElse(null);
    }
}
