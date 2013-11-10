package com.epidata.talks.dependencyinjection.adhoc.dao;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.adhoc.container.Container;
import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectDAOTest {
	
	private static final Logger logger = Logger.getLogger(ProjectDAOTest.class);

	private ProjectDAO projectDAO;

	@Before
	public void init() {
		Container container = new Container("/app-config.json");
//		Container container = new Container("/app-config-mock.json");
		projectDAO = container.getBean("projectDAO");
	}
	
	@Test
	public void findByName() {
		Project project = projectDAO.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
		logger.debug("Project: " + project.getName());
		logger.debug("Team size: " + project.getTeam().size());
	}

}
