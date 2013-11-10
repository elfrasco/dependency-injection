package com.epidata.talks.dependencyinjection.base.simple;

import com.epidata.talks.dependencyinjection.model.Project;

public class ProjectService {
	
	private ProjectDAO dao;
	
	public ProjectService() {
		dao = new ProjectDAO();
	}

	public Project findByName(String name) {
		return dao.findByName(name);
	}

}
