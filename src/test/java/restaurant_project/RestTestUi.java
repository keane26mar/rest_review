package restaurant_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestTestUi {

	 private WebDriver webDriver;	
	@BeforeEach
	void setUp() throws Exception {
		 //Setting system properties of ChromeDriver
		  //to amend directory path base on your local file path
		  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		  //initialize FirefoxDriver at the start of test
		  webDriver = new ChromeDriver();	
	}
	@AfterEach
	void tearDown() throws Exception {
//		webDriver.close();
	}
	
	@Test
	void testTofindRestImageElement() {
		//Load website as a new page
		webDriver.navigate().to("http://localhost:8090/rest_review/RestServlet/dashboard");
		
		//Assert the title to check that we are indeed in the correct website
		assertEquals(webDriver.getTitle(), "Insert title here");
		
		System.out.println("title: "+ webDriver.getTitle());
		
		List<WebElement> elements = webDriver.findElements(By.className("card-img-top"));
		
		assertTrue(elements.size() > 0);
		System.out.println("total elements of images:" + elements.size());
		
		 List<WebElement> restaurantTitles = webDriver.findElements(By.className("card-title"));
		    
	        String actualTitle = restaurantTitles.get(0).getText();
	        String expectedTitle = "Blue kozina";
	        assertEquals(expectedTitle, actualTitle);
	        System.out.println("first restaurant name: " +actualTitle);
	        
	        String actualTitle2 = restaurantTitles.get(1).getText();
	        String expectedTitle2 = "iO Italian Osteria Singapore";
	        assertEquals(expectedTitle2, actualTitle2);
	        System.out.println("second restaurant name: " +actualTitle2);
	        
	        String actualTitle3 = restaurantTitles.get(2).getText();
	        String expectedTitle3 = "Candlenut";
	        assertEquals(expectedTitle3, actualTitle3);
	        System.out.println("third restaurant name: " + actualTitle3);
	        
	        List<WebElement> restDescription = webDriver.findElements(By.className("card-text"));
		    
		    String actualresult = restDescription.get(0).getText();
	        String expectedresult = "Traditional Greek cuisine & wines served in a charming restaurant that has a terrace.";
	        assertEquals(expectedresult, actualresult);
	        System.out.println("first restaurant description: " +actualresult);
	        
	        String actualresult2 = restDescription.get(1).getText();
	        String expectedresult2 = "Hip destination offering homestyle Italian cooking & wood-fired pizzas in stylish, modern surrounds.";
	        assertEquals(expectedresult2, actualresult2);
	        System.out.println("first restaurant description: " +actualresult2);
	        
	        String actualresult3 = restDescription.get(2).getText();
	        String expectedresult3 = "Refined Peranakan cuisine & an ample wine list offered in a lofty, rustic-chic setting.";
	        assertEquals(expectedresult3, actualresult3);
	        System.out.println("first restaurant description: " +actualresult3);      
	}
	

	  @Test
	  public void testGetRestById() {
		  
		  //Load website as a new page
		  webDriver.navigate().to("http://localhost:8090/rest_review/RestServlet/dashboard");
		  
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
	
}



