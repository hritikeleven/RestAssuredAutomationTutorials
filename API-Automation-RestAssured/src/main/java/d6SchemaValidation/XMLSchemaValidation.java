package d6SchemaValidation;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {
	@Test
	void XMLSchemaValidator() {
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("TravellerAPISchema.xsd"))
			.log().body();
	}

}
