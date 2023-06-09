package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.model.Book;
import mk.finki.ukim.eshop.model.dto.BookDto;
import mk.finki.ukim.eshop.model.enums.Category;
import mk.finki.ukim.eshop.model.exceptions.AuthorNotFoundException;
import mk.finki.ukim.eshop.model.exceptions.BookNotFoundException;
import mk.finki.ukim.eshop.repository.AuthorRepository;
import mk.finki.ukim.eshop.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    BookServiceImpl(BookRepository bookRepository,AuthorRepository authorRepository){
        this.bookRepository=bookRepository;
        this.authorRepository=authorRepository;
    }
    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        this.bookRepository.deleteByName(name);
        Book book = new Book(name, category, author, availableCopies);

        this.bookRepository.save(book);
        return Optional.of(book);

    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);

    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author=this.authorRepository.findById(authorId).orElseThrow(()-> new AuthorNotFoundException(authorId));
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
        return Optional.of(book);

    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book= this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(bookDto.getName());
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);

    }

    @Override
    public void takeBook(Long id) {
        Book book=this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies()>0){
        book.setAvailableCopies(book.getAvailableCopies() -1);
        this.bookRepository.save(book);}
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
