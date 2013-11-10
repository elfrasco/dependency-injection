package com.epidata.talks.dependencyinjection.spring.dao;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/app-config.xml"})
public class ProjectDAOTest {
	
	private static final Logger logger = Logger.getLogger(ProjectDAOTest.class);

	@Autowired
	private ProjectDAO projectDAO;

	@Test
	public void findByName() {
		Project project = projectDAO.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
		logger.debug("Project: " + project.getName());
		logger.debug("Team size: " + project.getTeam().size());
	}

}
