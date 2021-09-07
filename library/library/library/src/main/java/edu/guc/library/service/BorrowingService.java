package edu.guc.library.service;

import edu.guc.library.domain.Author;
import edu.guc.library.domain.Borrowing;
import edu.guc.library.repository.BorrowingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("borrowingService")
@Transactional
public class BorrowingService {
    private BorrowingRepository borrowingRepository;

    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }
    public Optional<Borrowing> findById(Long id) {
        return this.borrowingRepository.findById(id);
    }

    public Optional<Borrowing> save(Borrowing borrowing) {
        var borrowingInDb = this.findById(borrowing.getId());

        if (borrowingInDb.isPresent()) {
            var borrowingInDbUnwrapped = borrowingInDb.get();
            if (borrowingInDbUnwrapped.getBook() != borrowing.getBook()) {
                borrowingInDbUnwrapped.setBook(borrowing.getBook());
            }

            if (borrowingInDbUnwrapped.getDateBorrowed() != borrowing.getDateBorrowed()) {
                borrowingInDbUnwrapped.setDateBorrowed(borrowing.getDateBorrowed());
            }
            if (borrowingInDbUnwrapped.getDateReturned() != borrowing.getDateReturned()) {
                borrowingInDbUnwrapped.setDateReturned(borrowing.getDateReturned());
            }
            if (borrowingInDbUnwrapped.getStudent() != borrowing.getStudent()) {
                borrowingInDbUnwrapped.setStudent(borrowing.getStudent());
            }

            return Optional.of(this.borrowingRepository.save(borrowingInDbUnwrapped));
        } else {
            return Optional.of(this.borrowingRepository.save(borrowing));
        }
    }

    public void delete(Long id) {this.borrowingRepository.deleteById(id); }
}


