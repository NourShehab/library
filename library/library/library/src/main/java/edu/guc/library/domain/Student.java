package edu.guc.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Role;

import javax.annotation.security.DeclareRoles;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "student")
@DeclareRoles("Student")
public class Student extends User{
    @Getter @Setter
    @Column(name = "facultyDepartment", nullable = false)
    private String facultyDepartment;

    @Getter @Setter
    @Column(name = "yearInProgress", nullable = false)
    private String yearInProgress;

    public Student(String firstName, String lastName, String email, String password, int age, String facultyDepartment, String yearInProgress) {
        super(firstName, lastName, email, password, age);
        this.facultyDepartment = facultyDepartment;
        this.yearInProgress = yearInProgress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "facultyDepartment='" + facultyDepartment + '\'' +
                ", yearInProgress='" + yearInProgress + '\'' +
                '}';
    }
}
