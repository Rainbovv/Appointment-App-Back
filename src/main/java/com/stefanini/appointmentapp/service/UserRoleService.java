package com.stefanini.appointmentapp.service;

import java.util.Set;

import com.stefanini.appointmentapp.entities.UserRole;

public interface UserRoleService {
	Set<UserRole> findAll();
	
	UserRole create(UserRole userRole);
	
	UserRole update(UserRole userRole);
	
	UserRole findById(Long id);
	
	void delete(UserRole userRole);
}
