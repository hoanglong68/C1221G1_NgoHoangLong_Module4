package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name like :name_search", nativeQuery = true)
    List<Blog> findAllByName(@Param("name_search") String name);

    Page<Blog> findAllByNameContainingOrderByNameAsc(String name, Pageable pageable);

//    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
}
