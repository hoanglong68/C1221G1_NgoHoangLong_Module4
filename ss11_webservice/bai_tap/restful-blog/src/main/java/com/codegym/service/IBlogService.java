package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAllByName(String name, Pageable pageable);

//    Page<Blog> findAllByName(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    List<Blog> findByName(String name);

    Blog findById(Integer id);

    void delete(Blog blog);
}
