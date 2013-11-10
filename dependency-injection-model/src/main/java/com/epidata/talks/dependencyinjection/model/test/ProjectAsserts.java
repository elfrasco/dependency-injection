package com.epidata.talks.dependencyinjection.model.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.epidata.talks.dependencyinjection.model.Employee;
import com.epidata.talks.dependencyinjection.model.Project;

public class ProjectAsserts {

	private static final List<String> PREDICTIVE_ENGINE_TEAM_NAMES = Arrays.asList("Florencia", "Adrian", "Veronica", "Juan", "Leonardo", "Gonzalo");
	
	private static final List<String> PORTAL_BIMO_TEAM_NAMES = Arrays.asList("Vicente", "Santiago");
	
	private static final List<String> PROJECT_NAMES = Arrays.asList("Portal BiMo", "Predictive Engine", "Mock Project");

	public static void assertProject(Project project) {
		
		assertValidProject(project);
		
		if (PROJECT_NAMES.get(0).equals(project.getName())) {
			assertPortalBiMoProject(project);
		} else if (PROJECT_NAMES.get(1).equals(project.getName())){
			assertPredictiveEngineProject(project);				
		}
	}

	private static void assertValidProject(Project project) {
		Assert.assertTrue(
				"Don't expect a project called " + project.getName(),
				PROJECT_NAMES.contains(project.getName()));
	}
	
	private static void assertPredictiveEngineProject(Project project) {
		Assert.assertEquals(6, project.getTeam().size());
		for (Employee employee : project.getTeam()) {
			Assert.assertTrue(
					"Don't expect an employee called " + employee.getName(),
					PREDICTIVE_ENGINE_TEAM_NAMES.contains(employee.getName()));
		}
	}

	private static void assertPortalBiMoProject(Project project) {
		Assert.assertEquals(2, project.getTeam().size());
		for (Employee employee : project.getTeam()) {
			Assert.assertTrue(
					"Don't expect an employee called " + employee.getName(),
					PORTAL_BIMO_TEAM_NAMES.contains(employee.getName()));
		}
	}

}
