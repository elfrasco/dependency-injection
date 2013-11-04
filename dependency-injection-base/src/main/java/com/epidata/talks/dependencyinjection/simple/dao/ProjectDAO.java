package com.epidata.talks.dependencyinjection.simple.dao;

import com.epidata.talks.dependencyinjection.model.Project;

public interface ProjectDAO {

	Project findByName(String name);
	
}
