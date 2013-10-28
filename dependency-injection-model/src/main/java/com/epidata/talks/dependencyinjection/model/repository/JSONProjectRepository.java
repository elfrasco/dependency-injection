package com.epidata.talks.dependencyinjection.model.repository;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

import com.epidata.talks.dependencyinjection.model.Project;

public class JSONProjectRepository implements ProjectRepository {
	
	private static final String REPOSITORY_FILE = "/repositories/projects.json";

	private List<Project> projects;
	
	public JSONProjectRepository() {
		projects = JSONObjectConverter.convertToListOfObjects(REPOSITORY_FILE, Project.class);
	}
	
	@Override
	public void save(Project project) {
		projects.add(project);
		JSONObjectConverter.convertToJSONFile(REPOSITORY_FILE, projects);
	}

	@Override
	public Project findByName(String name) {
		
		if (StringUtils.isBlank(name)) {
			throw new RuntimeException("Search criteria cannot be EMPTY");
		}
		
		Project project = (Project) CollectionUtils.find(projects,
				new ProjectByNamePredicate(name));
		
		return project;
	}
	
	class ProjectByNamePredicate implements Predicate {
		
		private String name;
		
		public ProjectByNamePredicate(String name) {
			this.name = name;
		}

		@Override
		public boolean evaluate(Object project) {
			return name.equals(((Project) project).getName());
		}
		
	}

}
