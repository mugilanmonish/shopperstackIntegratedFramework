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
public class BaseClassApi {
	
	public WebDriver driver;
	public static WebDriver  sdriver;
	public WebDriverUtitlity wUtils;
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public JavaUtility jUtils = new JavaUtility();
	public RequestSpecification request;
	public ResponseSpecification response;
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDb() throws SQLException {
		request = new RequestSpecBuilder()
				.setBaseUri(Iconstants.baseUri)
				.setContentType(ContentType.JSON).build();
		response = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		Reporter.log("Api preconditions executed",true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDb() throws SQLException {
		Reporter.log("After suite Executed", true);
	}
}
