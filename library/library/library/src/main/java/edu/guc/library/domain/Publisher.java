package edu.guc.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "publisher")
@NoArgsConstructor
public class Publisher extends Person{
    @Getter@Setter
    @ManyToMany
    @JoinTable(
            name = "publisher_book",
            joinColumns = @JoinColumn(
                    name = "publisher_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            )
    )
    private Collection<Book> books;

    public Publisher(String name, int age, Collection<Book> books) {
        super(name, age);
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "books=" + books +
                '}';
    }
}
