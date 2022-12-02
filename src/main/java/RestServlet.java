


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.awt.event.ActionEvent;


import restaurant_project.Rest;


/**
 * Servlet implementation class RestServlet
 */
@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3307/restinfo";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	private static final String SELECT_ALL_RESTS = "select * from rest_details ";
	private static final String SELECT_REST_BY_ID = "select image, description, address, contact, website, title from rest_details where restId = ?";
	private static final String SELECT_REST_TITLE = "select * from rest_details where title = ? ";
	
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
    public RestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		String action = request.getServletPath();
		try {
		switch (action) {
		case "/RestServlet/getById":
			getRestById(request,response);
			break;
		case "/RestServlet/dashboard":
		case "/RestServlet":
			listRests(request,response);
			break;
		default:
		listRests(request, response);
		break;
		}
		} catch (SQLException ex) {
		throw new ServletException(ex);
		} 

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listRests(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
			List <Rest> rests = new ArrayList <>();
			try (Connection connection = getConnection();
			// Step 5.1: Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESTS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
			int restId = rs.getInt("restId");
			String image = rs.getString("image");
			String description = rs.getString("description");
			String address = rs.getString("address");
			int contact = rs.getInt("contact");
			String website = rs.getString("website");
			String title = rs.getString("title");
			System.out.println(restId);

			rests.add(new Rest(restId, image, description, address, contact, website, title));
			}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			request.setAttribute("listRests", rests);
			request.getRequestDispatcher("/restManagement.jsp").forward(request, response);
	}

	private void getRestById(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
		int restId = Integer.parseInt(request.getParameter("restId"));
		
		int phone = Integer.parseInt(request.getParameter("contact"));

		Rest existingRest = new Rest(restId, "image", "description", "address", phone, "website", "title");

		
			try (Connection connection = getConnection();
			// Step 5.1: Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REST_BY_ID);) {
			// Step 5.2: Execute the query or update query
			preparedStatement.setInt(1, restId);
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
			restId = rs.getInt("restId");
			String image = rs.getString("image");
			String description = rs.getString("description");
			String address = rs.getString("address");
			int contact = rs.getInt("contact");
			String website = rs.getString("website");
			String title = rs.getString("title");
			
			existingRest = new Rest(restId, image, description, address, contact, website, title);

			}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			request.setAttribute("rest", existingRest);
			request.getRequestDispatcher("/restDetails.jsp").forward(request, response);
	}
	

}
