package com.epidata.talks.dependencyinjection.model.repository;

import com.epidata.talks.dependencyinjection.model.Project;


public interface ProjectRepository {

	Project findByName(String name);
	
}