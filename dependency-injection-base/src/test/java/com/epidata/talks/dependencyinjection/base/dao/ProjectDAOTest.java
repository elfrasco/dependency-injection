package com.epidata.talks.dependencyinjection.base.dao;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectDAOTest {

	private static final Logger logger = Logger.getLogger(ProjectDAOTest.class);
	
	private ProjectDAO projectDAO;

	@Before
	public void init() {
		projectDAO = new ProjectDAOImpl();
//		projectDAO = new ProjectDAOMock();
	}
	
	@Test
	public void findByName() {
		Project project = projectDAO.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
		logger.debug("Project: " + project.getName());
		logger.debug("Team size: " + project.getTeam().size());
	}
	
}
