package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddtoCart2
 */
@WebServlet("/AddtoCart2")
public class AddtoCart2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCart2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		out.println("we are heere");
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println(email);
		if(email==null)
		{
			request.getRequestDispatcher("Ulogin.jsp").forward(request, response);

		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			
			PreparedStatement psi=conn.prepareStatement("select name,image,price,productId from cart where email = ? ");
		    psi.setString(1,email);
			ResultSet rs = psi.executeQuery();
			out.println("Its addto cart.jsp page");
			if(!email.equals(null))
			{
				out.println("Session not Destroyed "+email);
			}
			else
			{
				out.println("Session is Set ");
			}
			ArrayList<Cart> al = new ArrayList<Cart>();
			
			while(rs.next() && !email.equals(null))
			{
				
				 
					Cart c = new Cart();
					
					c.setEmail(email);
					c.setImage(rs.getString("image"));
					c.setName(rs.getString("name"));
					c.setPrice(rs.getInt("price"));
					//System.out.println(c.getImage());
					c.setProductId(rs.getInt("productId"));
					
					al.add(c);
					out.println(" this works very fine ");
					
														
			}
			
			
				conn.close();
				request.setAttribute("dat", al);
				request.getRequestDispatcher("AddtoCartjsp.jsp").forward(request, response);
	
			conn.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
