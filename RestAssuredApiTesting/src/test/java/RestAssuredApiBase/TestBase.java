package RestAssuredApiBase;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static ResponseBody response;
	public String empID ="51838";
	
	public Logger logger;
	
	@Test
	public void setup() {
		logger =Logger.getLogger("EmployeeRestApi");//added logger		
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		
		
	}
	
	
	

}
