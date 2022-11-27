package NOPCommerce_Regression_suite;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Admin_Login_Page_TestCases extends Parent_Initializations.Initializations {
	
	@BeforeTest
	public void init() {
	}
	
	@Test
	public void TC01_search_site() {
		try {
			super.driver.get("https://admin-demo.nopcommerce.com/");
			String title = super.driver.getTitle();
			System.out.println("Page Title: "+title);
			super.driver.manage().window().maximize();
			TestCaseNumber = TestCaseNumber+1;
			ExtentTest TC01 = report.createTest("search site and verify page title Test Case: 0"+TestCaseNumber);		
			Assert.assertEquals(title, "Your store. Login");
			if(title.equals("Your store. Login")) {
				TC01.log(Status.PASS, "Search web page and verify title test verified");
				TC01.log(Status.INFO, "Webpage test case done");
				report.flush();
			}
			else {
				TC01.log(Status.FAIL, "Search web page and verify title test not verified test fail");
				TC01.log(Status.INFO, "Check if web link correct.");
				report.flush();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TC02_TakeScreenshot() throws IOException {
		TestCaseNumber = TestCaseNumber+1;
		try {
			ExtentTest TC02 = report.createTest("TC02 Take Screenshot of webpage displayed");
			String dir = "ExtentReport/Screnshots/";
			File file1 = new File(dir, "TC0"+TestCaseNumber+".png");
			File file = new File("ExtentReport/Screnshots/TC0"+TestCaseNumber+".png");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, file1);
			TC02.log(Status.INFO, "Screeenschoot taken successfully");
			TC02.log(Status.PASS, "Screenshot ok");
			report.flush();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void TC03_check_login() {
		try {
			driver.findElement(By.xpath("//input[@id='Email']")).clear();
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			String page_title = driver.getTitle();
			System.out.println("Page Title: "+page_title);
			TestCaseNumber = TestCaseNumber+1;
			ExtentTest TC03 = report.createTest("TC03 check login page displayed on logging in with username and password Text Case: 0"+TestCaseNumber);
			Assert.assertEquals(page_title, "Dashboard / nopCommerce administration");
			if(page_title.equals("Dashboard / nopCommerce administration")) {
				TC03.log(Status.PASS, "Login successful and admin page displayed successfully");
				TC03.log(Status.INFO, "Test case pass ");
				report.flush();
			}
			else {
				TC03.log(Status.FAIL, "TC03 login unsuccessful Test case: 0"+TestCaseNumber);
				TC03.log(Status.INFO, "check login ID and password");
				report.flush();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void after_admin_page() {
		driver.quit();
	}
}
