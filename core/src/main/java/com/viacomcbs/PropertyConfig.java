package main.java.com.viacomcbs;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.annotation.PageObject;

@PageObject
public class PropertyConfig {
	
	
	InputStream inputStream;
	
	Properties prop = new Properties();
	
	public PropertyConfig() {
		setProperty();
	}
	
	public void setProperty() {
		
		try {			
			String propFileName = "config.properties"; 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		
	}catch (Exception e) {
//		System.out.println(e);
}

	}
	
	public Properties getConfig() {
		return prop;
		
	}
}