package com.epidata.talks.dependencyinjection.javaee.service;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.base.service.ProjectService;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectServiceTest {
	
	private ProjectService service;
	
	@Before
	public void init() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		service = container.instance().select(ProjectService.class).get();
		weld.shutdown();
	}
	
	@Test
	public void findByName() {
		Project project = service.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
	}

}
