package com.testNG.concepts;

//import org.testng.Assert;
import org.testng.annotations.Test;

public class AppCommons extends WebCommons {

	@Test(groups = { "Sanity" }, priority = 2, retryAnalyzer = com.testNG.concepts.Retry.class)
	public static void testCase1() {
		// Assert.fail("Test Case - 1 has failed");
		System.out.println("Test Case -1 Homepage launched succesfully");
	}

	@Test(groups = { "Regression" }, priority = 1, enabled = true, dependsOnMethods = { "testCase1", "testCase3" })
	public static void testCase2() {
		System.out.println("Test Case -2 Add producto to cart feature executed");
	}

	@Test(dataProvider = "data", groups = { "Regression", "Sanity" }, priority = 3)
	public static void testCase3(String username, String password) {
		System.out.println("Test Case -3 login executed with username : " + username + " password : " + password);
	}

}
