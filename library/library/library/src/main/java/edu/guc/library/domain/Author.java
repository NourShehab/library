package edu.guc.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity()
@Table(name = "author")
@NoArgsConstructor
public class Author extends Person{

    @Getter@Setter
    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(
                    name = "author_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            )
    )
    private Collection<Book> books;

    public Author(String name, int age, Collection<Book> books) {
        super(name, age);
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }
}
