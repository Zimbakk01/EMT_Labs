package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Book;
import mk.finki.ukim.eshop.model.dto.BookDto;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addNewBook(BookDto book);

    Book editBook(Long id, BookDto book);

    void deleteBook(Long id);

    void markBookAsTaken(Long id);


}
