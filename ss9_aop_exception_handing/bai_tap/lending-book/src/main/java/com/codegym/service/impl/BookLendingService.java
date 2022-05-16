package com.codegym.service.impl;

import com.codegym.model.BookLending;
import com.codegym.repository.IBookLendingRepository;
import com.codegym.service.IBookLendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLendingService implements IBookLendingService {
    @Autowired
    IBookLendingRepository iBookLendingRepository;

    @Override
    public void save(BookLending bookLending) {
        iBookLendingRepository.save(bookLending);
    }

    @Override
    public BookLending findById(String idBookLend) {
        return iBookLendingRepository.findById(idBookLend).orElse(null);
    }

    @Override
    public void delete(BookLending bookLending) {
        iBookLendingRepository.delete(bookLending);
    }
}
