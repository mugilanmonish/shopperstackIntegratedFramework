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
		.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6eGN2Ym4yQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzE3NTIwNjUwLCJpYXQiOjE3MTc0ODQ2NTB9.qR_RDPGa27TL8STCL16YUukZp1Gh3BtuQThbfj6v-X0")
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
		.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6eGN2Ym4yQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzE3NTIwNjUwLCJpYXQiOjE3MTc0ODQ2NTB9.qR_RDPGa27TL8STCL16YUukZp1Gh3BtuQThbfj6v-X0")
		.when()
		.get(EndPointsLibrary.getAllProduct)
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(10000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
