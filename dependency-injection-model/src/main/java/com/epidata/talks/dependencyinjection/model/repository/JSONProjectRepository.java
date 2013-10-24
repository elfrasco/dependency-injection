package com.epidata.talks.dependencyinjection.model.repository;

import java.io.InputStream;
import java.util.List;

import com.epidata.talks.dependencyinjection.model.Project;

public class JSONProjectRepository implements ProjectRepository {
	
	private static final String REPOSITORY_FILE = "/repositories/projects.json";

	private List<Project> projects;
	
	public JSONProjectRepository() {
		InputStream is = InputStreamUtil.openInputStream(REPOSITORY_FILE);
		projects = JSONObjectConverter.convertToObject(is, Project.class);
	}
	
	@Override
	public void save(Project project) {
	}

	@Override
	public Project findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
