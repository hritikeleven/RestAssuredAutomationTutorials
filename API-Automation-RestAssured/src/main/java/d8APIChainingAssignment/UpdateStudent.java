package d8APIChainingAssignment;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class UpdateStudent {
	@Test
	void UpdateDetails(ITestContext context) {
		int id = (int) context.getSuite().getAttribute("User_id");
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("location", faker.address().city()+" "+faker.address().state()+" "+faker.address().country());
		data.put("phone", faker.phoneNumber().cellPhone());
		String[] Courses = {"JAVA Automation","Rest ASsured"};
		data.put("courses", Courses);
		given()
			.contentType("application/json")
			.body(data.toString())
			.pathParam("StuID", id)
		.when()
			.put("http://localhost:3000/students/{StuID}")
		.then()
			.log().body();
				
	}

}
