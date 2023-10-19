package d7AuthenticationTypes;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentication {
	@Test(enabled =false)
	void BasicAuthentication() {
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(enabled= false)
	void DigestAuthentication() {
		given()
		.auth().digest("postman", "password")
	.when()
		.get("https://postman-echo.com/basic-auth")
	.then()
		.statusCode(200)
		.log().all();
	}
	@Test(enabled = false)
	void PremptiveAuthentication() {
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(enabled = false)
	void BearerTokenAuth() {
		String Bearer_token = "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";
		given()
			.headers("Authorization","Bearer "+Bearer_token)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().body();
	}
	@Test
	void Oauth1Authentication() {
		given()
			.auth().oauth("ConsumerKey", "ConsumerSecret", "accessToken", "SecretToken")
		.when()
			.get("URL")
		.then()
			.statusCode(200)
			.log().body();
	}
	@Test
	void Oauth2Authentication() {
		given()
			.auth().oauth2("AccessTOKEN")
		.when()
			.get("URL")
		.then()
			.statusCode(200)
			.log().all();
	}
	

}
