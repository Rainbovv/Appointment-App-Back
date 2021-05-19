package com.stefanini.appointmentapp.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.stefanini.appointmentapp.dao.UserRoleDAO;
import com.stefanini.appointmentapp.entities.UserRole;
import com.stefanini.appointmentapp.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	private final UserRoleDAO userRoleDAO;
	
	

	public UserRoleServiceImpl(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	@Override
	public Set<UserRole> findAll() {
		return userRoleDAO.findAll();
	}

	@Override
	public UserRole create(UserRole userRole) {
		return userRoleDAO.create(userRole);
	}

	@Override
	public UserRole update(UserRole userRole) {
		return userRoleDAO.update(userRole);
	}

	@Override
	public UserRole findById(Long id) {
		return userRoleDAO.findById(id);
	}

	@Override
	public void delete(UserRole userRole) {
		userRoleDAO.delete(userRole);
	}

}
