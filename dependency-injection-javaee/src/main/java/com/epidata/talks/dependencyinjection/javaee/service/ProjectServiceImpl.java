package com.epidata.talks.dependencyinjection.javaee.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.base.service.ProjectService;
import com.epidata.talks.dependencyinjection.model.Project;

@Singleton
public class ProjectServiceImpl implements ProjectService {
	
	@Inject
	private ProjectDAO dao;
	
	@Override
	public Project findByName(String name) {
		return dao.findByName(name);
	}

}
