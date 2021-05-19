package com.stefanini.appointmentapp.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

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
	
	@Transactional
	@Override
	public UserRole create(UserRole userRole) {
		return userRoleDAO.create(userRole);
	}

	@Transactional
	@Override
	public UserRole update(UserRole userRole) {
		return userRoleDAO.update(userRole);
	}

	@Override
	public UserRole findById(Long id) {
		return userRoleDAO.findById(id);
	}

	@Transactional
	@Override
	public void delete(UserRole userRole) {
		userRoleDAO.delete(userRole);
	}

}
