package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.entities.Department;
import com.stefanini.appointmentapp.service.DepartmentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DepartmentController {
    final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Loggable
    @GetMapping("/departments")
    public List<Department> getList() {
        return departmentService.findAll();
    }

    @Loggable
    @GetMapping("/departments/{departmentId}")
    public Department getOne(@PathVariable long departmentId) {
        return departmentService.findById(departmentId);
    }

    @Loggable
    @PostMapping(value ="/departments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @Loggable
    @PutMapping(value = "/departments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department update(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @Loggable
    @DeleteMapping(value = "/departments/{departmentId}")
    public void delete(@PathVariable long departmentId) {
        departmentService.delete(departmentId);
    }
}
