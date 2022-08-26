package com.example.organization.repository;

import com.example.organization.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
      Employee findEmployeeById(long id);
}
