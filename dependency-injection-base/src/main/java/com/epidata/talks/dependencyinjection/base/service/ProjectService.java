package com.epidata.talks.dependencyinjection.base.service;

import com.epidata.talks.dependencyinjection.model.Project;

public interface ProjectService {

	Project findByName(String name);
	
}
