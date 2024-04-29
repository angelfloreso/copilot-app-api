package com.apex.copilotapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.apex.copilotapi.entities.Departments;

@Repository
public interface DepartmentRepository extends CrudRepository<Departments, Long> {
    
}