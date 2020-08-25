package RestAssuredApiTesting.RestAssuredApiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.JSONObject;

public class Tc004_DataProvider {

	
	@Test
	public void postNewEmployer() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", "rk39");
		requestParams.put("salary","10000");
		requestParams.put("age","37");
		
		
		httpRequest.header("Content-type" , "application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/create");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		Assert.assertEquals(responseBody.contains("rk39"),true);
		Assert.assertEquals(responseBody.contains("10000"),true);
		Assert.assertEquals(responseBody.contains("37"),true);
        
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		
	}
	
}
