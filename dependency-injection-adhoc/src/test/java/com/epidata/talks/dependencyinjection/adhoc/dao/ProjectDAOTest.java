package com.epidata.talks.dependencyinjection.adhoc.dao;

import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.adhoc.container.Container;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;
import com.epidata.talks.dependencyinjection.simple.dao.ProjectDAO;

public class ProjectDAOTest {

	private ProjectDAO projectDAO;

	@Before
	public void init() {
		Container container = new Container("/app-config.json");
		projectDAO = container.getBean("projectDAO");
	}
	
	@Test
	public void findByName() {
		Project project = projectDAO.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
	}

}
