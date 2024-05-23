package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Userlogin_process
 */
@WebServlet("/Userlogin_process")
public class Userlogin_process extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Userlogin_process() {
        super();

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			conn.setAutoCommit(false);
			PreparedStatement pp=conn.prepareStatement("select fname , email ,  password from user where email=? and password=?");
		
			pp.setString(1,email);
			pp.setString(2,password);
			ResultSet x=pp.executeQuery();
			if(x.next()){
			
				String el= x.getString("fname");
				HttpSession session=request.getSession();
				session.setAttribute("email", email);
				
				session.setAttribute("name",el );
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("name", "value");
				request.getRequestDispatcher("Ulogin.jsp").forward(request, response);
			}

			conn.commit();
			conn.close();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
