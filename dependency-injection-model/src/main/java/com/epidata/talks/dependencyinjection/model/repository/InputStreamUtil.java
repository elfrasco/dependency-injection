package com.epidata.talks.dependencyinjection.model.repository;

import java.io.InputStream;

public class InputStreamUtil {

    public static InputStream openInputStream(String classpathFile) {
        try {
            return InputStreamUtil.class.getResourceAsStream(classpathFile);
        } catch (Exception e) {
            throw new RuntimeException("File not found " + classpathFile, e);
        }
    }
    
}
