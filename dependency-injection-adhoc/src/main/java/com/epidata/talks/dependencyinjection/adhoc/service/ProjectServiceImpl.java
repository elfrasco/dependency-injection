package com.epidata.talks.dependencyinjection.adhoc.service;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.simple.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.simple.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	
	private ProjectDAO dao;
	
	@Override
	public Project findByName(String name) {
		return dao.findByName(name);
	}

	public ProjectDAO getDao() {
		return dao;
	}
	
	public void setDao(ProjectDAO dao) {
		this.dao = dao;
	}
}
