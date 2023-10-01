package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

public class Properties {
	
	private static java.util.Properties props = new java.util.Properties();
	
	public static void loadProperties(InputStream input) throws IOException {
		props.load(input);
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
		props.store(new FileOutputStream(FILE_NAME),"");
	}
	
	public static void save(String key, String value) throws IOException {
		props.setProperty(key, value);
		props.store(new FileOutputStream(FILE_NAME), "");
	}
	
	public static String getValue(String key) {
		return props.getProperty(key);
	}
}