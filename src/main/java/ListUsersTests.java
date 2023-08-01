
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class ListUsersTests {
	
	@BeforeClass
	public static void InnitialMethod() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
	}
	
	@Test
	public void ShouldReturnListOfUsersSuccessfully() {
		given()
		.when()
			.get("/users")
		.then()
			.statusCode(200)
			.body(notNullValue());
	}
	
	@Test
	public void ShouldCheckThatTheListOfUsersIsNotEmptyAndTheNumberOfRecordsOnThePage() {
		given()
		.when()
			.get("/users")
		.then()
			.statusCode(200)
			.body("data", hasSize(notNullValue()))
			.body("per_page", is(6));
	}

	
}