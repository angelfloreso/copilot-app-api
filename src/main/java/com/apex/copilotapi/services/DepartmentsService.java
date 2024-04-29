package com.apex.copilotapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apex.copilotapi.entities.Departments;
import com.apex.copilotapi.repositories.DepartmentRepository;
import com.apex.copilotapi.requests.DepartmentRequest;

import java.util.Optional;


@Service
public class DepartmentsService {

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentsService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Iterable<Departments> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Departments getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department not found with id: " + id));
    }

    public Departments createDepartment(DepartmentRequest department) {
        return departmentRepository.save(
            new Departments(department.getName())
        );
    }

    public Departments updateDepartment(Long id, DepartmentRequest department) {
        Optional<Departments> existingDepartment = departmentRepository.findById(id);
        if (existingDepartment.isPresent()) {
            Departments updatedDepartment = existingDepartment.get();
            updatedDepartment.setName(department.getName());
            // Set other properties as needed
            return departmentRepository.save(updatedDepartment);
        } else {
            throw new IllegalArgumentException("Department not found with id: " + id);
        }
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
