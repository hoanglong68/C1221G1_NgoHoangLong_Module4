package com.codegym.repository;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEmployeeStatus
            (String name, String address, Boolean status,Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEmployeeStatus
            (String name, String address, Integer position,Boolean status, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEducationDegree_EducationDegreeIdAndEmployeeStatus
            (String name, String address, Integer educationDegree, Boolean status,Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndDivision_DivisionIdAndEmployeeStatus
            (String name, String address, Integer division, Boolean status,Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEducationDegree_EducationDegreeIdAndEmployeeStatus
            (String name, String address, Integer position, Integer educationDegree, Boolean status,Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndDivision_DivisionIdAndEmployeeStatus
            (String name, String address, Integer position, Integer division, Boolean status,Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEducationDegree_EducationDegreeIdAndDivision_DivisionIdAndEmployeeStatus
            (String name, String address, Integer educationDegree, Integer division, Boolean status,Pageable pageable);

    Page<Employee>
    findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEducationDegree_EducationDegreeIdAndDivision_DivisionIdAndEmployeeStatus
            (String name, String address, Integer position, Integer educationDegree, Integer division,Boolean status, Pageable pageable);
}
