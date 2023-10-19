package d7FakeDataGeneration;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeData {
	@Test
	void FakeDataGeneration() {
	Faker faker =new Faker();
	String FullName = faker.name().fullName();
	String Username = faker.name().username();
	String Password = faker.internet().password(true);
	String Email = faker.internet().emailAddress();
	String PhoneNo = faker.phoneNumber().phoneNumber();
	System.out.println(FullName);
	System.out.println(Username);
	System.out.println(Password);
	System.out.println(Email);
	System.out.println(PhoneNo);
	
	}
}
