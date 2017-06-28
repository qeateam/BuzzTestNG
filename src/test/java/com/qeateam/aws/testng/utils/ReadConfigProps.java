package com.qeateam.aws.testng.utils;

import java.util.ResourceBundle;

public class ReadConfigProps {
	
	//Public global values
	public static String URL, DBUSERNAME, DBPASSWORD, PLATFORM, BROWSER;
	public void retrieve_configProperties() {

		ResourceBundle objResBundle = ResourceBundle.getBundle("./src/test/resources/properties.config");
		URL = (String) objResBundle.getObject("URL");
		System.out.println("URL>>"+URL);
		DBUSERNAME = (String) objResBundle.getObject("DBUSERNAME");
		System.out.println("DBUSERNAME>>"+DBUSERNAME);
		DBPASSWORD = (String) objResBundle.getObject("DBPASSWORD");
		System.out.println("DBPASSWORD>>"+DBPASSWORD);
		PLATFORM = (String) objResBundle.getObject("PLATFORM");
		System.out.println("PLATFORM>>"+PLATFORM);
		BROWSER = (String) objResBundle.getObject("BROWSER");
		System.out.println("BROWSER>>"+BROWSER);
		
		

	}
}