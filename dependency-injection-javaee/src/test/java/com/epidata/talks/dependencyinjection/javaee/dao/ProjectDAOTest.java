package com.epidata.talks.dependencyinjection.javaee.dao;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.epidata.talks.dependencyinjection.model.Employee;
import com.epidata.talks.dependencyinjection.model.Project;
import com.epidata.talks.dependencyinjection.model.ProjectType;
import com.epidata.talks.dependencyinjection.model.repository.JSONProjectRepository;
import com.epidata.talks.dependencyinjection.model.repository.ProjectByNamePredicate;
import com.epidata.talks.dependencyinjection.model.repository.ProjectRepository;
import com.epidata.talks.dependencyinjection.model.test.ProjectAsserts;

@RunWith(Arquillian.class)
public class ProjectDAOTest {

    @Deployment
    public static Archive<?> createTestArchive() {
    	
    	File[] libs = Maven.resolver()  
    		    .loadPomFromFile("pom.xml").resolve("commons-collections:commons-collections:3.0")  
    		    .withTransitivity().asFile();  
    	
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsLibraries(libs)
                .addClasses(Project.class, ProjectType.class, Employee.class,
                		ProjectDAO.class, ProjectRepository.class,
                		JSONProjectRepository.class, ProjectByNamePredicate.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }	
	
	@Inject
	private ProjectDAO projectDAO;
    
	@Test
	public void findByName() {
		Project project = projectDAO.findByName("Predictive Engine");
		ProjectAsserts.assertProject(project);
	}

}
