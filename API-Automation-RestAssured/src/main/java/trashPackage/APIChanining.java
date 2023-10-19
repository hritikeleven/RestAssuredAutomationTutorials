/*package d8APIChaining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class APIChanining {
	@Test
	void ChainingAPI() {
		String AuthToken = "Bearer 0048c695d9043d8c3afbe08a835d5271242f18b298009d9dff0494fa4b754c7e";
		Faker faker = new Faker();
		given()
			.headers("Authorization","Bearer "+AuthToken)
		.when()
			.post("https://gorest.co.in/public/v2/users/628105")
		.then()
			.log().all()
			.statusCode(200);
		
	}

}
*/
package trashPackage;

