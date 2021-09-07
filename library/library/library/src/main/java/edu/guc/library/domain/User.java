package edu.guc.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@MappedSuperclass
@NoArgsConstructor
public class User {

    @Column(name = "firstName", nullable = false)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @Getter
    @Setter
    private String lastName;

    @Id
    @Column(name = "email", nullable = false)
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Column(name = "age", nullable = false)
    @Getter
    @Setter
    private int age;

    public User(String firstName, String lastName, String email, String password, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}