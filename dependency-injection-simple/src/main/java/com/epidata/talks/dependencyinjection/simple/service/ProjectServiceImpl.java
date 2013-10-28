package com.epidata.talks.dependencyinjection.simple.service;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.simple.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.simple.dao.ProjectDAOImpl;

public class ProjectServiceImpl implements ProjectService {
	
	private ProjectDAO projectDAO;
	
	public ProjectServiceImpl() {
		projectDAO = new ProjectDAOImpl();
	}

	@Override
	public Project findByName(String name) {
		return projectDAO.findByName(name);
	}

}
