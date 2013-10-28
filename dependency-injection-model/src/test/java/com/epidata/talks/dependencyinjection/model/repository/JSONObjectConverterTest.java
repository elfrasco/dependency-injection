package com.epidata.talks.dependencyinjection.model.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

public class JSONObjectConverterTest {

	private static final String REPOSITORY_FILE = "/repositories/projects.json";
	
	@Test
	public void convertToObject() {
		
		List<Project> projects = JSONObjectConverter.convertToListOfObjects(REPOSITORY_FILE, Project.class);
		
		Assert.assertNotNull(projects);
		Assert.assertEquals(projects.size(), 2);
		
		for (Project project : projects) {
			ProjectAsserts.assertProject(project);
		}
	}
}
