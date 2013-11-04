package com.epidata.talks.dependencyinjection.javaee.dao;

import javax.enterprise.context.ApplicationScoped;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.repository.JSONProjectRepository;
import com.epidata.talks.dependencyinjection.model.repository.ProjectRepository;

@ApplicationScoped
public class ProjectDAO {
	
	private ProjectRepository projectRepository;
	
	public ProjectDAO() {
		projectRepository = new JSONProjectRepository();
	}

	public Project findByName(String name) {
		return projectRepository.findByName(name);
	}

}
