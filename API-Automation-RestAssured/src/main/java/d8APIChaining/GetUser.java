package d8APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class GetUser {
	@Test
	void getuserdetails(ITestContext context) {
		String AuthToken = "Bearer 0048c695d9043d8c3afbe08a835d5271242f18b298009d9dff0494fa4b754c7e";
		//int id=(int) context.getAttribute("user_id");// this should come from previous request
		int id=(int) context.getSuite().getAttribute("user_id"); // Fetching the value from the suite level variable..
		given()
			.header("Authorization",AuthToken)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.log().body()
			.statusCode(200);
	}
}
