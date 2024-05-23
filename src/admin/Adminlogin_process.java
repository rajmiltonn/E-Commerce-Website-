package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Adminlogin_process
 */
@WebServlet("/Adminlogin_process")
public class Adminlogin_process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Adminlogin_process() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			conn.setAutoCommit(false);
			PreparedStatement pp=conn.prepareStatement("select email password from admin where email=? and password=?");
		
			pp.setString(1,email);
			pp.setString(2,password);
			ResultSet x=pp.executeQuery();
			if(x.next()){
				HttpSession s = request.getSession();
				s.setAttribute("email",email);
				request.getRequestDispatcher("DisplayProduct.jsp").forward(request, response);
			}
			else{
				request.setAttribute("name", "value");
				request.getRequestDispatcher("/Adminlogin.jsp").forward(request, response);
			}
			
			conn.commit();
			conn.close();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	
		
	}

}
