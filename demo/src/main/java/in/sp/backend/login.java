package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class login extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String myemail= request.getParameter("email");
		String mypassword=request.getParameter("password");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Sanket@123");
			 
			 PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=?");
			 ps.setString(1, myemail);
			 ps.setString(2, mypassword);
			 
			ResultSet rs= ps.executeQuery();
			 
			 if(rs.next()) {
				 HttpSession session=request.getSession();
				 session.setAttribute("Session_name",rs.getString("name"));
				 RequestDispatcher rd=request.getRequestDispatcher("/profile.jsp");
				 rd.include(request, response);
			 }
			 else {
				 response.setContentType("text/html");
				 out.print("<h3 style='color:red'>Email id and password didn't matched </h3>");
				 RequestDispatcher rd =request.getRequestDispatcher("/login.jsp");
				 rd.include(request,response);
			 }
		}
		catch (Exception e){
			response.setContentType("text/html");
			 out.print("<h3 style='color:red'>"+e.getMessage()+ "</h3>"); 
			 RequestDispatcher rd =request.getRequestDispatcher("/login.jsp");
			 rd.include(request,response);
			e.printStackTrace();
			
		}
	}
}

