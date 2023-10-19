package d8APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	@Test
	void Tes_CreateUser(ITestContext context) {
		
		
		String AuthToken = "Bearer 0048c695d9043d8c3afbe08a835d5271242f18b298009d9dff0494fa4b754c7e";
		
		Faker faker = new Faker();
		
		String Name = faker.name().fullName();
		String email = faker.internet().emailAddress();
		
		JSONObject data = new JSONObject();
		data.put("name",Name);
		data.put("gender", "Male");
		data.put("email",email);
		data.put("status", "inactive");
		
		
		int id = given()
			.header("Authorization",AuthToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
		System.out.println("ID is - "+id);
		
		//context.setAttribute("user_id", id); // The scope of this variable is limited to the test level inside the TestNG.xml.
		//If we want to set the attribute scope of this variable at SUITE level than the command is - 
		context.getSuite().setAttribute("user_id", id);
		//With the help of this command we can do API chaining in multiple Test in a single suite (Plz refer to the Second XML FILE)...
		//adding get suite make it like a global variable and it has scope in both levels - test level and suite level.
		//Without getsuite method it act like a local variable and it has scope limited to only test level
	
	}

}
