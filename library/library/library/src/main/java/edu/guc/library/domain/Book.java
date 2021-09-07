package edu.guc.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity()
@Table(name = "book")
@NoArgsConstructor
public class Book {

    @Id @Getter @Setter
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(name = "title", nullable = false)
    private String title;

    @Getter @Setter
    @Column(name="borrowed", nullable =false)
    private Boolean borrowed;

    @Getter @Setter
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Getter @Setter
    @ManyToMany(mappedBy ="books")
    private Collection<Publisher> publisher;

    @Getter @Setter
    @ManyToMany(mappedBy = "books")
    private Collection<Author> authors;

    @Getter @Setter
    @Column(name = "publishing_date", nullable = false)
    private Date publishingDate;

    public Book(String title, Boolean borrowed, String isbn, Collection<Publisher> publisher, Collection<Author> authors, Date publishingDate) {
        this.title = title;
        this.borrowed = borrowed;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
        this.publishingDate = publishingDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", borrowed=" + borrowed +
                ", isbn='" + isbn + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                ", publishingDate=" + publishingDate +
                '}';
    }
}