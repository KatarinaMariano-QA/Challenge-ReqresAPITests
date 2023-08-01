
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class LoginTests {
	
	@BeforeClass
	public static void InnitialMethod() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
	}
	
	@Test
	public void ShouldRealizedLoginSuccessfully() {
		given()
			.contentType("application/json")
			.body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }")
		.when()
			.post("/login")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void ShouldNotRealizedLoginWithIncorrectEmail() {
		given()
			.contentType("application/json")
			.body("{ \"email\": \"eve.holteqres.in\", \"password\": \"citysliddcka\" }")
		.when()
			.post("/login")
		.then()
			.statusCode(400)
			.body("error", containsString("user not found"));
	}
	
	@Test
	public void ShouldNotRealizedLoginWithIncorrectPassword() {
		given()
			.contentType("application/json")
			.body("{ \"email\": \"eve.holt@reqres.in\"}")
		.when()
			.post("/login")
		.then()
			.statusCode(400)
			.body("error", containsString("Missing password"));
	}

	
}