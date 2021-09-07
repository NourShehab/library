package edu.guc.library.web.rest;

import edu.guc.library.domain.Author;
import edu.guc.library.domain.Borrowing;
import edu.guc.library.service.AuthorService;
import edu.guc.library.service.BorrowingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/view")
    public Borrowing getBorrowingById(@RequestParam("id") Long id) {
        var borrowing = borrowingService.findById(id);

        if (borrowing.isPresent()) {
            return borrowing.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "borrowing transaction not found "
            );
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Borrowing create(@RequestBody Borrowing borrowing) {

        if (borrowing.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this Id already exists");
        }

        var borrowingFromService = this.borrowingService.save(borrowing);
        if (borrowingFromService.isPresent()) {
            return borrowingFromService.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "please provide a valid transaction structure and please verify that the id is unique"
            );
        }
    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBorrowingTransaction(@RequestParam("id") Long id) {
        var borrowing = borrowingService.findById(id);

        if (borrowing.isPresent()) {
            borrowingService.delete(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "transaction not found"
            );

        }
    }

    @PutMapping("/update")
    Borrowing updateBorrowing(@RequestBody Borrowing borrowing) {
        if (borrowing.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide an id to update the borrowing transaction");
        }

        return borrowingService.save(borrowing)
                .orElseGet(() ->
                {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "transaction not found"
                    );
                });
    }
}

