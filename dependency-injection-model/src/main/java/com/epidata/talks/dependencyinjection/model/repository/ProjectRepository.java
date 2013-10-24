package com.epidata.talks.dependencyinjection.model.repository;

import com.epidata.talks.dependencyinjection.model.Project;


public interface ProjectRepository {

	void save(Project project);
	Project findByName(String name);
	
}