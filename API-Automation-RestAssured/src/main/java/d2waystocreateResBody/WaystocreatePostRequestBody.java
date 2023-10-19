package d2waystocreateResBody;
/*
 * Approach to make a request body -
 * Using HashMap
 * Using JSON.ORG
 * Using POJO Class
 * Using any external JSON file Data.
 * 
 */

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class WaystocreatePostRequestBody {
	// Using HashMap --
	@Test(enabled =false)
	void testPostHashMap()
	{
		HashMap data = new HashMap();
		data.put("name", "Henry Ford");
		data.put("location", "France");
		data.put("phone", "8273657723");
		String CourseArr[]= {"Python","Selenium","Data Mapping"};
		data.put("courses", CourseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("Henry Ford"))
			.log().all();
	}
	@Test(enabled = false)
	void deluser()
	{
		given()
		.when()
			.delete("http://localhost:3000/students/9")
		.then()
			.statusCode(200)
			.log().all();
	}
	//--------------------------------------------------------------------------------------------//
	//-------------USING JSON.org-------------------------------//
	@Test(enabled =false)
	void PostRequestbyJSONorg() {
		JSONObject data = new JSONObject();
		data.put("name","Kapil Dev");
		data.put("location", "London");
		data.put("phone", "9283768");
		String CourseArr[]= {"English","Hindi"};
		data.put("courses", CourseArr);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.log().all()
			.body("name",equalTo("Kapil Dev"));
		
	}
	//--------------------------------------------------------------------------------------------//
	//-------------USING POJO Class-------------------------------//
	@Test(enabled = false)
	void PostRequestUsingPOJOClass() {
		POJO_Class data = new POJO_Class();
		data.setName("Manish Kumar");
		data.setLocation("Newton MA");
		data.setPhone("2837692893");
		String CoursesArr[]= {"Application Architexure", " APP Management"};
		data.setCourseArr(CoursesArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.log().body()
			.body("name", equalTo("Manish Kumar"));
		
	}
	//--------------------------------------------------------------------------------------------//
	//-------------USING External JSON file-------------------------------//
	@Test(enabled = false)
	void PostRequestusingExternalJSONFile() throws FileNotFoundException {
		File f= new File(".\\StudentName.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("Rishabh Pant"))
			.log().body();
		
	}
	
	

}
