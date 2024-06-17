package objectrepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverUtitlity;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='loginBtn']")
	private WebElement loginButton;


	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	@FindBy(xpath = "//div[text()='M']")
	private WebElement accountIcon;

	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiCard-root featuredPro')]")
	private List<WebElement> homePageTotalProducts;

	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeLink;

	@FindBy(xpath = "//button[@id='addToCart']") 
	private List<WebElement> allAddToCart;

	@FindBy(xpath = "//*[@id='cartIcon']")
	private WebElement cartIcon;
	
	@FindBy(xpath = "//span[text()='FOREVER21']/ancestor::div[contains(@class,'featuredProducts_cardFo')]/descendant::button[@id='addToCart']")
	private WebElement foreverProductAddToCart;
	
	@FindBy(xpath = "//span[text()='ROADSTER']")
	private WebElement roadsterProduct;
	
	public WebElement getRoadsterProduct() {
		return roadsterProduct;
	}
	
	public WebElement getForeverProductAddToCart() {
		return foreverProductAddToCart;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	@FindBy(xpath = "//*[name()='svg' and @id='cartIcon']/following-sibling::span")
	private WebElement cartIconNumber;

	public WebElement getCartIconNumber() {
		return cartIconNumber;
	}

	public void logoutToApp() {
		accountIcon.click();
		logout.click();
	}

	public void homePageVerify(String homePageTitle, WebDriverUtitlity wUtils) {
		wUtils.waitForTitleLoad(homePageTitle);
		assertEquals(homePageTitle, wUtils.getCurrentPageTitle());
		assertTrue(homeLink.isDisplayed());
		assertEquals(12, homePageTotalProducts.size());
	}
}
