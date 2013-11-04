package com.epidata.talks.dependencyinjection.adhoc.container;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

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
	public <T> T getBean(String objectName) {
		return (T) context.get(objectName);
	}
	
	private void initContext() {
		
		for (ConfigEntry entry : configuration) {
			
			String className = entry.getClassName();
			String name = entry.getName();
			
			try {
				
				Object obj = Class.forName(className).newInstance();
				fillAttributes(obj, entry.getAttributes());
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
	
	private void fillAttributes(Object obj, List<Attribute> attributes) {
		if (attributes != null) {
			for (Attribute attribute : attributes) {
				
				String setterMethodName = "set" + StringUtils.capitalize(attribute.getAttributeName());
				Object bean = findBean(attribute, setterMethodName);
				
				setAttribute(obj, setterMethodName, bean);
			}
		}
	}

	private Object findBean(Attribute attribute, String setterMethodName) {
		Object bean = context.get(attribute.getBeanName());
		if (bean == null) {
			throw new RuntimeException(
					MessageFormat.format(
							"FATAL ERROR: bean {0} not found",
							setterMethodName));						
		}
		return bean;
	}
	
	private void setAttribute(Object obj, String setterMethodName, Object bean) {
		try {
			Method setter = findSetter(obj, setterMethodName, bean);
			setter.invoke(obj, bean);
		} catch (Exception e) {
			throw new RuntimeException(
					MessageFormat.format(
							"FATAL ERROR: method {0} not found",
							setterMethodName), e);
		}
	}

	private Method findSetter(Object obj, String setterMethodName, Object bean) {
		
		Class<?> clazz = bean.getClass();
		
		// Scan all the class hierarchy of the bean parameter
		do {
			try {
				return obj.getClass().getMethod(setterMethodName, clazz);
			} catch (Exception e) {
				clazz = clazz.getSuperclass();
			}
		} while (!clazz.equals(Object.class));
		
		// Try with the interfaces
		clazz = bean.getClass();

		for (Class<?> interfaz : clazz.getInterfaces()) {
			do {
				try {
					return obj.getClass().getMethod(setterMethodName, interfaz);
				} catch (Exception e) {
					clazz = clazz.getSuperclass();
				}
			} while (!clazz.equals(Object.class));
		}
		
		throw new RuntimeException("Method not found " + setterMethodName);
	}
}
