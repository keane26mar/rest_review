

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewAddServlet
 */
@WebServlet("/ReviewAddServlet")
public class ReviewAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); //Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter(); //Step 2: retrieve the four parameters from the request from the web form
		int n = Integer.parseInt(request.getParameter("userId"));
		int p = Integer.parseInt(request.getParameter("restaurantId"));
		int e = Integer.parseInt(request.getParameter("rating"));
		String c = request.getParameter("title");
		String b = request.getParameter("review");
		int a = Integer.parseInt(request.getParameter("reviewId"));

		//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3307/reviews", "root", "password");
		//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
		PreparedStatement ps = con.prepareStatement("insert into reviewdetails values(?,?,?,?,?,?)");
		//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
		ps.setInt(1, n);
		ps.setInt(2, p);
		ps.setInt(3, e);
		ps.setString(4, c);
		ps.setString(5, b);
		ps.setInt(6, a);
		
		
		
		//Step 6: perform the query on the database using the prepared statement
		int i = ps.executeUpdate(); //Step 7: check if the query had been successfully execute, return “You are successfully registered” via the response,
		if (i > 0){
		PrintWriter writer = response.getWriter();
		writer.println("<h1>" + "You have successfully added a review!" + "</h1>");
		writer.close();
		}
		} //Step 8: catch and print out any exception
		catch (Exception exception) {
		System.out.println(exception);
		out.close();
		}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
