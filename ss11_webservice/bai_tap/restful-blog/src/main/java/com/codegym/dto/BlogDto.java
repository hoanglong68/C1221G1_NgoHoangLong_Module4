package com.codegym.dto;

import lombok.Data;

@Data
public class BlogDto {
    private Integer id;
    private String name;
    private String content;
    private String summaryContent;
    private CategoryDto categoryDto;
}
