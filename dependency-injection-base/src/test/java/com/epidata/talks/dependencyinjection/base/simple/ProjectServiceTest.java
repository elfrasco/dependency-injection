package com.epidata.talks.dependencyinjection.base.simple;

import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectServiceTest {

	private ProjectService service;
	
	@Before
	public void init() {
		service = new ProjectService();
	}
	
	@Test
	public void findByName() {
		Project project = service.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
	}
}
