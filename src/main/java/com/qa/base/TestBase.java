/**
 *
 */
package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author W252625
 *
 */
public class TestBase {
	public Properties prop;
	public int Response_Status_200 = 200;
	public int Response_Status_500 = 500;
	public int Response_Status_400 = 400;


	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/config/config.properties");
			try {
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
