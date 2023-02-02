
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restaurant_project.Rest;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet/*")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3307/restinfo";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String SELECT_ALL_REVIEW = "select * from reviewdetails ";
	private static final String SELECT_REVIEW_BY_ID = "select userId, restaurantId, rating, title, review from reviewdetails where reviewId = ?";
	private static final String INSERT_REVIEW_SQL = "INSERT INTO reviewdetails"
			+ " (userId, restaurantId, rating, title, review, reviewId) VALUES " + " (?, ?, ?, ?, ?, ?);";
	private static final String DELETE_REVIEW_SQL = "delete from reviewdetails where reviewId = ?;";
	private static final String UPDATE_REVIEW_SQL = "update reviewdetails set userId = ?, restaurantId = ?, rating = ?, title = ?, review = ? where reviewId = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
		try {
			if (action == null) {
				listReviews(request, response);
			}
			else switch (action) {
			case "/getById":
				getReviewById(request,response);
				break;
			case "/delete":
				deleteReview(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateReview(request, response);
				break;
			default:
				listReviews(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listReviews(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("restId"));
		List<Review> reviews = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REVIEW);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int userId = rs.getInt("userId");
				int restaurantId = rs.getInt("restaurantId");
				int rating = rs.getInt("rating");
				String title = rs.getString("title");
				String review = rs.getString("review");
				int reviewId = rs.getInt("reviewId");
				System.out.println(reviewId);

				if (restaurantId == id) {
					reviews.add(new Review(userId, restaurantId, rating, title, review, reviewId));
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listReviews", reviews);
		request.getRequestDispatcher("/review.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		int userId = Integer.parseInt(request.getParameter("userId"));
		int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		Review existingReview = new Review(userId, restaurantId, rating, "title", "review", reviewId);
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_ID);) {
			preparedStatement.setInt(1, reviewId);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				userId = rs.getInt("userId");
				restaurantId = rs.getInt("restaurantId");
				rating = rs.getInt("rating");
				String title = rs.getString("title");
				String review = rs.getString("review");
				reviewId = rs.getInt("reviewId");
				existingReview = new Review(userId, restaurantId, rating, title, review, reviewId);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("review", existingReview);
		request.getRequestDispatcher("/reviewEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateReview(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int userId = Integer.parseInt(request.getParameter("userId"));
		int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		String title = request.getParameter("title");
		String review = request.getParameter("review");
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_REVIEW_SQL);) {
			statement.setInt(1, userId);
			statement.setInt(2, restaurantId);
			statement.setInt(3, rating);
			statement.setString(4, title);
			statement.setString(5, review);
			statement.setInt(6, reviewId);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet (note: remember to change the url to
		// your projectname)
		response.sendRedirect("http://localhost:8090/restaurant_project/ReviewServlet?restId=" + restaurantId);
	}

	// method to delete user
	private void deleteReview(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_REVIEW_SQL);) {
			statement.setInt(1, reviewId);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8080/restaurant_project/ReviewServlet");
	}
	
	private void getReviewById(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
		
		int userId, restaurantId, rating;
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		

		Review existingReview = null;

		
			try (Connection connection = getConnection();
			// Step 5.1: Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_ID);) {
			// Step 5.2: Execute the query or update query
			preparedStatement.setInt(1, reviewId);
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
			userId = rs.getInt("userId");
			restaurantId = rs.getInt("restaurantId");
			rating = rs.getInt("rating");
			String title = rs.getString("title");
			String review = rs.getString("review");
			
			existingReview = new Review(userId, restaurantId, rating, title, review, reviewId);

			}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			request.setAttribute("review", existingReview);
			request.getRequestDispatcher("/reviewEdit.jsp").forward(request, response);
	}

}
