package d5UploadingFiles;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class UploadingFiles {
	@Test(enabled = false)
	void SingleFileUplaod() {
		File Myfile = new File("D:\\Games\\TextFile.txt");
		given()
			.multiPart(Myfile)
			//.contentType("multipart/form-data")
			
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
			.log().all()
			.body("fileName",equalTo("TextFile.txt"));
	}
	@Test
	void MultipleFilesUpload() {
		File myfile1 = new File("D:\\\\Games\\\\TextFile1.txt");
		File myfile2 = new File("D:\\\\Games\\\\TextFile2.txt");
		//Another approach is that we can use a Array variable to store the files and can pass it with a single multipart method..
		// File filearr = [myfile1 ,myfile2]
		// in given()
		// .multipart("files", filearr)
		// This will only work when the API is designed to accept array as a input for 2 or more files.
		
		given()
			.contentType("multipart/form-data")
			.multiPart("files",myfile1)
			.multiPart("files",myfile2)
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		.then()
			.statusCode(200)
			.body("[0].fileName",equalTo("TextFile1.txt"));
			
			
	}

}
