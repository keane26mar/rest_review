package restaurant_project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RestTest {
	
	private rest_collection rs;
	private Rest r1;
	private Rest r2;
	private Rest r3;
	private String resttitle;
	
	private final int REST_COLLECTION_SIZE = 3;
	
	@BeforeEach
	void setUp() throws Exception {
		rs = new rest_collection();
		resttitle = new String ("Title2");
		r1 = new Rest(1, "image1.jpg", "Description1", "Pasir Ris", 12345678, "www.example.com", "Candlenut");
		r2 = new Rest(3, "image2.jpg", "Description2", "hello", 1, "hello", "Blue kozina");
		r3 = new Rest(5, "image3.jpg", "Description3", "hello", 1, "hello", "Italain Osteria");
		rs.addRest(r1);
		rs.addRest(r2);
		rs.addRest(r3);
//		rests.add(new Rest(restId, image, description, address, contact, website, title)); 
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetRests() {
		List<Rest> testRs = rs.getRests();
		assertEquals(testRs.size(), REST_COLLECTION_SIZE);
	}
	
	@Test
	@DisplayName("testing for getters and setters")
    public void testSettersGetters() {
        r1.setImage();
        r1.setRestId();
        r1.setRestId();
        r1.setImage();
        r1.setDescription();
        r1.setAddress();
        r1.setContact();
        r1.setWebsite();
        r1.setTitle();
        assertEquals(1, r1.getRestId());
        assertEquals("image1.jpg", r1.getImage());
        assertEquals("Description1", r1.getDescription());
        assertEquals("Pasir Ris", r1.getAddress());
        assertEquals(12345678, r1.getContact());
        assertEquals("www.example.com", r1.getWebsite());
        assertEquals("Candlenut", r1.getTitle());
    }
	
	@Test
	void testGetRestTitle() {	
	List<Rest> testRs = rs.findRestByTitle("CandleNut");
	
	assertEquals(0, testRs.size());
	}
	
	 @Test
	    public void testFindRestByTitle_NotFound() {
		 
		 List<Rest> testRs = rs.findRestNotFound("CandleNut");	
		 assertEquals(null, testRs);	 
	    }
	
	@Test
	void testSortRestTitle() {
		ArrayList<Rest> sortedRests = rs.sortRestsByTitle();
								
		assertEquals(sortedRests.get(1), r1);
		assertEquals(sortedRests.get(0), r2);
		assertEquals(sortedRests.get(2), r3);
	}
}