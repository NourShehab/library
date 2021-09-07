package edu.guc.library.service;

import edu.guc.library.domain.Author;
import edu.guc.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("authorService")
@Transactional
// ACID
// Atomicity Consistency Isolation Durability.
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> findOneByName(String name) {
        return this.authorRepository.findOneByName(name);
    }

    public Optional<Author> save(Author author) {
        var authorInDb = this.findOneByName(author.getName());

        if (authorInDb.isPresent()) {
            var authorInDbUnwrapped = authorInDb.get();
            if (authorInDbUnwrapped.getAge() != author.getAge()) {
                authorInDbUnwrapped.setAge(author.getAge());
            }

            if (authorInDbUnwrapped.getBooks() != author.getBooks()) {
                authorInDbUnwrapped.setBooks(author.getBooks());
            }

            return Optional.of(this.authorRepository.save(authorInDbUnwrapped));
        } else {
            return Optional.of(this.authorRepository.save(author));
        }
    }

    public void delete(String name) {this.authorRepository.deleteAuthorByName(name); }
}
