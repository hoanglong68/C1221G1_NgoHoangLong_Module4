package com.codegym.service;

import com.codegym.model.BookLending;

public interface IBookLendingService {
    void save(BookLending bookLending);

    BookLending findById(String idBookLend);

    void delete(BookLending bookLending);
}
