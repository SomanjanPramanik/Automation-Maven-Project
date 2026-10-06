package com.selenium.webactions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumAssignment3 {

//	 ExtentSparkReporter spark = new ExtentHtmlReporter("ExtentSpark.html"); <--blank page
//	 ExtentReports extent = new ExtentReports(); <--printer
//	 extent.attachReporter(spark);
//	 
//	 extent.createTest("TestName").pass("Test Passed");
//	 
//	 extent.flush();

	public static ExtentReports extent = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest logger = null;

	public static void main(String[] args) {
		// C:\AutomationTraining\AutomationMavenProject\TestData
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\TestData\\FrameTest.html"); // <---blank
																										// page
		extent = new ExtentReports(); // <--printer
		extent.attachReporter(spark); // <--attaching page to printer

		logger = extent.createTest("Launching application and verifyig logo");

//      1.Launch Chrome Browser
		WebDriver driver = new ChromeDriver();

//      2.Maximize the browser window

		driver.manage().window().maximize();

//      3.Launch the application

		driver.get("https://demoqa.com/automation-practice-form");

//      4.Locate elements

		WebElement sidwBar = driver.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']"));

		WebElement logo = driver.findElement(By.xpath("//img[@src='/assets/Toolsqa-DZdwt2ul.jpg']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/assets/Toolsqa-DZdwt2ul.jpg']"))); // wait
																														// until
																														// logo
																														// appears

		// Here checking logo is here or not

		logger.pass("App Launched successfully along with logo");
		System.out.println(logo.getSize());
		logger.addScreenCaptureFromPath(elementScreenshotAlongWithFileFormat(logo, "logo.png"));

		// Here checking if sideBar is clickable or not

		logger = extent.createTest("Verifying SideBar is clickable or Not");

		sidwBar.click();

		logger.pass("SideBar is clickable");

		logger.addScreenCaptureFromPath(elementScreenshotAlongWithFileFormat(sidwBar, "sideBar.png"));

		// Here checking Frames button is clickable or not

		logger = extent.createTest("Frame button is clickable or not");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Frames']")));

		WebElement frameWindow = driver.findElement(By.xpath("//span[text()='Frames']"));

		frameWindow.click();

		logger.pass("Frame button is clickable");

		logger.addScreenCaptureFromPath(elementScreenshotAlongWithFileFormat(frameWindow, "frameWindow.png"));

		// Here checking framepage is loaded or not

		logger = extent.createTest("Verifying framePage loaded or not");

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1[text()='Frames']"), 0));

		logger.pass("framePage loaded successfully");

		logger.addScreenCaptureFromPath(windowScreenshotAlongWithFileFormat(driver, "FramePage.png"));

//      5.Print frame element text

		// Checking the text we're getting from frame1

		logger = extent.createTest("Verifying the text from frame 1");

		// first switch to frame

		driver.switchTo().frame("frame1");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='This is a sample page']")));

		WebElement frame1 = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
		System.out.println(frame1.getText());

		logger.info(frame1.getText());

		logger.addScreenCaptureFromPath(elementScreenshotAlongWithFileFormat(frame1, "frameText.png"));

		// switch back to main window

		driver.switchTo().defaultContent();

//      6.Print main window element text

		// Checking the text we're getting from main window

		logger = extent.createTest("Verifying the text from main window");

		WebElement mainWindowTxt = driver.findElement(By.xpath("//h1[text()='Frames']"));
		System.out.println(mainWindowTxt.getText());

		logger.info(mainWindowTxt.getText());

		logger.addScreenCaptureFromPath(elementScreenshotAlongWithFileFormat(mainWindowTxt, "mainWindowText.png"));

		// ending the report

		extent.flush();

//      7.Close browser window

		driver.quit();

	}

	// Creating method for attaching screenshot with ExtentTest reports

	public static String windowScreenshotAlongWithFileFormat(WebDriver driver, String fileNameWithFormat) {

		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + fileNameWithFormat;

		// Now we need to copy the temp file and stores that file into actual
		// Screenshots folder

		// first getScreenShot
		File getScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Copy the screenshots to filepath with desired format
		try {
			FileUtils.copyFile(getScreenshot, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Instead main code searching for throw every time just surround it here with
		// and try and catch

		return filePath;

	}

	// Creating method for attaching screenshot with ExtentTest reports for a
	// particular element screenshot

	public static String elementScreenshotAlongWithFileFormat(WebElement element, String fileNameWithFormat) {

		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + fileNameWithFormat;

		// Now we need to copy the temp file and stores that file into actual
		// Screenshots folder

		// first getScreenShot
		File getScreenshot = element.getScreenshotAs(OutputType.FILE);

		// Copy the screenshots to filepath with desired format
		try {
			FileUtils.copyFile(getScreenshot, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Instead main code searching for throw every time just surround it here with
		// and try and catch

		return filePath;

	}

}
