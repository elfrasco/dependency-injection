package com.epidata.talks.dependencyinjection.adhoc.service;

import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.base.service.ProjectService;
import com.epidata.talks.dependencyinjection.model.Project;

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
