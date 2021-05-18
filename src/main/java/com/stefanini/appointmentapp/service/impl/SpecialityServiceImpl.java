package com.stefanini.appointmentapp.service.impl;

import com.stefanini.appointmentapp.service.SpecialityService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class SpecialityServiceImpl implements SpecialityService {
    @PersistenceContext
    protected EntityManager entityManager;


}
