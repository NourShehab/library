package edu.guc.library.service;

import edu.guc.library.domain.Author;
import edu.guc.library.domain.Student;
import edu.guc.library.domain.User;
import edu.guc.library.repository.LibraryManagerRepository;
import edu.guc.library.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserDetailsService {

    private StudentRepository studentRepository;
    private LibraryManagerRepository libraryManagerRepository;

    public Optional<Student> findStudentByEmail(String email) {
        if (studentRepository.findByEmail(email).isPresent())
            return this.studentRepository.findByEmail(email);
        else
            return null;
    }
    public Optional<? extends User> findByEmail(String email) {
        if (studentRepository.findByEmail(email).isPresent())
            return this.studentRepository.findByEmail(email);
        else if (libraryManagerRepository.findByEmail(email).isPresent()){
            return this.libraryManagerRepository.findByEmail(email);
        }
            return null;
    }

    public Optional<Student> save(Student student) {
        var studentInDb = this.findStudentByEmail(student.getEmail());

        if (studentInDb.isPresent()) {
            var studentInDbUnwrapped = studentInDb.get();
            if (studentInDbUnwrapped.getAge() != student.getAge()) {
                studentInDbUnwrapped.setAge(student.getAge());
            }

            if (studentInDbUnwrapped.getFirstName() != student.getFirstName()) {
                studentInDbUnwrapped.setFirstName(student.getFirstName());
            }
            if (studentInDbUnwrapped.getLastName() != student.getLastName()) {
                studentInDbUnwrapped.setLastName(student.getLastName());
            }

            if (studentInDbUnwrapped.getPassword() != student.getPassword()) {
                studentInDbUnwrapped.setPassword(student.getPassword());
            }
            if (studentInDbUnwrapped.getYearInProgress() != student.getYearInProgress()) {
                studentInDbUnwrapped.setYearInProgress(student.getYearInProgress());
            }
            if (studentInDbUnwrapped.getYearInProgress() != student.getYearInProgress()) {
                studentInDbUnwrapped.setYearInProgress(student.getYearInProgress());
            }
            if (studentInDbUnwrapped.getFacultyDepartment() != student.getFacultyDepartment()) {
                studentInDbUnwrapped.setFacultyDepartment(student.getFacultyDepartment());
            }
            return Optional.of(this.studentRepository.save(studentInDbUnwrapped));
        } else {
            return Optional.of(this.studentRepository.save(student));
        }
    }

    public void delete(String email) {this.studentRepository.deleteStudentByEmail(email);
    }
}
