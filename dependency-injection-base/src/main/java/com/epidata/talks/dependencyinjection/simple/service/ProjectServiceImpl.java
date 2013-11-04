package com.epidata.talks.dependencyinjection.simple.service;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.simple.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.simple.dao.ProjectDAOImpl;

public class ProjectServiceImpl implements ProjectService {
	
	private ProjectDAO dao;
	
	public ProjectServiceImpl() {
		dao = new ProjectDAOImpl();
	}

	@Override
	public Project findByName(String name) {
		return dao.findByName(name);
	}

}
