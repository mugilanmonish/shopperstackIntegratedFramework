package frontend;

import org.testng.annotations.Test;

import objectrepository.HomePage;
import utils.BaseClassUi;

public class VerifyFunctionalities extends BaseClassUi{
	
	@Test
	public void homePageContentTest() {
		HomePage home = new HomePage(driver);
		home.homePageVerify();
	}
}
