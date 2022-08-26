package com.example.organization.service;

public interface DepartmentService {
    void addDepartment(String name, String description, long directoryId);

    void editDepartment(long id, String description);

    void deleteDepartment(long id);
}
