package edu.guc.library.repository;

import edu.guc.library.domain.Author;
import edu.guc.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    void deleteBookById(Long id);
}
