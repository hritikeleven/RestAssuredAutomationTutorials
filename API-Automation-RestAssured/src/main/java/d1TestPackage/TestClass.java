package d1TestPackage;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


public class TestClass {
	
	int id;
	@Test(priority=1)
	void getUser()

    {
          given()

          .when()
                 .get("https://reqres.in/api/users?page=1")
          .then()
                 .statusCode(200)
                 .body("page",equalTo(1))
                 .log().body();

    }
	@Test(priority=2)
	void createUser() {
		HashMap hm = new HashMap();
		hm.put("name","Hritik");
		hm.put("job", "Quality Engineer");
		
		id = given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		//.then()
		//	.statusCode(201)
		//	.log().all();		
	}
	@Test(priority=3,dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap hm = new HashMap();
		hm.put("name","Hritik Chauhan");
		hm.put("job", "Senior Quality Engineer");
		
		given()
			.contentType("application/json")
			.body(hm)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(200)
			.log().body();		
	}
	@Test(priority =4,dependsOnMethods = {"createUser"})
	void deleteUser() {
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
		
	}
}
