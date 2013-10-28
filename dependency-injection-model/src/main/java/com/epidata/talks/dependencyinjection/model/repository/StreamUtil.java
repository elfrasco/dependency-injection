package com.epidata.talks.dependencyinjection.model.repository;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class StreamUtil {

    public static InputStream openInputStream(String classpathFileName) {
        try {
            return StreamUtil.class.getResourceAsStream(classpathFileName);
        } catch (Exception e) {
            throw new RuntimeException("File not found " + classpathFileName, e);
        }
    }
    
    public static OutputStream openOutputStream(String classpathFileName) {
    	try {
    		URL url = StreamUtil.class.getResource(classpathFileName);
			return new FileOutputStream(url.getPath());
		} catch (Exception e) {
			throw new RuntimeException("File not found " + classpathFileName, e);
		}
    }
    
}
