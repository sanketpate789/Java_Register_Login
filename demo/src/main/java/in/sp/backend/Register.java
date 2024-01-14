package in.sp.backend;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet({"/submitForm"})
public class Register extends HttpServlet {
    

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Myname = request.getParameter("name");
        String Myemail = request.getParameter("email");
        String Mypassword = request.getParameter("password");
        String Mygender = request.getParameter("gender1");
        String Mycity = request.getParameter("city");
        PrintWriter out = response.getWriter();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Sanket@123");
            PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
            ps.setString(1, Myname);
            ps.setString(2, Myemail);
            ps.setString(3, Mypassword);
            ps.setString(4, Mygender);
            ps.setString(5, Mycity);
            int count = ps.executeUpdate();
            if (count > 0) {
                response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
                out.println("<h2 style='color:green'>you have successfully registered </h2>");
                rd.include(request, response);
            }
            else {
            	response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
                out.println("<h2 style='color:red'>you have  not successfully registered </h2>");
                rd.include(request, response);
            	
            }
        } catch (Exception e) {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
            out.println("<h2 style='color:red'> Exception occured " + e.getMessage() + " </h2>");
            rd.include(request, response);
            e.printStackTrace();
        }

    }
}

