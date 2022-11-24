

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
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
		String p = request.getParameter("image");
		String e = request.getParameter("description");
		String c = request.getParameter("address");
		int a = Integer.parseInt(request.getParameter("contact"));
		String b = request.getParameter("website");
		String d = request.getParameter("title");

		//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/restinfo", "root", "password");
		//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
		PreparedStatement ps = con.prepareStatement("insert into rest_details values(?,?,?,?,?,?,?)");
		//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
		ps.setInt(1, n);
		ps.setString(2, p);
		ps.setString(3, e);
		ps.setString(4, c);
		ps.setInt(5, a);
		ps.setString(6, b);
		ps.setString(7, d);

		
		
		
		//Step 6: perform the query on the database using the prepared statement
		int i = ps.executeUpdate(); //Step 7: check if the query had been successfully execute, return “You are successfully registered” via the response,
		if (i > 0){
		PrintWriter writer = response.getWriter();
		writer.println("<h1>" + "You have successfully added a restaurant!" + "</h1>");
		writer.close();
		}
		} //Step 8: catch and print out any exception
		catch (Exception exception) {
		System.out.println(exception);
		out.close();
		}
		doGet(request, response);
	}

}
