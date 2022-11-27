package NOPCommerce_Regression_suite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Dashboard_Page_TestCases extends Parent_Initializations.Initializations{

	@Test
	public void TC04_check_dashboard_page_title() {
		System.out.println("TC number: "+TestCaseNumber);
		driver.get("https://admin-demo.nopcommerce.com/");
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String page_title = driver.getTitle();
		System.out.println("Page Title: "+page_title);
		TestCaseNumber = TestCaseNumber+1;
		driver.manage().window().maximize();
	}
}
