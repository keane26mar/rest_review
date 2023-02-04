package restaurant_project;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class UserTest_selenium {
	
	 private WebDriver webDriver;	
	 private UserCollection uc;
	 private User u1;
	 private User u2;	
	 private User u3;
	 private User u4;
	 private int userId;
	 private final int USERCOLLECTION_SIZE = 3;

	
	@BeforeEach
	void setUp() throws Exception {
		//Setting system properties of ChromeDriver
		  //to amend directory path base on your local file path
		  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		  //initialize FirefoxDriver at the start of test
		  webDriver = new ChromeDriver();	
		  
		  uc = new UserCollection();
			userId = (3);
			u1 = new User( 1, "james", "123","james@gmail.com", "97889009");
			u2 = new User( 2,  "Tommy", "123","Tommy@gmail.com", "97920384");
			u3 = new User( 3, "Pearl", "123","Pearl@gmail.com", "97328920");
			uc.addUser(u1);
			uc.addUser(u2);
			uc.addUser(u3);
			uc.getUsers();
		
	}

	

	@Test
	void testForWebsite() {
		//Load website as a new page
				webDriver.navigate().to("http://localhost:8090/rest_review/Login.jsp");
				
				//Assert the title to check that we are indeed in the correct website
				assertEquals(webDriver.getTitle(), "Restaurant review");
				
				System.out.println("title: "+ webDriver.getTitle());
				
	}
//	@Test
//	void testForLoginValid() {
//		webDriver.navigate().to("http://localhost:8090/rest_review/Login.jsp");
//		
//		String actualUrl="http://localhost:8090/rest_review/RestServlet/dashboard";
//		String expectedUrl= webDriver.getCurrentUrl();		
//	
//		webDriver.findElement(By.id("username")).sendKeys("james");
//		webDriver.findElement(By.id("password")).sendKeys("123");
//		webDriver.findElement(By.id("Sign in")).click();
//		
//		assertEquals(actualUrl, expectedUrl);
//		
//		System.out.println("title: "+ webDriver.getTitle());
//	}
	

//	@Test
//	void testForRegistration() {
//		webDriver.navigate().to("http://localhost:8090/rest_review/Signup.jsp");
//		String actualUrl="http://localhost:8090/rest_review/Login.jsp";
//		String expectedUrl= webDriver.getCurrentUrl();
//		
//		webDriver.findElement(By.id("username")).sendKeys("james");
//		webDriver.findElement(By.id("password")).sendKeys("james");		
//		webDriver.findElement(By.id("email_address")).sendKeys("james");		
//		webDriver.findElement(By.id("mobile_number")).sendKeys("james");
//		
//		webDriver.findElement(By.id("Signup")).click();
//		
//		assertEquals(actualUrl, expectedUrl);
//		
//		System.out.println("title: "+ webDriver.getTitle());
//		
//	}
//	
	
	@Test
	void testForLoginInvalid() {
		webDriver.navigate().to("http://localhost:8090/rest_review/Login.jsp");
		String actualUrl="http://localhost:8090/rest_review/Login.jsp";
		String expectedUrl= webDriver.getCurrentUrl();
		
		
		webDriver.findElement(By.id("username")).sendKeys("pearl");
		webDriver.findElement(By.id("password")).sendKeys("123829");
		webDriver.findElement(By.id("Sign in")).click();
	
		assertEquals(actualUrl, expectedUrl);


		System.out.println("title: "+ webDriver.getTitle());
	}

	
	@AfterEach
	void tearDown() throws Exception {
		webDriver.close();
	}

}
