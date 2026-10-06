package com.testNG.concepts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count = 0;
	int maxRetry = 2;

	@Override
	public boolean retry(ITestResult result) {

		if (!result.isSuccess()) {
			if (count < maxRetry) {
				count++;
				return true;
			}
		}
		return false;
	}

}
