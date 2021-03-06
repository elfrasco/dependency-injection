package com.epidata.talks.dependencyinjection.base.service;

import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.base.service.ProjectService;
import com.epidata.talks.dependencyinjection.base.service.ProjectServiceImpl;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectServiceTest {

	private ProjectService service;
	
	@Before
	public void init() {
		service = new ProjectServiceImpl();
	}
	
	@Test
	public void findByName() {
		Project project = service.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
	}
}
