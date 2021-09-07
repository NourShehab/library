package edu.guc.library.service;

import edu.guc.library.domain.Author;
import edu.guc.library.domain.Book;
import edu.guc.library.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service("bookService")
@Transactional
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findByTitle(String title) {
        return this.bookRepository.findByTitle(title);
    }
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }
    public Optional<Book> save(Book book) {

            return Optional.of(this.bookRepository.save(book));


    }

    public void delete(Long id) {this.bookRepository.deleteBookById(id); }
}
