package restaurant_project;

	import static org.junit.jupiter.api.Assertions.*;

	import java.util.Collections;
	import java.util.List;

	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;


public class RestaurantTest {



	    private RestDetails rs;
	    private Rest rest;
	    private Rest rest1;
	    private Rest rest2;
	    private String title;
	    private String Category;
	    private final int rest_collection_size = 3;

		@BeforeEach
		void setUp() throws Exception {
			rs = new RestDetails();
			title = new String ("Title 2");
			rest = new Rest(1, "image", "test", "test", 1, "test", "Candlenut","Italian");
			rest1 = new Rest(3, "image1", "test1", "test", 1, "test", "Blue Kozina","Western");
			rest2 = new Rest(5, "image2", "test2", "test", 1, "test", "Italian Osteria","Italian");
			rs.addRest(rest);
			rs.addRest(rest1);
			rs.addRest(rest2);
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		
		@Test
	    void testaddRests() {
	        List<Rest> testRs = rs.getRests();
	        assertEquals(testRs.size(), rest_collection_size);

	        rs.addRest(rest);
	        assertEquals(testRs.size(), rest_collection_size+1);
	    }
		
		@Test
	    void testGetRestById() {
	    Rest testRs = rs.findRestById(2);

	    testRs = new Rest(1, "image1.jpg", "Description1", "Address1", 1234567890, "www.example1.com", "Title1","Italian");
	    testRs = new Rest(2, "image2.jpg", "Description2", "Address2", 1234567891, "www.example2.com", "Title2","Western");
	    assertEquals(2, testRs.restId);
	    }
		
		
		@Test
		void testGetRestByCategory() {
			rs.addRest(rest);
			rs.addRest(rest1);
			
			List<Rest> testRs = rs.findRestByCategory("Italian");
			assertEquals(3, testRs.size());
			assertEquals(rest, testRs.get(0));
		}



		
		@Test
		void testSortTitleByDesc() {
		    rs.addRest(rest);
		    rs.addRest(rest1);

		    List<Rest> testRs = rs.getRests();
		    Collections.sort(testRs, new TitleComparator());

		    assertEquals("Italian Osteria", testRs.get(0).getTitle());
		    assertEquals("Candlenut", testRs.get(1).getTitle());
		}

	

}