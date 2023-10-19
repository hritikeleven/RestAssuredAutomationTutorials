package d8APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class DeleteUser {
	@Test
	void DelUser(ITestContext context) {
		String AuthToken = "Bearer 0048c695d9043d8c3afbe08a835d5271242f18b298009d9dff0494fa4b754c7e";
		//int id=(int) context.getAttribute("user_id");
		int id=(int) context.getSuite().getAttribute("user_id");
		given()
			.header("Authorization", AuthToken)
			.pathParam("id",id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.log().body();
			
	}

}
