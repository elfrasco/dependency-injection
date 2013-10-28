package com.epidata.talks.dependencyinjection.model.repository;

import java.io.InputStream;

public class StreamUtil {

    public static InputStream openInputStream(String classpathFileName) {
    	InputStream is = StreamUtil.class.getResourceAsStream(classpathFileName);
    	if (is == null) {
    		throw new RuntimeException("File not found " + classpathFileName);
    	}
    	return is;
    }
    
}
