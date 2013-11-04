package com.epidata.talks.dependencyinjection.model.repository;

import org.apache.commons.collections.Predicate;

import com.epidata.talks.dependencyinjection.model.Project;

public class ProjectByNamePredicate implements Predicate {
	
	private String name;
	
	public ProjectByNamePredicate(String name) {
		this.name = name;
	}

	@Override
	public boolean evaluate(Object project) {
		return name.equals(((Project) project).getName());
	}

}
