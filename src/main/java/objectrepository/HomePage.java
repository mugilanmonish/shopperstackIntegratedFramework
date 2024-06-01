package objectrepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void clickLogin() {
		loginButton.click();
	}
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeLink;

	
	public void logoutToApp() {
		accountIcon.click();
		logout.click();
	}
	
	public void homePageVerify() {
		assertTrue(homeLink.isDisplayed());
		assertEquals(12, homePageTotalProducts.size());
	}
}

