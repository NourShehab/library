package edu.guc.library.repository;

import edu.guc.library.domain.LibraryManager;
import edu.guc.library.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryManagerRepository extends JpaRepository<LibraryManager, String> {
    Optional<LibraryManager> findByEmail(String email);

}
