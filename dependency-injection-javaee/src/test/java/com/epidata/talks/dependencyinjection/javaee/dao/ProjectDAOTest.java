package com.epidata.talks.dependencyinjection.javaee.dao;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectDAOTest {

	private ProjectDAO projectDAO;
	
	@Before
	public void init() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		projectDAO = container.instance().select(ProjectDAO.class).get();
		weld.shutdown();
	}
	
	@Test
	public void findByName() {
		Project project = projectDAO.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
	}

}
