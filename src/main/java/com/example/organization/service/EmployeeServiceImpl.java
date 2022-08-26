package com.example.organization.service;

import com.example.organization.entity.Department;
import com.example.organization.entity.Directory;
import com.example.organization.entity.Employee;
import com.example.organization.repository.DepartmentRepository;
import com.example.organization.repository.DirectoryRepository;
import com.example.organization.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final DirectoryRepository directoryRepository;

    public EmployeeServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, DirectoryRepository directoryRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.directoryRepository = directoryRepository;
    }


    @Override
    public void addEmployee(String firstName, String lastName, String identicalNumber, int age, String position, long departmentId, long directoryId) {
        Employee employee = new Employee(firstName, lastName, identicalNumber, age, position);
        Department department = this.departmentRepository.findById(departmentId);
        Directory directory = this.directoryRepository.findById(directoryId);
        if (department != null && position.equals("Employee")) {
            employee.setDepartment(department);
        }
        if (directory != null && position.equals("Director")) {
            if (directory.getEmployee() == null) {
                employee.setDirectory(directory);
                System.out.printf("Successfully added Director %s to Directory %s%n!", employee.getFirstName(), directory.getName());
            } else {
                System.out.println("This Directory has already Director!");
                employee.setPosition("Employee");
                employee.setDepartment(department);
            }

        }
        employeeRepository.save(employee);
    }



    @Override
    public void editEmployee(long id) {
        Employee employeeById = employeeRepository.findEmployeeById(id);
        if (employeeById != null) {
            employeeById.setAge(employeeById.getAge() + 2);
            employeeRepository.save(employeeById);
            System.out.println("Successfully edited employee!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employeeById = employeeRepository.findEmployeeById(id);
        if (employeeById != null) {
            employeeRepository.delete(employeeById);
            System.out.println("Successfully deleted employee!");
        } else {
            System.out.println("Employee does not exist!");
        }
    }
}
