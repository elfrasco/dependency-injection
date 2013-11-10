package com.epidata.talks.dependencyinjection.base.dao;

import java.util.Arrays;
import java.util.List;

import com.epidata.talks.dependencyinjection.base.dao.ProjectDAO;
import com.epidata.talks.dependencyinjection.model.Developer;
import com.epidata.talks.dependencyinjection.model.Employee;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.ProjectType;

public class ProjectDAOMock implements ProjectDAO {
	
	@Override
	public Project findByName(String name) {
		return buildMockProject();
	}
	
	private Project buildMockProject() {
		Project project = new Project();
		project.setName("Mock Project");
		project.setClientName("Mock");
		project.setDurationInMonths(1);
		project.setType(ProjectType.DEVELOPMENT);
		project.setTeam(buildMockTeam());
		return project;
	}

	private List<Employee> buildMockTeam() {
		Employee employee = new Developer();
		employee.setName("Mock");
		employee.setLastName("Developer");
		return Arrays.asList(employee);
	}
}
