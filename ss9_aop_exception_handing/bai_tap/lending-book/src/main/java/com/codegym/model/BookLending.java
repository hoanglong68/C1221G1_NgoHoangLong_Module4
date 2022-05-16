package com.codegym.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class BookLending {
    @Id
    //  0->89999+10000
    private String idBookLending;
    private String nameBookLend;
    @ManyToOne
    @JoinColumn(name = "id_book",referencedColumnName = "idBook")
    private Book book;
}
