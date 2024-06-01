package api;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import utils.BaseClassApi;
import utils.EndPointsLibrary;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;



public class getProducts extends BaseClassApi {
	@Test
	public void getAllProductsTest() {
		given()
		.spec(request)
		.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6eGN2Ym4yQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzE3MjY1NDA4LCJpYXQiOjE3MTcyMjk0MDh9.1X_zVLOEytF2yGBL59Mrc5LVM_pYrSTb_ZN_Byd28Ck")
		.queryParam("zoneId", "ALPHA")
		.when()
		.get(EndPointsLibrary.getProduct)
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(10000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
	
	@Test
	public void getDefaultProductsTest() {
		given()
		.spec(request)
		.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6eGN2Ym4yQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzE3MjY1NDA4LCJpYXQiOjE3MTcyMjk0MDh9.1X_zVLOEytF2yGBL59Mrc5LVM_pYrSTb_ZN_Byd28Ck")
		.when()
		.get(EndPointsLibrary.getAllProduct)
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(10000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
