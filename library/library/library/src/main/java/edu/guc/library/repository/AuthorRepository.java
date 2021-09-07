package edu.guc.library.repository;

import edu.guc.library.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findOneByName(String name);
    void deleteAuthorByName(String name);
}
