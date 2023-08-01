
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.*;

import static io.restassured.RestAssured.given;

public class UsersDeleteTests {

	@BeforeClass
	public static void InnitialMethod() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api";
	}
	
	@Test
	public void ShouldDeletedUserSuccessfully() {
		given()
		.when()
			.delete("/users/2")
		.then()
			.statusCode(204);
	}
	
}