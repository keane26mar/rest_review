package restaurant_project;
public class Review {
        protected int userId;
        protected int restaurantId;
        protected int rating;
        protected String title;
        protected String review;
        protected int reviewId;

	public Review(int userId, int restaurantId, int rating, String title, String review, int reviewId) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.rating = rating;
		this.title = title;
		this.review = review;
		this.reviewId = reviewId;
		
	}
	
	public void setUserId() {
		this.userId = userId;
	}
	public void setRestaurantId() {
		this.restaurantId = restaurantId;
	}
	public void setRating() {
		this.rating = rating;
	}
	public void setTitle() {
		this.title = title;
	}
	public void setReview() {
		this.review = review;
	}
	public void setReviewId() {
		this.reviewId = reviewId;
	}
	
	
	
	
	
	
	public int getUserId() {
		return userId;
	}	
	public int getRestaurantId() {
		return restaurantId;
	}
		
	public int getRating() {
		return rating;
	}
		
	public String getTitle() {
		return title;
	}
		
	public String getReview() {
		return review;
	}
		
	public int getReviewId() {
		return reviewId;
	}
}