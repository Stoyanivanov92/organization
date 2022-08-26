package com.example.organization.service;


import com.example.organization.entity.Directory;
import com.example.organization.repository.DirectoryRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    private final DirectoryRepository directoryRepository;


    public DirectoryServiceImpl(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;

    }

    @Override
    public void addDirectory(String name, String description) {
        Directory directory = new Directory(name, description);
        directoryRepository.save(directory);
    }

    @Override
    public void editDirectory(long id, String description) {
        Directory directory = this.directoryRepository.findById(id);
        if (directory != null) {
            directory.setDescription(description);
            this.directoryRepository.save(directory);
            System.out.println("Successfully edited directory!");
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    @Override
    public void deleteDirectory(long id) {
        Directory directory = this.directoryRepository.findById(id);
        if (directory != null) {
            this.directoryRepository.delete(directory);
            System.out.println("Successfully deleted!");
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}
