package com.codegym.repository;

import com.codegym.model.BookLending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookLendingRepository extends JpaRepository<BookLending,String> {
}
