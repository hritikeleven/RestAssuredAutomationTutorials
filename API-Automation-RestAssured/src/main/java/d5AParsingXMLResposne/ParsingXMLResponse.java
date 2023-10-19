package d5AParsingXMLResposne;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.XMLParser;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingXMLResponse {
	@Test(enabled = false)
	//Approach 1 
	void testXMLResponse() {
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.log().body()
			.header("content-type",equalTo("application/xml; charset=utf-8")) 
			.body("TravelerinformationResponse.page",equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation.name[0 ]",equalTo("Developer"));
	}
	@Test(enabled = false)
	//Approach- 2
	void testXMLResponseviaVariable() {
		Response res = given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getHeader("content-type"),"application/xml; charset=utf-8" );
		Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.page").toString(), "1");
		Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation.name[0]"), "Developer");
		}
	
	@Test
	void AdvanceXMLResponseValidation() {
		Response res = given()
			.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		XmlPath xmlobj = new  XmlPath(res.asString());
		List<String>travellers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		List<String> travellers_Name = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status =false;
		for(String i:travellers_Name) {
			//System.out.println(i);
			if(i.equals("karen")){
				status= true;
				break;
			}
		}
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(travellers.size(),10);
		Assert.assertEquals(status, true);
		/*if(status== true) {
			System.out.println("Traveller found");
		}
		else {
			System.out.println("Traveller not found in the list");
		}
		*/
	}

}
