package com.example.organization.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private String identicalNumber;
    private int age;
    private String position;
    private Department department;
    private Directory directory;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String identicalNumber, int age, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identicalNumber = identicalNumber;
        this.age = age;
        this.position = position;

    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "identical_number", unique = true)
    public String getIdenticalNumber() {
        return identicalNumber;
    }

    public void setIdenticalNumber(String identicalNumber) {
        this.identicalNumber = identicalNumber;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @ManyToOne
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToOne
    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }
}
