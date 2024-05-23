package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/RegistrationProcess")
public class RegistrationProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationProcess() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out=response.getOutputStream();
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		String password=request.getParameter("password");
		String phonenumber=request.getParameter("pnumber");
		String email=request.getParameter("email");
		
		
		
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			conn.setAutoCommit(false);
			PreparedStatement pp=conn.prepareStatement("insert into user(fname,lname,address,city,state,zip,password,phone,email) values(?,?,?,?,?,?,?,?,?)");
		
			pp.setString(1,fname);
			pp.setString(2, lname);
			pp.setString(3,address);
			pp.setString(4, city);
			pp.setString(5, state);
			pp.setString(6, zip);
			pp.setString(7, password);
			pp.setString(8, phonenumber);
			pp.setString(9, email);
			int x=pp.executeUpdate();
			
			if(x==1){
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
