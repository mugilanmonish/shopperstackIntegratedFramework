package frontend;


import org.testng.annotations.Test;

import objectrepository.HomePage;
import utils.BaseClassUi;

public class VerifyFunctionalitiesTest extends BaseClassUi{
	
	@Test
	public void CheckHomePageContent() {
		HomePage home = new HomePage(driver);
		home.getHomeLink().click();
	}
}