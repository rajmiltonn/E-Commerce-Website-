package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Change_password
 */
@WebServlet("/Change_password")
public class Change_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String current_password=request.getParameter("password");
		String newpassword=request.getParameter("newpassword");
		String confirm_newpassword=request.getParameter("confirm_newpassword");
		//ServletOutputStream out=response.getOutputStream();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			conn.setAutoCommit(false);
			PreparedStatement pp=conn.prepareStatement("select password from admin where password=?");
		
			pp.setString(1,current_password);

			ResultSet x=pp.executeQuery();
			if(x.next()){
				PreparedStatement p=conn.prepareStatement("update admin set password=?");
				p.setString(1, newpassword);
				p.executeUpdate();
				request.setAttribute("name", "value");
				request.getRequestDispatcher("DisplayProduct.jsp").forward(request, response);
				
			}
			else{
				
				request.setAttribute("name", "value");
				request.getRequestDispatcher("change_password.jsp").forward(request, response);
			}
			//out.println(x);
			//PreparedStatement ps1=conn.prepareStatement("insert into technology(Tname,UID) values(?,?)");
			//PreparedStatement ps2=conn.prepareStatement("select UserId from user where UNane=?");
			//ps2.setString(1, name);
			
			//out.println("Registration Successfull");
			conn.commit();
			conn.close();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	
		
	
	
	}

}
