package com.epidata.talks.dependencyinjection.adhoc.container;

public class ConfigEntry {

	private String name;
	
	private String className;
	
	public ConfigEntry() {
	}
	
	public ConfigEntry(String name, String className) {
		this.name = name;
		this.className = className;
	}

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
	
}
