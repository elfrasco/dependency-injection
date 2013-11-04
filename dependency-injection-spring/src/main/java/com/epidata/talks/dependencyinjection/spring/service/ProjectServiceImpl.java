package com.epidata.talks.dependencyinjection.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.base.service.ProjectService;
import com.epidata.talks.dependencyinjection.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDAO dao;
	
	@Override
	public Project findByName(String name) {
		return dao.findByName(name);
	}

}
