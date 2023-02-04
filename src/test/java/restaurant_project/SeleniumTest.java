package restaurant_project;




import java.util.List;

import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeleniumTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;		

 
  @Test
  public void testGetRestById() {
	  
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/restaurant_project/RestServlet/dashboard");
	  
	  WebElement link = webDriver.findElement(By.partialLinkText("More Info"));
	  String href = link.getAttribute("href");
	  String restId = href.substring(href.indexOf("=") + 1);
      //Assert the title to check that we are indeed in the correct website
      assertEquals(webDriver.getTitle(), "Insert title here");
	  
	  System.out.println("title: "+ webDriver.getTitle());
	  
	  WebElement restIdLink = webDriver.findElement(By.xpath("//a[contains(@href, 'details?restId=')]"));
	  restIdLink.click();
	  
	  //Retrieve link using its id and click on it
	  String expectedResult = "Blue Kozina";
	  String restTitle = webDriver.findElement(By.className("card-title")).getText();
	  System.out.println("restTitle: " + restTitle);
	  //Assert that the restaurant information is displayed correctly
	 
	}
  


  
  
  
  @BeforeEach
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterEach
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.close();			
  }

}