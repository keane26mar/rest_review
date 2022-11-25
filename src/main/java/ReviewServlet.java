
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

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3307/reviews";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String SELECT_ALL_REVIEW = "select * from reviewdetails ";
	private static final String SELECT_REVIEW_BY_ID = "select userId, restaurantId, rating, title, review from reviewdetails where reviewId = ?";
	private static final String INSERT_REVIEW_SQL = "INSERT INTO reviewdetails"
			+ " (userId, restaurantId, rating, title, review, reviewId) VALUES " + " (?, ?, ?, ?, ?, ?);";
	private static final String DELETE_REVIEW_SQL = "delete from reviewdetails where reviewId = ?;";
	private static final String UPDATE_REVIEW_SQL = "update reviewdetails set userId = ?, restaurantId = ?, rating = ?, title = ?, review = ?, reviewId = ? where reviewId = ?;";

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
		String action = request.getServletPath();
		try {
			listReviews(request, response);

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

}
