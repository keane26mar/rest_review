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

class ReviewTestSelenium {

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
		webDriver.close();
	}
	
	@Test
	void testTofindReviewElements() {
		//Load website as a new page
		webDriver.navigate().to("http://localhost:8090/restaurant_project/ReviewServlet?restId=2");
		
		//Assert the title to check that we are indeed in the correct website
		assertEquals(webDriver.getTitle(), "Insert title here");
		
		System.out.println("title: "+ webDriver.getTitle());
		
		
		 List<WebElement> reviewTitles = webDriver.findElements(By.className("card-title"));
		    
	        String actualTitle = reviewTitles.get(0).getText();
	        String expectedTitle = "qwe";
	        assertEquals(expectedTitle, actualTitle);
	        System.out.println("first review name: " +actualTitle);
	        
	        String actualTitle2 = reviewTitles.get(1).getText();
	        String expectedTitle2 = "aaaaaaa";
	        assertEquals(expectedTitle2, actualTitle2);
	        System.out.println("second review name: " +actualTitle2);
	        
	        String actualTitle3 = reviewTitles.get(2).getText();
	        String expectedTitle3 = "abva";
	        assertEquals(expectedTitle3, actualTitle3);
	        System.out.println("third review name: " + actualTitle3);
	        
	        List<WebElement> reviewDescription = webDriver.findElements(By.className("card-text"));
		    
		    String actualResult = reviewDescription.get(0).getText();
	        String expectedResult = "qweqwe";
	        assertEquals(expectedResult, actualResult);
	        System.out.println("first review description: " +actualResult);
	        
	        String actualResult2 = reviewDescription.get(2).getText();
	        String expectedResult2 = "aaaaaaa";
	        assertEquals(expectedResult2, actualResult2);
	        System.out.println("second review description: " +actualResult2);
	        
	        String actualResult3 = reviewDescription.get(4).getText();
	        String expectedResult3 = "abvca";
	        assertEquals(expectedResult3, actualResult3);
	        System.out.println("third review description: " +actualResult3);
	        
	        String actualRating = reviewDescription.get(1).getText();
	        String expectedRating = "Rating : 4";
	        assertEquals(expectedRating, actualRating);
	        System.out.println("first rating description: " +actualRating);
	        
	        String actualRating2 = reviewDescription.get(3).getText();
	        String expectedRating2 = "Rating : 4";
	        assertEquals(expectedRating2, actualRating2);
	        System.out.println("second rating description: " +actualRating2);
	        
	        String actualRating3 = reviewDescription.get(5).getText();
	        String expectedRating3 = "Rating : 2";
	        assertEquals(expectedRating3, actualRating3);
	        System.out.println("third rating description: " +actualRating3);
	}
	
}



