package com.epidata.talks.dependencyinjection.model.repository;

import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.model.Project;

public class JSONObjectConverterTest {

	private static final String REPOSITORY_FILE = "/repositories/projects.json";
	
	@Test
	public void convertToObject() {
		
		InputStream is = InputStreamUtil.openInputStream(REPOSITORY_FILE);
		
		Assert.assertNotNull(is);
		
		List<Project> projects = JSONObjectConverter.convertToListOfObjects(is, Project.class);
		
		Assert.assertNotNull(projects);
		Assert.assertEquals(projects.size(), 1);
		
		for (Project project : projects) {
			Assert.assertEquals("Predictive Engine", project.getName());
		}
	}
}
