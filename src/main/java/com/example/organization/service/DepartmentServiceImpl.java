package com.example.organization.service;

import com.example.organization.entity.Department;
import com.example.organization.entity.Directory;
import com.example.organization.repository.DepartmentRepository;
import com.example.organization.repository.DirectoryRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final DirectoryRepository directoryRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DirectoryRepository directoryRepository) {
        this.departmentRepository = departmentRepository;

        this.directoryRepository = directoryRepository;
    }

    @Override
    public void addDepartment(String name, String description, long directoryId) {
        Department department = new Department(name, description);
        Directory directory = this.directoryRepository.findById(directoryId);
        if (directory != null) {
            department.setDirectory(directory);
        }
        this.departmentRepository.save(department);
    }



    @Override
    public void editDepartment(long id, String description) {
        Department department = this.departmentRepository.findById(id);
        if (department != null) {
            department.setDescription(description);
            this.departmentRepository.save(department);
            System.out.println("Successfully edited department!");
        } else {
            System.out.println("Department does not exist!");
        }
    }

    @Override
    public void deleteDepartment(long id) {
        Department department = this.departmentRepository.findById(id);
        if (department != null) {
            this.departmentRepository.delete(department);
            System.out.println("Successfully deleted department");
        } else {
            System.out.println("Department does not exist!");
        }
    }
}
