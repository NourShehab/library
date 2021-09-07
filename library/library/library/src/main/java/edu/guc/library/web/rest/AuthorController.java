package edu.guc.library.web.rest;

import edu.guc.library.domain.Author;
import edu.guc.library.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public Author getAuthorByName(@RequestParam("name") String name) {
        var author = authorService.findOneByName(name);

        if (author.isPresent()) {
            return author.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "author not found - Just a test"
            );
        }
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {

        if (author.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A newly created author should not have an id");
        }

        var authorFromService = this.authorService.save(author);
        if (authorFromService.isPresent()) {
            return authorFromService.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "please provide a valid author structure and please verify that the id is unique"
            );
        }
    }

    @DeleteMapping("/authors")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAuthor(@RequestParam("name") String name) {
        var author = authorService.findOneByName(name);

        if (author.isPresent()) {
            authorService.delete(name);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "author not found"
            );

        }
    }

    @PutMapping("/authors")
    Author updateAuthor(@RequestBody Author author) {
        if (author.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide an id to update the author");
        }

        return authorService.save(author)
                .orElseGet(() ->
                {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "author not found"
                    );
                });
    }
}
