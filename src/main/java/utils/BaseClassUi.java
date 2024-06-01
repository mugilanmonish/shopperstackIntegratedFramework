package utils;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import objectrepository.HomePage;
import objectrepository.LoginPage;
public class BaseClassUi {
	
	public WebDriver driver;
	public static WebDriver  sdriver;
	public WebDriverUtitlity wUtils;
	public DatabaseUtility dUtils = new DatabaseUtility();
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public JavaUtility jUtils = new JavaUtility();
	public RequestSpecification request;
	public ResponseSpecification response;
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDb() throws SQLException {
		Reporter.log("Before suite executed",true);
	}
	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable {
		String Browser = fUtils.readDataFromPropertyFile("browser");
		String URL = fUtils.readDataFromPropertyFile("seleniumBaseUrl");
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			Reporter.log("--CHROME BROWSER LAUNCHED SUCCESSFULLY--",true);
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("--FIREFOX BROWSER LAUNCHED SUCCESSFULLY--",true);
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			Reporter.log("-- BROWSER LAUNCHED SUCCESSFULLY--",true);
		}
		else {
			Reporter.log("--INVALID BROWSER--", true);
		}
		sdriver = driver;
		wUtils = new WebDriverUtitlity(driver);
		wUtils.maximizeWindow();
		wUtils.waitForEleImplicitly(30);
		driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws Throwable {
		String username = "zxcvbn2@gmail.com";
		String password = "Qwerty@123";
		HomePage home = new HomePage(driver);
		home.getLoginButton().sendKeys(Keys.ENTER);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		Reporter.log("--LOGGED IN TO APPLICATION--", true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
		HomePage home = new HomePage(driver);
		home.logoutToApp();
		Reporter.log("--LOGGED OUT THE APPLICATION--", true);
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		Reporter.log("--BROWSER CLOSED--", true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDb() throws SQLException {
		Reporter.log("After suite Executed", true);
	}
}
