package restaurant_project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Review_JUnit {
	
	private Review_collection reviewC;
	private Review review1;
	private Review review2;
	private Review review3;
	private int reviewID;
	
	private final int REVIEW_COLLECTION_SIZE = 3;

	@BeforeEach
	void setUp() throws Exception {
		reviewC = new Review_collection();	
		reviewID = (11);
		review1 = new Review(1, 2, 4, "qwe", "qweqwe", 1);
		review2 = new Review(1, 5, 3, "aaaa", "aaa", 11);
		review3 = new Review(1, 5, 2, "qwrwer", "qwetqweg", 4);
		reviewC.addReview(review1);
		reviewC.addReview(review2);
		reviewC.addReview(review3);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReview_collection() {
		fail("Not yet implemented");
	}

	@Test
	void testGetReview() {
		List<Review> testreviewC = reviewC.getReviews();
//		fail("Not yet implemented");
		assertEquals(testreviewC.size(), REVIEW_COLLECTION_SIZE);
	}

	@Test
	void testAddReview() {
		assertEquals(reviewC.getReviews().size(), REVIEW_COLLECTION_SIZE);
		reviewC.addReview(review1);
		assertEquals(reviewC.getReviews().size(), REVIEW_COLLECTION_SIZE+1);
	}
	
	@Test
	void testDeleteReview() {
		assertEquals(reviewC.getReviews().size(), REVIEW_COLLECTION_SIZE);
		reviewC.deleteReview(review1);
		assertEquals(reviewC.getReviews().size(), REVIEW_COLLECTION_SIZE-1);
	}
	
	@Test
	void testUpdateReview() {
		assertEquals(reviewC.getReviews().size(), REVIEW_COLLECTION_SIZE);
		reviewC.updateReview(1 ,review1);
		assertEquals(reviewC.getReviews().size(), REVIEW_COLLECTION_SIZE);
		assertEquals(reviewC.findReviewByIndex(1), review1);
	}

	@Test
	void testFindReviewByReviewId() {
		Review testReviewC = reviewC.findReviewByReviewID(reviewID);
		
		testReviewC = new Review(1, 2, 4, "qwe", "qweqwe", 1);
		testReviewC = new Review(1, 5, 3, "aaaa", "aaa", 11);
		
		assertEquals(reviewID, testReviewC.reviewId);
	}

}
