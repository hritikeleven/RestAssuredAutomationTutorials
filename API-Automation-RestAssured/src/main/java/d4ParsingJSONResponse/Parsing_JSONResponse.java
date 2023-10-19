package d4ParsingJSONResponse;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.util.HashMap;

public class Parsing_JSONResponse {
	@Test(enabled = false)
	void JSONresponse() {
		//Approach - 1
		/*
		given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/store")
		.then()
			.statusCode(200)
			.log().body()
			.body("book[3].author", equalTo("J. R. R. Tolkien"));
	} */
		
		//Approach - 2
		Response res = given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("content-type"),"application/json; charset=utf-8");
		Assert.assertEquals(res.jsonPath().get("book[3].title"),"The Lord of the Rings");
	}
	//Printing All Book Names
	// Moving one step further in Approach 2 
	@Test(enabled = false)
	void JSONbodyResponseaValidation() {
		Response res = 
		given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/store");
		
		JSONObject jo = new JSONObject(res.asString());
		
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			
			String BookName;
			BookName = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println("Books in the JSON response are - "+BookName);
		}
	}
	
		//Best way to check if a JSON value is there or not 
	@Test(enabled =false)
	 void FindingJSONresponse() {
		Response res = 
		given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/store");
		JSONObject jo = new JSONObject(res.asString());
		Boolean Status = false;
		for(int i = 0; i<jo.getJSONArray("book").length();i++) {
			String BookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(BookTitle.equals("Moby Dick")) {
				Status = true;
				break;
			}
		}
		Assert.assertEquals(Status, true);
	}
	@Test
	void TotalBookAmount() {
		Response res = given()
				.contentType("application/json")
		.when()
			.get("http://localhost:3000/store");

		JSONObject jo = new JSONObject(res.asString());
		double Total_Price = 0;
		for(int i=0;i<jo.getJSONArray("book").length();i++) {
			String CurrentPrice = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			Total_Price = Total_Price + Double.parseDouble(CurrentPrice);
		}
		System.out.println("Total Price of books are - "+ Total_Price);
	}
	
		
}


























