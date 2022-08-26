package com.example.organization.repository;

import com.example.organization.entity.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {

    Directory findById(long id);
}
