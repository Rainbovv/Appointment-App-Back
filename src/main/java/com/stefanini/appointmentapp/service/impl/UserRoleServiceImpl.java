package com.stefanini.appointmentapp.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import com.stefanini.appointmentapp.annotation.Loggable;
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

	@Loggable
	@Override
	public List<UserRole> findAll() {
		return userRoleDAO.findAll();
	}

	@Loggable
	@Transactional
	@Override
	public UserRole create(UserRole userRole) {
		return userRoleDAO.create(userRole);
	}

	@Loggable
	@Transactional
	@Override
	public UserRole update(UserRole userRole) {
		return userRoleDAO.update(userRole);
	}

	@Loggable
	@Override
	public UserRole findById(Long id) {
		return userRoleDAO.findById(id);
	}

	@Loggable
	@Transactional
	@Override
	public void delete(UserRole userRole) {
		userRoleDAO.delete(userRole);
	}

}
