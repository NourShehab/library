package edu.guc.library.web.rest;

import edu.guc.library.domain.Student;
import edu.guc.library.service.UserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
    private UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @GetMapping("/view")
    public Student getStudentByEmail (@RequestParam("email") String email) {
        var student = userDetailsService.findStudentByEmail(email);

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "author not found - Just a test"
            );
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
            System.out.println("entered");
        if (student.getEmail() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this email already exists");
        }

        var studentFromService = this.userDetailsService.save(student);
        if (studentFromService.isPresent()) {
            return studentFromService.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "please provide a valid student structure and please verify that the email is unique"
            );
        }
    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent (@RequestParam("email") String email) {
        var student = userDetailsService.findStudentByEmail(email);

        if (student.isPresent()) {
            userDetailsService.delete(email);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "student not found"
            );

        }
    }

    @PutMapping("/update")
    Student updateStudent(@RequestBody Student student) {
        if (student.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide an email to update the student");
        }

        return userDetailsService.save(student)
                .orElseGet(() ->
                {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "student not found"
                    );
                });
    }
}
