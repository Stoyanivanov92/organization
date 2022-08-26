package com.example.organization.entity;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
    private String name;
    private String description;
    private Set<Employee> employees;
    private Directory directory;

    public Department() {

    }

    public Department(String name, String description) {
        this.name = name;
        this.description = description;


    }

    @ManyToOne
    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
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
}
