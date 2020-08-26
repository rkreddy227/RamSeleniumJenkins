package RamSeleniumJenkins.RamSeleniumJenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;


public class DragNDropExample {
     
	static WebDriver driver;

	@Test
	public void testDragAndDropExample() throws InterruptedException {
		// First step set the driver location
		//WebDriverManager driver;

		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");					
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	        		
	
		driver.navigate().to("http://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));
		WebElement Sourcelocator = driver.findElement(By.cssSelector(".ui-draggable"));
		WebElement Destinationlocator = driver.findElement(By.cssSelector(".ui-droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		String actualText = driver.findElement(By.cssSelector("#droppable>p")).getText();
		Assert.assertEquals(actualText, "Dropped!");
		
		//Wait for the frame to be available and switch to it
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
	}
}
