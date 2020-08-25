package RestAssuredApiDataProvider;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.JSONObject;

public class DataProviderwithMethod {

	
	@Test(dataProvider ="empdataprovider")
	public void postNewEmployer(String ename, String esal,String eage) {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", ename);
		requestParams.put("salary",esal);
		requestParams.put("age",eage);
		
		
		httpRequest.header("Content-type" , "application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/create");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		Assert.assertEquals(responseBody.contains(ename),true);
		Assert.assertEquals(responseBody.contains(esal),true);
		Assert.assertEquals(responseBody.contains(eage),true);
        
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		
	}
	
	@DataProvider(name = "empdataprovider")
	String [][] empData() {
		
		String empdataprov[][] = {{"rk28","1000","227"},{"rk29","1000","227"},{"rk26","1000","227"}};
		return (empdataprov);
		
	}
	
	
	
	



	
	

}
