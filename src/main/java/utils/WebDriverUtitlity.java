package utils;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtitlity {
	WebDriver driver;
	Actions act;
	
	public WebDriverUtitlity(WebDriver driver){
		this.driver = driver;
		act = new Actions(this.driver);
	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow() {
		driver.manage().window().minimize();
	}

	public void waitForEleImplicitly(int sec)  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public void waitUntilEleToBeVisible(int sec, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilEleToBeClickable(int sec, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilToGetTitle(int sec, String title) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void mouseHover(WebElement element) {
		act.click(element).perform();
	}
	
	public void dragAndDrop(WebElement src, WebElement dst) {
		act.dragAndDrop(src, dst).perform();
	}
	
	public void dragAndDrop(WebElement src, int x, int y) {
		act.dragAndDropBy(src, x, y).perform();
	}
	
	public void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}
	
	public void sendValueUsingJs(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]", element, value);
	}
	
	public void scrollAction(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void scrollBarAction(WebElement element, int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void clickOnEleUsingJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void srollToTopUsingJs() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,0)");
	}
	
	public void scrollTillElementToBeVisible(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void switchWindowUsingUrl(String url) {
		Set<String> allWidIds=driver.getWindowHandles();
		for (String wid : allWidIds) {
			String text = driver.switchTo().window(wid).getCurrentUrl();	
			if(text.contains(url)) {
				break;
			}
		}
	}
	
	public void switchToWindowUsingTitle(String title, String expWid) {
		Set<String> allWidIds=driver.getWindowHandles();
		Iterator<String> it = allWidIds.iterator();
		while(it.hasNext()) {
			String win = it.next();
			String currentTitle = driver.switchTo().window(win).getTitle();
			if(currentTitle.contains(expWid))
				break;
		}
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void dissmissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextInAlert() {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}	
	
	public void handleDropDown(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void handleDropDown(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./screenshot/"+screenShotName+".png";
		File dst = new File(path);
		String srcPath = dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return srcPath;
	}
	
	public void customWaitAndCLick(WebElement element) throws InterruptedException {
		int count = 0;
		while(count<=40) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(500);
				count++;
			}
		}
	}	
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	public void waitForTitleLoad(String actualTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.titleIs(actualTitle));
	}
}