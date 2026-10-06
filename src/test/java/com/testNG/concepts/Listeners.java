package com.testNG.concepts;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test has started for " + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test has passed for " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test has failed for " + result.getMethod().getMethodName());
		System.out.println("Test has failed due to " + result.getThrowable().getLocalizedMessage());
	}

}
