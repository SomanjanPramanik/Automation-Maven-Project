package com.selenium.webactions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumAssignment1 {
//	Selenium Assignment - 1
//	====================
//	1. Launch browser window(Chrome)
	public static WebDriver driver = new ChromeDriver();
	public static void main(String[] args) {		
		
//		2. Maximize the browser window
		
		driver.manage().window().maximize();

//		3. Delete all the cookies
		
		driver.manage().deleteAllCookies();
		
//		4. Enter URL and Launch the application (https:parabank.parasoft.com/parabank/index.htm)
		
		driver.get("https:parabank.parasoft.com/parabank/index.htm");
		
//		5. Verify application title (ParaBank | Welcome | Online Banking)
	    
		String actualTitle = driver.getTitle();
		String expectedTitle = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(actualTitle, expectedTitle);
		
//		6. Verify application logo
		
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
		Assert.assertTrue(logo.isDisplayed());
		
//		7. Verify application caption (Experience the difference)
		
		WebElement caption = driver.findElement(By.xpath("//p[@class='caption']"));
		String expectedCaption = "Experience the difference";
		String actualCaption = caption.getText();
		Assert.assertEquals(actualCaption, expectedCaption);
		
//		8. Enter Invalid credentials in Username and Password textboxes
		
		WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
		usernameInput.clear(); //clear text box if anything is written there
		usernameInput.sendKeys("Invalid Username");
		WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
		passwordInput.clear(); //clear text box if anything is written there
		passwordInput.sendKeys("Invalid password");
		
//		9. Verify button label (LOG IN) and Click on Login Button
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
		String actualLabel = loginButton.getAttribute("value").toUpperCase();
		String expectedLabel = "LOG IN";
		Assert.assertEquals(actualLabel, expectedLabel);
		loginButton.click();
		
//		10. Verify error message is coming
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0));
		
//		11. Click on Admin page link
		
		WebElement adminPageButton = driver.findElement(By.xpath("//a[@href = 'admin.htm' and text()='Admin Page']"));
		adminPageButton.click();
		
//		12. Wait for admin page
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1[contains(text(),'Administration')]"), 0));
		
//		13. Select Data access mode as ' SOAP'
		
		selectDataAccessBtn("soap");
		
//		14. Scroll-down till Loan provider		
//		15. Select Loan provider as 'Web Service'
		
		selectLoanProviderDrpDwn("Web Service");
		
//		16. Click on Submit button
		
		WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Submit']"));
		String actualLabelBtn = submitBtn.getAttribute("value").toUpperCase();
		String expectedLabelBtn = "SUBMIT";
		Assert.assertEquals(actualLabelBtn,expectedLabelBtn);
		submitBtn.click();
		
//		17. wait for Successful submission message
		
		//can skip it just use wait we've done previously ; I'm doing for practice purpose
		WebDriverWait submitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		submitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1/following-sibling::p/b[contains(text(),'Settings saved successfully.')]"), 0));
		
//		18. Click on Services Link
		
		WebElement serviceLinkBtn = driver.findElement(By.xpath("//ul[@class='leftmenu']//li/a[@href = 'services.htm' and text()='Services']"));
		serviceLinkBtn.click();
		
//		19. Wait for Services page
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[@class='heading' and text() ='Available Bookstore SOAP services:']"), 0));
		
//		20. Scroll-down till Bookstore services
		
		WebElement bookstreServices = driver.findElement(By.xpath("//span[@class='heading' and text() ='Bookstore services:']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",bookstreServices);
		
//		21. Get total rows, columns in the bookstore service table
		
		//Always do for 2 webElements
		List<WebElement> rowElements = driver.findElements(By.xpath("//span[@class='heading' and text() ='Bookstore services:']/following-sibling::table[1]/tbody/tr")); 
		List<WebElement> columnElements = driver.findElements(By.xpath("//span[@class='heading' and text() ='Bookstore services:']/following-sibling::table[1]/tbody/tr[1]/td")); 
		int totalRows = rowElements.size();
        int totalColumns = columnElements.size();
				
//		22. Get Column headers of book store services table
        
        //row == 1 and column == variable ; so ===> 1 loop 
        for(int c = 1 ; c <= totalColumns ; c++) {
        	cell(1, c);
        }
        
//		23. Get all the data from book store service table
        
        for(int r = 1 ; r <= totalRows ; r++) {
        	for(int c = 1 ; c <= totalColumns ; c++) {
        		cell(r,c);
        	}
        }
        
//		24. Close browser window
        driver.quit();
	}

	//creating a method for radio button
	public static void selectDataAccessBtn(String option) {
		WebElement radioBtn = driver.findElement(By.xpath("//form/child::h3[contains(text(),'Data Access Mode')]/following-sibling::table/tbody/tr/td/input[@value='"+option+"']"));
		radioBtn.click();
	}
	
	//creating same for dropdown element
	public static void selectLoanProviderDrpDwn(String option) {
		WebElement loanprvdrDrpDwn = driver.findElement(By.xpath("//select[@name=\"loanProvider\"]"));
		//scrolling down to dropdown element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollToElement", loanprvdrDrpDwn);
		//selecting the button
		Select selectDrpDwn = new Select(loanprvdrDrpDwn);
		//checking if multiple select allow or not
		boolean isMulipltSelect = selectDrpDwn.isMultiple();
		if(!isMulipltSelect) {
			selectDrpDwn.selectByVisibleText(option);
		}
		else {
			Assert.assertFalse(isMulipltSelect);	
		}
	}
	
	//creating method to get data from the table for bookstore service
	public static void cell(int row , int column) {
		WebElement cellData = driver.findElement(By.xpath("//span[@class='heading' and text() ='Bookstore services:']/following-sibling::table[1]/tbody/tr["+row+"]/td["+column+"]"));
		System.out.println("row :"+row+"| column :"+column+"| cellData :"+cellData.getText());
	}
}
