package com.epidata.talks.dependencyinjection.simple.dao;

import org.junit.Before;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectDAOTest {

	private ProjectDAO projectDAO;

	@Before
	public void init() {
		projectDAO = new ProjectDAOImpl();
	}
	
	@Test
	public void findByName() {
		Project project = projectDAO.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
	}
	
}
