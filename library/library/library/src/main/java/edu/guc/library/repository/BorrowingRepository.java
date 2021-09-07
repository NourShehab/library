package edu.guc.library.repository;

import edu.guc.library.domain.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    Optional<Borrowing> findById(Long id);
    void deleteById(Long id);
}
