package edu.guc.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.security.DeclareRoles;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "library_manager")
@DeclareRoles("LibraryManager")
public class LibraryManager extends User{

    @Getter
    @Setter
    @Column(name = "reporterName", nullable = false)
    private String reporterName;

    public LibraryManager(String firstName, String lastName, String email, String password, int age, String reporterName) {
        super(firstName, lastName, email, password, age);
        this.reporterName = reporterName;
    }

    @Override
    public String toString() {
        return "LibraryManager{" +
                "reporterName='" + reporterName + '\'' +
                '}';
    }
}
