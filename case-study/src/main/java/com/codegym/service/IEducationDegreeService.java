package com.codegym.service;

import com.codegym.model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
}
