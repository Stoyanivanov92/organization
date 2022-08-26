package com.example.organization.service;

public interface DirectoryService {

    void addDirectory(String name, String description);

    void editDirectory(long id, String description);

    void deleteDirectory(long id);
}
