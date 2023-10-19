package d8APIChainingAssignment;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import javax.naming.Context;

public class GetStudent {
	@Test
	void FetchDetails(ITestContext context) {
		int id = (int) context.getSuite().getAttribute("User_id");
		given()
			.pathParam("StuID", id)
		.when()
			.get("http://localhost:3000/students/{StuID}")
		.then()
			.log().body();
	}

}
