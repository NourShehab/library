package edu.guc.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "borrowing")
@NoArgsConstructor
public class Borrowing {

    @Id @Getter @Setter
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @ManyToOne
    private Student student;

    @Getter @Setter
    @ManyToOne
    private Book book;

    @Getter @Setter
    @Column(name = "date_borrowed", nullable = false)
    private Date dateBorrowed;

    @Getter @Setter
    @Column(name = "date_returned", nullable = false)
    private Date dateReturned;

    public Borrowing(Student student, Book book, Date dateBorrowed, Date dateReturned) {
        this.student = student;
        this.book = book;
        this.dateBorrowed = dateBorrowed;
        this.dateReturned = dateReturned;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "id=" + id +
                ", student=" + student +
                ", book=" + book +
                ", dateBorrowed=" + dateBorrowed +
                ", dateReturned=" + dateReturned +
                '}';
    }
}
