package com.epidata.talks.dependencyinjection.base.dao;

import com.epidata.talks.dependencyinjection.model.Project;

public interface ProjectDAO {

	Project findByName(String name);
	
}
