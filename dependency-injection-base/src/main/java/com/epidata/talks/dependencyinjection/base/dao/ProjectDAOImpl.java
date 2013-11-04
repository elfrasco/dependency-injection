package com.epidata.talks.dependencyinjection.base.dao;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.repository.JSONProjectRepository;
import com.epidata.talks.dependencyinjection.model.repository.ProjectRepository;

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
