package edu.guc.library.web.rest;

import edu.guc.library.domain.Book;
import edu.guc.library.domain.Student;
import edu.guc.library.service.BookService;
import edu.guc.library.service.UserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/view")
    public Book getBookByTitle (@RequestParam("title") String title) {
        var book = bookService.findByTitle(title);

        if (book.isPresent()) {
            return book.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "book not found"
            );
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {

        if (book.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this email already exists");
        }

        var bookFromService = this.bookService.save(book);
        if (bookFromService.isPresent()) {
            return bookFromService.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "please provide a valid book structure and please verify that the id is unique"
            );
        }
    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBook (@RequestParam("id") Long id) {
        var book = bookService.findById(id);

        if (book.isPresent()) {
            bookService.delete(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "book not found"
            );

        }
    }


}

