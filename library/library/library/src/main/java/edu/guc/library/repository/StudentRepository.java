package edu.guc.library.repository;

import edu.guc.library.domain.LibraryManager;
import edu.guc.library.domain.Student;
import edu.guc.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    Optional <Student> findByEmail(String email);

    void deleteStudentByEmail(String email);


}
