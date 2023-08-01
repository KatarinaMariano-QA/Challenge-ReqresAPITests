
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class UsersUpdateTests {
	
	@BeforeClass
	public static void InnitialMethod() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
	}
	
	@Test
	public void ShouldUpdatedUserSuccessfully() {
		given()
			.contentType("application/json")
			.body("{\"name\": \"morpheus updated\", \"job\": \"zion resident updated\"}")
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.body(containsString("updatedAt"));
	}
	
	@Test
	public void ShouldUpdatedUserNameSuccessfully() {
		given()
			.contentType("application/json")
			.body("{\"name\": \"morpheus returned\"}")
		.when()
			.patch("/users/2")
		.then()
			.statusCode(200)
			.body(containsString("updatedAt"));
	}
}