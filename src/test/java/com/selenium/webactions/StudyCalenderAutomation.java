package com.selenium.webactions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//ExtentSparkReporter spark = new ExtentHtmlReporter("ExtentSpark.html");
//ExtentReports extent = new ExtentReports();
//extent.attachReporter(spark);
//
//extent.createTest("TestName").pass("Test Passed");
//
//extent.flush()

public class StudyCalenderAutomation {
	public static ExtentSparkReporter spark = new ExtentSparkReporter(
			System.getProperty("user.dir") + "\\TestData\\CalenderTest.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test = null;

	public static void main(String[] args) {

		// C:\AutomationTraining\AutomationMavenProject\TestData\CalenderTest.html

//		Launch Chrome, load your local study_calendar_v2.html (via driver.get("file:///C:/Users/...") since it's a local file, no server needed)
		extent.attachReporter(spark);
		test = extent.createTest("Launching Browser and html file");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("file:///C:/Users/Somanjan%20Pramanik/Desktop/gg/study_calendar_v2.html");

//	    Verify page loads — check title, header text

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h1[text()='Full Stack Testing']/span[text() ='Daily Roadmap']")));

		String actualTitle = driver.getTitle();

		String expectedTitle = "Somanjan's Course Roadmap";

		Assert.assertEquals(actualTitle, expectedTitle);

		test.pass("Html launched Successfully");
		test.addScreenCaptureFromPath(fullWindowScreenshot(driver, "CalenderLaunch.png"));

//		Click Reset → handle the native alert → verify OK path clears everything, Cancel path leaves it untouched

		resetButton(driver, "accept");

//		Click a specific lesson row → assert it gets the done class

		// Selenium pt6 & Framework Intro

//		Verify progress bar % updates correctly to match		

		test = extent.createTest("Click a specific lesson and Verify progress bar % updates correctly to match");

		String lesson = "Selenium pt6 & Framework Intro";
		clickLesson(driver, lesson);

		test.pass("Clicked a lesson and verified progress bar % updates successfully");

		WebElement lessonElement = driver
				.findElement(By.xpath("//span[@class='lesson-title' and text()='" + lesson + "']"));
		test.addScreenCaptureFromPath(elementScreenshot(lessonElement, "ClickAfterlesson.png"));

		WebElement percentage = driver.findElement(By.xpath("//div[@id='progress-pct']"));
		test.addScreenCaptureFromPath(elementScreenshot(percentage, "ClickAfterProgressBar.png"));

//		Click the same lesson again → assert it un-marks, progress % goes back down

		test = extent.createTest("Click the same lesson again → assert it un-marks, progress % goes back down");

		UnClickLesson(driver, "Selenium pt6 & Framework Intro");

		test.pass("Clicked same lesson and verified progress bar % goes back successfully");
		test.addScreenCaptureFromPath(elementScreenshot(lessonElement, "UnclickAfterlesson.png"));
		test.addScreenCaptureFromPath(elementScreenshot(percentage, "UnclickAfterProgressBar.png"));

//		Click Reset → handle the native alert → verify OK path clears everything, Cancel path leaves it untouched

		test = extent.createTest("Verify reset button");

		WebElement resetButton = driver.findElement(By.xpath("//button[@class='reset-btn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", resetButton);
		test.addScreenCaptureFromPath(elementScreenshot(resetButton, "reset.png"));

		resetButton(driver, "dismiss");

		resetButton(driver, "accept");

		test.pass("Reset button works successfully");

		extent.flush();

//      close Browser

		driver.quit();

//		Wrap every step with ExtentReports logging + screenshots, same pattern as your Frames assignment

	}

	// Creating common method for Unlicking desired lessons

	public static void clickLesson(WebDriver driver, String lesson) {
		// span[@class='lesson-title' and text()='Selenium pt6 & Framework Intro']

		WebElement percentage = driver.findElement(By.xpath("//div[@id='progress-pct']"));
		int currentValue = Integer.parseInt(percentage.getText().replace("%", ""));

		WebElement lessonElement = driver
				.findElement(By.xpath("//span[@class='lesson-title' and text()='" + lesson + "']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", lessonElement);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@class='lesson-title' and text()='" + lesson + "']")));

		// This is not button or select or any that type of tags so we need other way to
		// assert
		// see when you click html code changes to day done and if not clicked
		// day<---Use it

		// span[text()='Selenium pt6 & Framework Intro']/ancestor::div[@class='day
		// done']

		WebElement selectElement = driver
				.findElement(By.xpath("//span[text()='" + lesson + "']/ancestor::div[contains(@class,'day')]"));

		boolean isSelected = selectElement.getAttribute("class").contains("done");

		if (isSelected) {

			lessonElement.click();

			js.executeScript("arguments[0].scrollIntoView()", percentage);
			int nextValue = Integer.parseInt(percentage.getText().replace("%", ""));

			Assert.assertTrue(nextValue > currentValue);

		}

	}

	// Creating common method for UnClicking desired lessons

	public static void UnClickLesson(WebDriver driver, String lesson) {
		// span[@class='lesson-title' and text()='Selenium pt6 & Framework Intro']

		WebElement percentage = driver.findElement(By.xpath("//div[@id='progress-pct']"));
		int currentValue = Integer.parseInt(percentage.getText().replace("%", ""));

		WebElement lessonElement = driver
				.findElement(By.xpath("//span[@class='lesson-title' and text()='" + lesson + "']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", lessonElement);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@class='lesson-title' and text()='" + lesson + "']")));

		// This is not button or select or any that type of tags so we need other way to
		// assert
		// see when you click html code changes to day done and if not clicked
		// day<---Use it

		// span[text()='Selenium pt6 & Framework Intro']/ancestor::div[@class='day
		// done']

		WebElement selectElement = driver
				.findElement(By.xpath("//span[text()='" + lesson + "']/ancestor::div[contains(@class,'day')]"));

		boolean isSelected = selectElement.getAttribute("class").contains("done");

		if (isSelected) {
			lessonElement.click();

			js.executeScript("arguments[0].scrollIntoView()", percentage);
			int nextValue = Integer.parseInt(percentage.getText().replace("%", ""));

			Assert.assertTrue(nextValue < currentValue);
		}

	}

	// Creating reset button method
	public static void resetButton(WebDriver driver, String condition) {

		WebElement percentage = driver.findElement(By.xpath("//div[@id='progress-pct']"));
		int prevValue = Integer.parseInt(percentage.getText().replace("%", ""));

		WebElement resetButton = driver.findElement(By.xpath("//button[@class='reset-btn']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", resetButton);

		resetButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert confirmationAlert = driver.switchTo().alert();

		Assert.assertEquals("Reset all progress? This cannot be undone.", confirmationAlert.getText());

		if (condition.contains("accept")) {
			
			confirmationAlert.accept();

			test.addScreenCaptureFromPath(fullWindowScreenshot(driver, "resetButtonAccept.png"));
			
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement freshPercentage = wait2
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='progress-pct']")));

			js.executeScript("arguments[0].scrollIntoView()", freshPercentage);

			int currentValue = Integer.parseInt(freshPercentage.getText().replace("%", ""));

			Assert.assertEquals(currentValue, 0);
		} else {

			confirmationAlert.dismiss();

			test.addScreenCaptureFromPath(fullWindowScreenshot(driver, "resetButtonDismiss.png"));
			
			js.executeScript("arguments[0].scrollIntoView()", percentage);

			int currentValue = Integer.parseInt(percentage.getText().replace("%", ""));

			Assert.assertEquals(currentValue, prevValue);

		}
	}

	public static String fullWindowScreenshot(WebDriver driver, String fileNameWithFormat) {

		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + fileNameWithFormat;

		// Making browser to a screenshot tool

		File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			// copying that file to our destination file path
			FileUtils.copyFile(tempFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;

	}

	public static String elementScreenshot(WebElement element, String fileNameWithFormat) {

		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + fileNameWithFormat;

		// Making browser to a screenshot tool

		File tempFile = element.getScreenshotAs(OutputType.FILE);
		try {
			// copying that file to our destination file path
			FileUtils.copyFile(tempFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;

	}

}
