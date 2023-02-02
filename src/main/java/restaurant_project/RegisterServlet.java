package restaurant_project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Step 1: Initialize a PrintWriter object to return the html values via the
		// response
		PrintWriter out = response.getWriter();
		// Step 2: retrieve the four parameters from the request from the web form
		String n = request.getParameter("username");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String c = request.getParameter("mobile_number");


		// Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/restinfo", "root", "password");
			// Step 4: implement the sql query using prepared
			// statement(https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into userdetails(username, password, email, mobile_number) values(?,?,?,?)");
			// Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, c);
//			ps.setString(5, username);
			// Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();
			// Step 7: check if the query had been successfully execute, return “You are successfully registered” via the response,
			if (n == "" ||p == "" ||e == "" ||c == "") {
				request.setAttribute("status", "failed");
				out.println("<script type=\"text/javascript\">");
				out.println("location='Signup.jsp';");
		    	out.println("</script>");
		}else if(i > 0){

			out.println("<script type=\"text/javascript\">");
				out.println("alert('Sign into your account!');");
				response.sendRedirect("Login.jsp");
				out.println("</script>");
			};
		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
		doGet(request, response);
	}
	
}