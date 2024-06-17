package objectrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage23 {
	
	public ProductPage23(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(@class,'ProductDisplay_productBrand')]/h2")
	private WebElement productBrand;
	
	@FindBy(xpath = "//div[contains(@class,'ProductDisplay_productTitle')]/h4")
	private WebElement productTitle;
	
	@FindBy(xpath = "//span[text()='add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//*[@id='cartIcon']")
	private WebElement cartIcon;
	
	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}
	
	public String getTextOfProduct() {
		String titleName = productTitle.getText();
		return titleName;
	}

}
