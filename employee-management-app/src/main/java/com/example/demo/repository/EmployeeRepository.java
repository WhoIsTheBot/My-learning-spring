package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    // Custom query to find employees by department
    List<Employee> findByDepartment(String department);

    // Custom query to find employees with salary greater than a specific amount
    @Query("{ 'salary' : { $gt: ?0 } }")
    List<Employee> findEmployeesWithSalaryGreaterThan(double salary);
}