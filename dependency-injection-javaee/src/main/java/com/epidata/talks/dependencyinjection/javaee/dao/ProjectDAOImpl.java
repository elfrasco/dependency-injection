package com.epidata.talks.dependencyinjection.javaee.dao;

import javax.inject.Singleton;

import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.repository.JSONProjectRepository;
import com.epidata.talks.dependencyinjection.model.repository.ProjectRepository;

@Singleton
public class ProjectDAOImpl implements ProjectDAO {

	private ProjectRepository projectRepository;
	
	public ProjectDAOImpl() {
		projectRepository = new JSONProjectRepository();
	}

	@Override
	public Project findByName(String name) {
		return projectRepository.findByName(name);
	}

}
