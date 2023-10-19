package d6SerializationandDeSerialization;
//POJO TO JSON is Serialization
//JSON TO POJO is DeSerialization

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class SerializationandDeSerialization {
	@Test(enabled = false)
	void ConvertPOJOtoJSON() throws JsonProcessingException {
		Students_POJO StuObj =new Students_POJO();
		StuObj.setName("Bunty Chuadhary");
		StuObj.setPhone("8273656678");
		StuObj.setLocation("London");
		
		ObjectMapper ObjMapper = new ObjectMapper();
		String JsonData = ObjMapper.writerWithDefaultPrettyPrinter().writeValueAsString(StuObj);
		System.out.println(JsonData);
		
	}
	@Test
	void ConvertJSONtoPOJO() throws JsonMappingException, JsonProcessingException {
		String JSONData = "{\r\n"
				+ "  \"name\" : \"Bunty Chuadhary\",\r\n"
				+ "  \"location\" : \"London\",\r\n"
				+ "  \"phone\" : \"8273656678\",\r\n"
				+ "  \"courseArr\" : null\r\n"
				+ "}";
		ObjectMapper ObjMapper = new ObjectMapper();
		Students_POJO stu = ObjMapper.readValue(JSONData, Students_POJO.class);
		System.out.println("Name : "+stu.getName());
		System.out.println("Location : "+stu.getLocation());
		System.out.println("Phone : "+stu.getPhone());
		System.out.println("Courses : "+stu.getCourseArr());
		
	}

}
