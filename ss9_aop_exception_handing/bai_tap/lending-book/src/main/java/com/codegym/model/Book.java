package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;
    private String nameBook;
    private String author;
    private Integer quantity;

    @OneToMany(mappedBy = "book",orphanRemoval = true)
    private List<BookLending> bookLendingList;
}
