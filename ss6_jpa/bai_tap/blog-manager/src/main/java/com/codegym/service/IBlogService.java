package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    List<Blog> findByName(String name);

    Blog findById(Integer id);

    void delete(Blog blog);
}
