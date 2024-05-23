package com;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class RemoveItem_Process
 */
@WebServlet("/RemoveItem_Process")
public class RemoveItem_Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItem_Process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String data =(String) request.getParameter("Id");
		int Data = Integer.parseInt(data);
		System.out.println("--------------------------"+Data+"-----------------------");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			conn.setAutoCommit(false);
			PreparedStatement ph=conn.prepareStatement("delete from cart where productId=?");
		    ph.setInt(1,Data);
		    ph.executeUpdate();
			conn.commit();
			conn.close();
			out.println("Successfully Delete the item");
			
		     request.getRequestDispatcher("AddtoCart2").include(request, response);  
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
