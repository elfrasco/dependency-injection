package com.epidata.talks.dependencyinjection.adhoc.container;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epidata.talks.dependencyinjection.model.repository.JSONObjectConverter;

public class Container {
	
	private Map<String, Object> context;
	
	private List<ConfigEntry> configuration;
	
	public Container(String configFileName) {
		
		configuration = JSONObjectConverter.convertToListOfObjects(configFileName, ConfigEntry.class);
		if (configuration == null) {
			throw new RuntimeException("FATAL ERROR reading container configuration file");
		}
		context = new HashMap<String, Object>();
		initContext();
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String objectName) {
		return (T) context.get(objectName);
	}
	
	private void initContext() {
		
		for (ConfigEntry entry : configuration) {
			
			String className = entry.getClassName();
			String name = entry.getName();
			
			try {
				
				Object obj = Class.forName(className).newInstance();
				context.put(name, obj);
				
			} catch (Exception e) {
				throw new RuntimeException(
						MessageFormat.format(
								"FATAL ERROR: initContext: Error creating {0} of type {1}",
								entry.getName(), entry.getClassName()),
								e);
			}
		}
	}
}
