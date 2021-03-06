package com.stefanini.appointmentapp.controller;

import java.util.List;
import com.stefanini.appointmentapp.annotation.Loggable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.service.UserRoleService;

@RestController
@RequestMapping(UserRoleController.BASE_URL)
public class UserRoleController {
	
	public static final String BASE_URL = "/api/roles";
	
	private final UserRoleService roleService;

	public UserRoleController(UserRoleService roleService) {
		this.roleService = roleService;
	}

	@Loggable
	@GetMapping
	public List<UserRole> getRoles() {
		return roleService.findAll();
	}

	@Loggable
	@GetMapping("/{id}")
	public UserRole getRoleById(@PathVariable Long id) {
		return roleService.findById(id);
	}

	@Loggable
	@PostMapping
	public UserRole createNewRole(@RequestBody UserRole role) {
		return roleService.create(role);
	}

	@Loggable
	@PutMapping("/{id}")
	public UserRole updateRole(@RequestBody UserRole role) {
		return roleService.update(role);
	}

	@Loggable
	@DeleteMapping("/{id}")
	public void deleteRole(@RequestBody UserRole role) {
		roleService.delete(role);
	}
	
	
}
