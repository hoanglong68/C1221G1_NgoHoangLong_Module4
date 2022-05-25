package com.codegym.repository;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContaining
            (String name, String address, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionId
            (String name, String address, Integer position, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEducationDegree_EducationDegreeId
            (String name, String address, Integer educationDegree, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndDivision_DivisionId
            (String name, String address, Integer division, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEducationDegree_EducationDegreeId
            (String name, String address, Integer position, Integer educationDegree, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndDivision_DivisionId
            (String name, String address, Integer position, Integer division, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEducationDegree_EducationDegreeIdAndDivision_DivisionId
            (String name, String address, Integer educationDegree, Integer division, Pageable pageable);

    Page<Employee>
    findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEducationDegree_EducationDegreeIdAndDivision_DivisionId
            (String name, String address, Integer position, Integer educationDegree, Integer division, Pageable pageable);
}
