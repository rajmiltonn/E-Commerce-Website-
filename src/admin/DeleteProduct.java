package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("productId");
		//System.out.println("id "+id);
		int no=Integer.parseInt(id);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			conn.setAutoCommit(false);
			PreparedStatement pp=conn.prepareStatement("delete from product where productId=?");
			pp.setInt(1,no);
		//	System.out.println("id1 "+id);
		int x=pp.executeUpdate();
		//System.out.println(x);
		//System.out.println("id2 "+id);
		conn.commit();
		conn.close();
		
		if(x==1) {
			request.getRequestDispatcher("DisplayProduct.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "D");
			request.getRequestDispatcher("DisplayProduct.jsp").forward(request, response);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	} 
}
