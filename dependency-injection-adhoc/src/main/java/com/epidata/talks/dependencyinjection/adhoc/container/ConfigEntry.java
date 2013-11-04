package com.epidata.talks.dependencyinjection.adhoc.container;

import java.util.List;

public class ConfigEntry {

	private String name;
	
	private String className;
	
	private List<Attribute> attributes;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
	
}
