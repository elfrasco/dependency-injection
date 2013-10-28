package com.epidata.talks.dependencyinjection.model.repository;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class JSONObjectConverter {

	@SuppressWarnings("unchecked")
	public static <T> T convertToObject(InputStream is, Class<?> clazz) {

		ObjectMapper mapper = buildMapper();

		try {
			return (T) mapper.readValue(is, clazz);
		} catch (Exception e) {
			throw new RuntimeException("An ERROR ocurred in unmarshal of " + clazz.getSimpleName(), e);
		}
	}

	public static <T> List<T> convertToListOfObjects(String classpathFileName, Class<?> clazz) {

		ObjectMapper mapper = buildMapper();

		try {
			InputStream is = StreamUtil.openInputStream(classpathFileName);
			return mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (Exception e) {
			throw new RuntimeException("An ERROR ocurred in unmarshal of " + clazz.getSimpleName(), e);
		}
	}
	
	public static void convertToJSONFile(String classpathFileName, Object obj) {
		
		ObjectMapper mapper = buildMapper();
		
		try {
			OutputStream os = StreamUtil.openOutputStream(classpathFileName);
			mapper.writeValue(os, obj);
			os.close();
		} catch (Exception e) {
			throw new RuntimeException("An ERROR ocurred in marshal of " + obj.getClass().getSimpleName(), e);
		}
	}
	
	private static ObjectMapper buildMapper() {
		ObjectMapper mapper = new ObjectMapper();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		mapper.setDateFormat(dateFormat);
		return mapper;
	}

}
