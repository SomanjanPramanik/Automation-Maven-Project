package com.framework.utilities;

import java.util.Properties;

public class readPropertyFile {

	public static void main(String[] args) {
		
		Properties prop = PropUtil.readData("qa","config.properties");
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));

	}

}
