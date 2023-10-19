package d8APIChainingAssignment;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DeleteStudent {
	@Test
	void RemoveStudent(ITestContext context ) {
		int id = (int) context.getSuite().getAttribute("User_id");
		given()
			.pathParam("StuID", id)
		.when()
			.delete("http://localhost:3000/students/{StuID}")
		.then()
			.log().body();
		System.out.println("The record has been deleted....");
		
	}

}
