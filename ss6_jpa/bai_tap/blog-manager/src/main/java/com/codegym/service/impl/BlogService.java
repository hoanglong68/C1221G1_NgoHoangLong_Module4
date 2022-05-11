package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

        @Override
    public Page<Blog> findAllByName(String name, Pageable pageable) {
        return iBlogRepository.findAllByNameContainingOrderByNameAsc(name, pageable);
    }
//    @Override
//    public Page<Blog> findAllByName(String name, Pageable pageable) {
//        return iBlogRepository.findAllByNameContaining(name, pageable);
//    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findByName(String name) {
        name = '%' + name + '%';
        return iBlogRepository.findAllByName(name);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }
}
