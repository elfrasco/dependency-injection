package com.epidata.talks.dependencyinjection.model.repository;

import org.junit.Assert;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class ProjectRepositoryTest {
	
	private ProjectRepository projectRepository = new JSONProjectRepository();

	@Test
	public void find() {
		Project project = projectRepository.findByName("Predictive Engine");
		Assert.assertNotNull(project);
		ProjectAsserts.assertProject(project);
	}
	
}
