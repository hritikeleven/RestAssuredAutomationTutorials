package d3ParameterAndQuerry;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class PathandquerryParameters {

	@Test(enabled = false)
	void testQuerryandPathParameters() {
		//https://reqres.in/api/users?page=2&id=10
		//Passing the path and the query in the request
		given()
		.pathParam("mypath", "users")
		.queryParam("page","2")
		.queryParam("id", 10)
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log().body();
	}
	
	//Cookies and headers
	 @Test(enabled = false)
	 void handlingCockiesandHeader() {
		 //https://www.google.co.in/
		 given()
		 
		 .when()
		 	.get("https://www.google.co.in/")
		 .then()
		 	.statusCode(200)
		 	.cookie("AEC")
		 	.log().body();
	 }
	 @Test(enabled = false)
	 void extractCookiefromResponse() {
		 //Extract the cookies and cookie value form the response
		 Response res = given()
		
		.when()
			.get("https://www.google.co.in/");

		 String AEC_Cookie = res.getCookie("AEC");
		 System.out.println("Cookie Values is :- "+ AEC_Cookie);
		 Map<String, String> Cookies = res.getCookies();
		 System.out.println("Cookies are - ");
		 System.out.println(Cookies.keySet());
		 System.out.println(Cookies.get("NID"));
		 System.out.println("For Loop for all the cookies are - ");
		 for(String K:Cookies.keySet()) {
			 String Cookie_Value = Cookies.get(K);
			 System.out.println(K+" --- "+Cookie_Value);
		 }
		 
	 }
	 @Test(enabled = false)
	 void HeaderDemo() {
		 given()			
		.when()
			.get("https://www.google.co.in/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.log().headers(); 
	 }
	 
	 @Test
	 void ExtractheaderInfo() {
		 Response res =given()			
					.when()
					.get("https://www.google.co.in/");
		System.out.println("Content type header information is :- "+res.getHeader("Content-Type"));
		System.out.println(res.getHeaders());
		System.out.println("----------------------------------------------------------");
		System.out.println(res.getCookies());
	 }

}






















