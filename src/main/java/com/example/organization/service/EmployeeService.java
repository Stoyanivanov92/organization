package com.example.organization.service;



public interface EmployeeService {

    void addEmployee(String firstName, String lastName, String identicalNumber, int age, String position, long departmentId, long directoryId);

    void editEmployee(long id);

    void deleteEmployee(long id);

}
