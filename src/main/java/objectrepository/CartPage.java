package objectrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverUtitlity;

public class CartPage {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Remove from cart']")
	private WebElement removeFromCart;
	
	@FindBy(xpath = "//div[@aria-describedby='alert-dialog-slide-description']/descendant::button[text()='Yes']")
	private WebElement removeCartPopupYes;
	
	@FindBy(xpath = "//span[text()='Total Price']/following-sibling::span")
	private WebElement totalPrice;
	
	public WebElement getTotalPrice() {
		return totalPrice;
	}
	
	public void removeFromCart(WebDriverUtitlity wUtils) {
		removeFromCart.click();
		wUtils.waitUntilEleToBeClickable(5, removeCartPopupYes);
		removeCartPopupYes.click();
	}
	
}