package d8APIChainingAssignment;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class CreateStudent {
	@Test
	void NewStudent(ITestContext context) {
		Faker faker = new Faker();
		String Name = faker.name().fullName();
		String Location = faker.address().country()+" " +faker.address().state();
		String Phone = faker.phoneNumber().cellPhone();
		String[] Courses = {"JAVA Automation","Rest ASsured"};
		//Courses[0] = faker.educator().course();
		//Courses[1] = faker.educator().course();
		JSONObject data = new JSONObject();
		data.put("name", Name);
		data.put("location", Location);
		data.put("phone", Phone);
		data.put("courses", Courses);
		int id = given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getInt("id");
		
		System.out.println("Student ID is - "+id);
		System.out.println(data.toString());
		context.getSuite().setAttribute("User_id",id);
	
	}
	

}
