package d8APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class UpdateUser {
	@Test
	void Updateuserdetails(ITestContext context) {
		String AuthToken = "Bearer 0048c695d9043d8c3afbe08a835d5271242f18b298009d9dff0494fa4b754c7e";
		//int id=(int) context.getAttribute("user_id");
		int id=(int) context.getSuite().getAttribute("user_id");
		
		Faker faker = new Faker();
		String Name = faker.name().fullName();
		String email = faker.internet().emailAddress();
		
		JSONObject data =new JSONObject();
		data.put("name",Name);
		data.put("gender", "Female");
		data.put("email",email);
		// data.put("status", "inactive");
		data.put("status", "active");
		given()
			.header("Authorization",AuthToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.log().body();
	}

}
