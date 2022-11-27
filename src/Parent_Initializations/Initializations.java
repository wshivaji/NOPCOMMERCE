package Parent_Initializations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Initializations {
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public int TestCaseNumber = 0;
	
	@BeforeClass
	public void Init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		report = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport/Test_Report.html");
		spark.config().setReportName("NOPCOMMERCE Admin panel Regression Test Suite Report");
		spark.config().setDocumentTitle("All Test Cases Report (Regression Test)");
		spark.config().setTheme(Theme.DARK);
		spark.config().setEncoding("utf-8");
		report.attachReporter(spark);
	}
}
