package com.epidata.talks.dependencyinjection.adhoc.service;

import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.adhoc.container.Container;
import com.epidata.talks.dependencyinjection.base.service.ProjectService;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectServiceTest {

	private ProjectService service;
	
	@Before
	public void init() {
		Container container = new Container("/app-config.json");
		service = container.getBean("projectService");
	}
	
	@Test
	public void findByName() {
		Project project = service.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
	}
}
