package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import jakarta.servlet.ServletContext;

public class Properties {
	
    private static java.util.Properties props = new java.util.Properties();
    private static final String RESOURCE_PATH = "/Users/lucianomoreiradonascimento/Downloads/props.txt";
    private static ServletContext servletContext;

    // Método para configurar ServletContext
    public static void setServletContext(ServletContext context) {
        servletContext = context;
    }

    public static void loadProperties() throws IOException {
        try (InputStream input = new FileInputStream(RESOURCE_PATH)) {
            if (input == null) {
                throw new IOException("Não foi possível obter o stream para " + RESOURCE_PATH);
            }
            //System.out.println(props);
            props.load(input);
        }
    }
	
	
	private Properties() {

	}
	
	public static Map<String, String> getProperties() {
		
		Map<String, String> map = new TreeMap<String, String>();
		Enumeration<Object> e = props.keys();
		
		while(e.hasMoreElements()) {
			String key 		= (String) e.nextElement() ;
			String value 	= props.getProperty(key);
			map.put(key, value);
		}

		return map;
		
	}
	
	public static void delete(String key) throws IOException {
	    props.remove(key);
	    try (OutputStream output = new FileOutputStream(RESOURCE_PATH)) {
	        props.store(output, "");
	    }
	}
	
	
	public static void save(String key, String value) throws IOException {
	    props.setProperty(key, value);
	    try (OutputStream output = new FileOutputStream(RESOURCE_PATH)) {
	        props.store(output, null);
	    }
	}	
	
	public static String getValue(String key) {
		return props.getProperty(key);
	}
}