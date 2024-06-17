package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverUtitlity;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement emailTxtFld;
	
	@FindBy(id = "Password")
	private WebElement passwordTxtFld;
	
	@FindBy(id = "Login")
	private WebElement loginButton;
	
	
	public void loginToApp(String username, String password) {
		emailTxtFld.sendKeys(username);
		passwordTxtFld.sendKeys(password);
		loginButton.click();
	}
}
