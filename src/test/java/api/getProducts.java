package api;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.LoginPojo;
import utils.BaseClassApi;
import utils.EndPointsLibrary;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;



public class getProducts extends BaseClassApi {
	@Test
	public void getAllProductsTest() {
		given()
		.spec(request)
		.auth().oauth2(jwtToken)
		.queryParam("zoneId", "ALPHA")
		.when()
		.get(EndPointsLibrary.getProduct)
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(10000l),TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void getDefaultProductsTest() {
		given()
		.spec(request)
		.auth().oauth2(jwtToken)
		.when()
		.get(EndPointsLibrary.getAllProduct)
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(10000l),TimeUnit.MILLISECONDS);
	}
}