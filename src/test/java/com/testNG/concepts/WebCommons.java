package com.testNG.concepts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class WebCommons {

	@BeforeSuite(alwaysRun = true) //groups = {"Sanity","Regression"}
	public static void StartReporting() {

		System.out.println("Reporting has Started...");

	}

	@AfterSuite(alwaysRun = true)
	public static void StopReporting() {

		System.out.println("Reporting has Stopped...");

	}
	@BeforeMethod(alwaysRun = true)
	@Parameters(value = {"BrowserName","AppUrl"})
	public static void launchingBrowserAndApplication(String Browser, String url) {

		System.out.println(Browser + " has Started...");
		System.out.println(url + " has Started...");

	}

	@AfterMethod(alwaysRun = true)
	public static void closingBrowser() {

		System.out.println("Browser has closed...");
		
	}
 
	@DataProvider(name = "data")
	public static String[][] data() {

		String[][] data = { { "Somanjan", "sp123" }, { "Invalid", "I123" } };
		return data;

	}

}
