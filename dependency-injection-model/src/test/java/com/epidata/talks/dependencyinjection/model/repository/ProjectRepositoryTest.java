package com.epidata.talks.dependencyinjection.model.repository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epidata.talks.dependencyinjection.model.Employee;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.ProjectType;
import com.epidata.talks.dependencyinjection.model.repository.test.util.ProjectAsserts;

public class ProjectRepositoryTest {
	
	private ProjectRepository projectRepository = new JSONProjectRepository();

	@Test
	public void save() {
		projectRepository.save(buildProject());
	}
	
	@Test
	public void find() {
		Project project = projectRepository.findByName("Predictive Engine");
		Assert.assertNotNull(project);
		ProjectAsserts.assertProject(project);
	}
	
	private Project buildProject() {
		Project project = new Project();
		project.setId("2");
		project.setName("Portal BiMo");
		project.setClientName("Banelco");
		project.setDurationInMonths(5);
		project.setType(ProjectType.DEVELOPMENT);
		project.setTeam(buildTeam());
		return project;
	}
	
	private List<Employee> buildTeam() {
		return Arrays.asList(
				buildVicenteTripodi(),
				buildSantiagoGuerra());
	}
	
	private Employee buildVicenteTripodi() {
		Employee vicenteTripodi = new Employee();
		vicenteTripodi.setId("7");
		vicenteTripodi.setName("Vicente");
		vicenteTripodi.setLastName("Tripodi");
		vicenteTripodi.setFileNumber("1278");
		vicenteTripodi.setDateOfBirth(new GregorianCalendar(1995, Calendar.OCTOBER, 10).getTime());
		return vicenteTripodi;
	}
	
	private Employee buildSantiagoGuerra() {
		Employee santiagoGuerra = new Employee();
		santiagoGuerra.setId("8");
		santiagoGuerra.setName("Santiago");
		santiagoGuerra.setLastName("Guerra");
		santiagoGuerra.setFileNumber("177888");
		santiagoGuerra.setDateOfBirth(new GregorianCalendar(1999, Calendar.JUNE, 23).getTime());
		return santiagoGuerra;
	}
}
