package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

public class Properties {
	
	private static final String FILE_NAME = "WEB-INF/props.txt";
	private static java.util.Properties props;
	
	static {
		props = new java.util.Properties();
		try {
			props.load(new FileInputStream(FILE_NAME));
		} catch (IOException e) {
	        System.err.println("Erro ao carregar o arquivo de propriedades: " + e.getMessage());
	        e.printStackTrace();
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
			System.out.println(key + "=" + value);
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