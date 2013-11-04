package com.epidata.talks.dependencyinjection.base.service;

import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.base.dao.ProjectDAOImpl;
import com.epidata.talks.dependencyinjection.model.Project;

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
