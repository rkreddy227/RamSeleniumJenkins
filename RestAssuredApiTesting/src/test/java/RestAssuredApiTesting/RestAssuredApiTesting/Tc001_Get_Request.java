package RestAssuredApiTesting.RestAssuredApiTesting;


import org.junit.jupiter.api.Test;

//
//import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Tc001_Get_Request {

	@Test
	public void getWetherReportDetails() {
		
		//Specify uri
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city" ;
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		//Response object path parameter Hyderabd
		Response response =httprequest.request(Method.GET,"/Hyderabad");
		
		//Print response in console window
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is "+responseBody);
		
		
		//status code validataion		
		int statusCode = response.getStatusCode();
		System.out.println("status code: " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status line verification
		String statusLine =response.getStatusLine();
		System.out.println("statusLIne"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		 
		 // Then simply query the JsonPath object to get a String value of the node
		 // specified by JsonPath: City (Note: You should not put $. in the Java code)
//		 System.out.println(jsonPathEvaluator.get("City"));
//		 System.out.println(jsonPathEvaluator.get("Temperature"));
		 
		 
		
		
				
		
	}

}
