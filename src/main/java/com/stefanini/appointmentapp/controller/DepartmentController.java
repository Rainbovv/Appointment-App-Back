package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.Department;
import com.stefanini.appointmentapp.service.DepartmentService;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api")
public class DepartmentController {
    final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/departments")
    public Set<Department> getList() {
        return departmentService.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/departments/{departmentId}")
    public Department getOne(@PathVariable long departmentId) {
        return departmentService.findById(departmentId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value ="/departments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/departments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department update(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/departments/{departmentId}")
    public void delete(@PathVariable long departmentId) {
        departmentService.delete(departmentId);
    }
}
