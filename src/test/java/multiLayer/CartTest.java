package multiLayer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import objectrepository.CartPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.ProductPage23;
import utils.BaseClassApi;
import utils.DatabaseUtility;
import utils.ExcelUtility;
import utils.FileUtility;
import utils.JavaUtility;
import utils.WebDriverUtitlity;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseClassApi {
	public WebDriverUtitlity wUtils;
	public DatabaseUtility dUtils = new DatabaseUtility();
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();

	@Test
	public void VerifyTheAddedProductInApi() throws IOException, InterruptedException {
		// add to cart in ui
		WebDriver driver = new ChromeDriver();
		wUtils = new WebDriverUtitlity(driver);
		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		ProductPage23 pp23 = new ProductPage23(driver);
		wUtils.maximizeWindow();
		wUtils.waitForEleImplicitly(30);
		driver.get(fUtils.readDataFromPropertyFile("seleniumBaseUrl"));
		wUtils.clickOnEleUsingJs(home.getLoginButton());
		login.loginToApp("zxcvbn2@gmail.com", "Qwerty@123");
		home.getRoadsterProduct().click();
		wUtils.srollToTopUsingJs();
//		wUtils.waitUntilEleToBeClickable(10, pp23.getAddToCart());
		Thread.sleep(1000);
		pp23.getAddToCart().click();
		String uiDetails = pp23.getTextOfProduct();
		
		// verify the cart in api
		Response response = given()
				.spec(request)
				.auth().oauth2(jwtToken)
				.pathParam("shopperId", 78463)
				.when()
				.get("/shoppers/{shopperId}/carts");
		response.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		.log().all();
		String apiDetails = response.jsonPath().get("data[0].productName");
		System.out.println(uiDetails);
		System.out.println(apiDetails);
		
		// validation
		boolean verification = jUtils.compareTwoObjects(uiDetails, apiDetails);
		assertTrue(verification);
		pp23.getCartIcon().click();
		
		CartPage cPage = new CartPage(driver);
		home.getCartIcon();
		cPage.removeFromCart(wUtils);
		home.logoutToApp();
		driver.quit();
	}
}