package com.apex.copilotapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apex.copilotapi.entities.Departments;
import com.apex.copilotapi.requests.DepartmentRequest;
import com.apex.copilotapi.services.DepartmentsService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1")
public class DepartmentsController {
    
    @Autowired
    private DepartmentsService departmentsService;

    @ApiOperation(value = "Get all departments", notes = "Get all departments from the database")
    @GetMapping(value = "/departments")
    public @ResponseBody Iterable getAllDepartments(){
        return departmentsService.getAllDepartments();
    }

    @GetMapping(value = "/department/{id}")
    public @ResponseBody Departments getDepartment(@PathVariable final long id){
        return departmentsService.getDepartmentById(id);
    }

    @PostMapping(value = "/department")
    public @ResponseBody void addDepartment(@RequestBody final DepartmentRequest department){
        departmentsService.createDepartment(department);
    }

    @PutMapping(value = "/department/{id}")
    public @ResponseBody void editDepartment(@PathVariable final long id, @RequestBody final DepartmentRequest department){
        departmentsService.updateDepartment(id, department);
    }

    @DeleteMapping(value = "/department/{id}")
    public @ResponseBody void deleteDepartment(@PathVariable final long id){
        departmentsService.deleteDepartment(id);
    }
    
}
