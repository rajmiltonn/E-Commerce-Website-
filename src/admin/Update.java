package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Adminlogin_process
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("id");
		int Id=Integer.parseInt(email);
		ArrayList<String>str1=new ArrayList<String>();
		HttpSession session = request.getSession(true); 
		response.setContentType("text/html"); 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			conn.setAutoCommit(false);
			PreparedStatement pp=conn.prepareStatement("select * from product where productId=?");
			pp.setInt(1,Id);
			ResultSet x=pp.executeQuery();
			//str1.add(email);
            if(x.next()){
            	for(int i=1;i<=11;i++){
            		str1.add(x.getString(i));
            	}
         
            	request.setAttribute("str1", str1);

            	//String destination="/FirstJSP.jsp"; //If authentication fails///////////
            	RequestDispatcher rd = getServletContext().getRequestDispatcher("/update_product.jsp");
            	rd.forward(request, response);
            }
			conn.commit();
			conn.close();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	
		
	}

}
