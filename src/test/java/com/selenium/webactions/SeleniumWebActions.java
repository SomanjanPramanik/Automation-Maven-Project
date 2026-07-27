package com.selenium.webactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumWebActions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com/");
        String getUrl = driver.getTitle();
        System.out.println(getUrl);
        String expectedTitel = "Google";
        Assert.assertEquals(getUrl,expectedTitel);
        driver.close();
	}

}
