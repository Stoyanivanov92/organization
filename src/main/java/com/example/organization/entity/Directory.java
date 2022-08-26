package com.example.organization.entity;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "directories")
public class Directory extends BaseEntity {
    private String name;
    private String description;
    private Set<Department> departments;
    private Employee employee;

    public Directory() {
    }

    public Directory(String name, String description) {
        this.name = name;
        this.description = description;

    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne(mappedBy = "directory")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
