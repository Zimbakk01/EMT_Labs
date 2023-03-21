package mk.finki.ukim.eshop.controller;

import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list-authors")
    public List<Author> listAuthors() {
        return this.authorService.getAllAuthors();
    }
}
