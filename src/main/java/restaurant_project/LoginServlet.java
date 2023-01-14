package restaurant_project;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;

import org.w3c.dom.NameList;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//work on doPost method
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//accept username and password from Login.jsp file
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/restinfo", "root", "password");
			//get data from login table using query
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select * from userdetails where username='"+username+"' and password='"+password+"' "
					);
//			ResultSet validation = 
			if(username == "" || password == "") {
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('please fill in all the empty blanks');");
				   out.println("location='Login.jsp';");
				   out.println("</script>");
				
			}else if(rs.next()) {
				//if username and password true, go to index.jsp file 
				response.sendRedirect("RestServlet/dashboard");
			}else {
				//if username and password false
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('username or password is incorrect');");
				   out.println("location='Login.jsp';");
				   out.println("</script>");
			}
			con.close();
		}catch(Exception exception){
			System.out.println(exception);
			out.close();
		}
		doGet(request, response);
	}

}