package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EducationDegreeId;
    private String EducationDegreeName;

    @OneToMany(mappedBy = "educationDegree")
    List<Employee> employeeList;

    public EducationDegree() {
    }

    public Integer getEducationDegreeId() {
        return EducationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        EducationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return EducationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        EducationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
