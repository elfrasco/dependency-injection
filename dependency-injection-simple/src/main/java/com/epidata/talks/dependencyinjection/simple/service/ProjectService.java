package com.epidata.talks.dependencyinjection.simple.service;

import com.epidata.talks.dependencyinjection.model.Project;

public interface ProjectService {

	Project findByName(String name);
	
}
