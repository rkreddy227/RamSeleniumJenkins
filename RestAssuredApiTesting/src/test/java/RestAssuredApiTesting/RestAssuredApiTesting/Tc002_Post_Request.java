package RestAssuredApiTesting.RestAssuredApiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.JSONObject;

public class Tc002_Post_Request {
	
	//http://restapi.demoqa.com/customer/registe
	@Test
	public void RegistrationSuccessfull() {
		
		//Specify uri
		RestAssured.baseURI ="http://restapi.demoqa.com/customer" ;
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request Object (Body) Jason
		//Reuest Payload sending along with post request
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("FirstName","JohnXYZ" );
		requestParams.put("LasttName","XYZJohn" );
		requestParams.put("UserName","JohnXYZ" );
		requestParams.put("Password","JohnXYZxyz" );
		requestParams.put("Email","JohnXYZ@gmail.com" );
		
		httprequest.header("Content-Type","application/json");
		
		
		// Add the Json to the body of the request
		//attch data to the request
		httprequest.body(requestParams.toJSONString());

		// Post the request and check the response
		Response response = httprequest.request(Method.POST,"/register");		
				ExtractableResponse<Response> jsonResp = null;
		
		  //Print response in console window
		String responseBody = response.getBody().asString();
		  
		  System.out.println("Response Body is "+responseBody);
		  
		  //JsonPath it gives complete json path
		  JsonPath jsonpath = response.jsonPath();
		  
		  //status code validataion 
		  int statusCode = response.getStatusCode();
		  System.out.println("status code: " +statusCode);
		  Assert.assertEquals(statusCode, 201);
		  
		  //success code validation
		  String successCode = response.jsonPath().get("successcode");
		  Assert.assertEquals(successCode,"OPERATION SUCCESS");
		  
		  
		  
		 
		  
	}
}
