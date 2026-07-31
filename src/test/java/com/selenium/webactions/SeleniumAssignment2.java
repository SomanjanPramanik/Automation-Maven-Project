package com.selenium.webactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumAssignment2 {
//	Assignment - 2
//	============
	
//    1. Launch browser window(Chrome)
//    2. Maximize the browser window
//    3. Delete all the cookies
//    4. Enter URL and Launch the application (https://demoqa.com/automation-practice-form)
//creating a common public static method	
	public static final WebDriver launchBrowserAndApp(String driverName , String appUrl){
		WebDriver driver = null ;
		switch(driverName) {
		case "ChromeDriver" :
			driver = new ChromeDriver();
			break;
		case "FirefoxDriver":	
			driver = new FirefoxDriver();
			break;
		default :
			System.out.println("Not valid Driver");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(appUrl);
		return driver;
	}
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
//	    1. Launch browser window(Chrome)
//	    2. Maximize the browser window
//	    3. Delete all the cookies
//	    4. Enter URL and Launch the application (https://demoqa.com/automation-practice-form)
		
		WebDriver driver = launchBrowserAndApp("ChromeDriver","https://demoqa.com/automation-practice-form");
		       
//		        5. Wait for Page-load
		//doing both if logo is coming(assertion)+waiting
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[@src='/assets/Toolsqa-DZdwt2ul.jpg']"), 0));

//		        6. Enter First name and Last name
		           
		WebElement nameboxLabel = driver.findElement(By.xpath("//label[contains(text(),'Name')]"));
		String nameLabel = nameboxLabel.getText();
		String expectednameLabel = "Name";
		Assert.assertEquals(nameLabel, expectednameLabel);
		
		WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		String fstNmeLabel = firstNameTxtBox.getAttribute("placeholder");
		String expectedfstNmeLabel = "First Name";
		Assert.assertEquals(fstNmeLabel, expectedfstNmeLabel);
		firstNameTxtBox.clear();
		firstNameTxtBox.sendKeys("FirstName");
		
		WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		String lstNmeLabel = lastNameTxtBox.getAttribute("placeholder");
		String expectedlstNmeLabel = "Last Name";
		Assert.assertEquals(lstNmeLabel, expectedlstNmeLabel);
		lastNameTxtBox.clear();
		lastNameTxtBox.sendKeys("lastName");
		
//		        7. Enter Email
		WebElement mailboxLabel = driver.findElement(By.xpath("//label[contains(text(),'Email')]"));
		String mailLabel = mailboxLabel.getText();
		String expectedmailLabel = "Email";
		Assert.assertEquals(mailLabel, expectedmailLabel);
		WebElement emailTxtBox = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
		emailTxtBox.clear();
		emailTxtBox.sendKeys("name@gmail.com");
		               
//		        8. Select Gender (Female)
		               
		WebElement genderboxLabel = driver.findElement(By.xpath("//div[text()='Gender']"));
		String genderbxLabel = genderboxLabel.getText();
		String expectedgenderbxLabel = "Gender";
		Assert.assertEquals(genderbxLabel, expectedgenderbxLabel);
		genderSelectionBtn(driver,"Female");
		
//		        9. Enter mobile number
		
		WebElement mbNumboxLabel = driver.findElement(By.xpath("//div[@id='userNumber-wrapper']/div/label[@id='userNumber-label']"));
		String mbNumbxLabel = mbNumboxLabel.getText();
		String expectedmbNumbxLabel = "Mobile(10 Digits)";
		Assert.assertEquals(mbNumbxLabel, expectedmbNumbxLabel);
		WebElement mbNumBox = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
		mbNumBox.clear();
		mbNumBox.sendKeys("1234567890");
		               
//		        10.Select DOB (1-Feb-1991)
		
		WebElement dobBoxLabel = driver.findElement(By.xpath("//div[@id='dateOfBirth-wrapper']/div/label[contains(@class,'form-label col-form-label col-form-label-sm col')]"));
		String dobbxLabel = dobBoxLabel.getText();
		String expecteddobbxLabel = "Date of Birth";
		Assert.assertEquals(dobbxLabel, expecteddobbxLabel);
		dobSelectionBtn (driver,"1-Feb-1991");
		
//		        11.Search and Select Computer Science
		
		selectSubject(driver,"Computer Science");
		               
//		        12.Select Hobbies as Sports and Reading
		String[] hobbies = {"Sports","Reading"};               
		selectHobbies(driver,hobbies);
		
//		        13.Upload photo
		       
		WebElement uploadBtn = driver.findElement(By.xpath("//input[@label='Select picture']"));
		//uploadBtn.click();
		
		JavascriptExecutor click = (JavascriptExecutor)driver;
		click.executeScript("arguments[0].click()", uploadBtn);
		
//		        14. Wait till window open to upload the file
		
		Thread.sleep(5000);          //<---As it is now outside of selenium control like outside of main window
		
		
//		        15. Upload file
		// Note: Using Robot class here specifically to demonstrate handling of native OS windows. 
		//For standard <input type="file"> elements in a real CI/CD pipeline, sendKeys() would be used to support headless execution.
		
		//-->uploadBtn.sendKeys(imgPath);
		
		//first the get file path
		
		//
		String imgPath = "C:\\AutomationTraining\\AutomationMavenProject\\uploadImg\\1291412.jpg";
		
		//now copy this file into clipboard (Using ToolkitAWT)
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(imgPath), null);
		
		//now upload using Robot
		
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		//now needs to hit enter
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		               
//		        16. Wait till file upload
		
		//Both selenium or Thread wait can be done
		Thread.sleep(5000);
		
		
		//all these can be done by modern Selenim :  uploadBtn.sendKeys(imgPath);
		               
//		        17.Submit Details
		//Now this submit button get covered by the ad so we need to bypass it -----> Using Javascript submit
		
		WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit' and text()='Submit']"));
		
		JavascriptExecutor submit = (JavascriptExecutor)driver;
		submit.executeScript("arguments[0].scrollIntoView()", submitBtn);
		
		submit.executeScript("arguments[0].click();", submitBtn);
		
		               
//		        18. Close browser window
		 
		
		 driver.quit();
		
		 
	}

    //creating method for gender selection
	public static void genderSelectionBtn (WebDriver driver,String option) {
		WebElement genderRadioBtn = driver.findElement(By.xpath("//div[text()='Gender']/following-sibling::div/div/label[text()='"+option+"']"));
		genderRadioBtn.click();
	}
	 //creating method for selecting D-O-B
	/**
	 * @deprecated
	 * @param driver the WebDriver instance controlling the browser
     * @param date the date string to select, e.g. "1-Feb-1991"
	 */
	 public static	void dobSelectionBtn (WebDriver driver,String date) {
		String[] parts = date.split("-");
		String day = parts[0];
		if(day.length()<2) {
			day="0"+day;           //webLocator creating issue for single digit date
		}
		String month = parts[1];
		String year = parts[2];
		
		//first need to click then dropDownBox comes
		WebElement dobBox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		Actions clickDob = new Actions(driver);
		clickDob.click(dobBox).perform();
		
		//selecting year
		WebElement yrDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select yr = new Select(yrDropDown);
		yr.selectByVisibleText(year);		    
		
		//selecting month
		WebElement mnthDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select mnth = new Select(mnthDropDown);
		mnth.selectByContainsVisibleText(month);
		
		//selecting date
		WebElement dayBox = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0"+day+"')]"));
		dayBox.click();
	 }
	 /**better version of the method {@link SeleniumAssignment2#dobSelectionBtn(WebDriver,String)}
	  * @param driver the WebDriver instance controlling the browser
      * @param date the date string to select, e.g. "1-Feb-1991"
	  */
	 public static	void BetterdobSelectionBtn (WebDriver driver,String date) {
		 String[] parts = date.split("-");
		 String day = parts[0];
		 String month = parts[1];
		 String year = parts[2];
		 //first need to click then dropDownBox comes
		 WebElement dobBox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		 Actions clickDob = new Actions(driver);
	     clickDob.click(dobBox).perform();
		 
		 //select year
		 WebElement yrDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		 Select yr = new Select(yrDropDown);
		 yr.selectByVisibleText(year);
		 //common webelement is : //div[contains(@aria-label,'" + fullMonth + "') and text()='" + day + "']
		 // fullMonth e.g. February not Feb
		 List<String> fullMonthList = List.of("January","February","March","April","May","June","July","August","September","October","November","December");
		 for(String monthName : fullMonthList) {
			 if (monthName.contains(month)) {
			 month = monthName;
			 break;
			 }
		 }
		 //selecting month
		 WebElement mnthDropDown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		 Select mnth = new Select(mnthDropDown);
	     mnth.selectByContainsVisibleText(month);
	     //select date
	     WebElement dayBox = driver.findElement(By.xpath("//div[contains(@aria-label,'" + month + "') and text()='" + day + "']"));
		 dayBox.click(); 
	 }
	 
	 //select subject
	 public static void selectSubject(WebDriver driver , String subName) {
		 //locate the textbox
		 WebElement subjectBtn = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		 //scrolling down to this Element
		 JavascriptExecutor scroll = (JavascriptExecutor)driver;
		 scroll.executeScript("arguments[0].scrollIntoView()", subjectBtn);
		 //using action class to enter "Computer Science"
//		 Actions action = new Actions(driver);
//		 action.sendKeys(subjectBtn,subName).perform();
		 //action key performing funny switching to simple element sendKeys for which needs input tag  
		 subjectBtn.sendKeys(subName);
		 //wait until pop up and click on it if it's there
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[text()='"+subName+"']"), 0));
		 WebElement subject = driver.findElement(By.xpath("//div[text()='"+subName+"']"));
		 subject.click();
	 }
	 
	 //select hobbies
	 public static void selectHobbies(WebDriver driver , String[] options) {
		 for (String hobby : options) {
			 WebElement hobbyElement = driver.findElement(By.xpath("//label[text()='"+hobby+"']"));
			 if(!hobbyElement.isSelected()) {
				 hobbyElement.click();
			 }
		 }
	 } 
}

