package com;

import java.awt.List;
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
 * Servlet implementation class AddtoCart_Process
 */
@WebServlet("/AddtoCart_Process")
public class AddtoCart_Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCart_Process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		System.out.println("Added to the Cart Successfully------------------------------- !!");
		
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("email");
		out.println(email);
	
		out.println(" We are proud od your ");
		String idd = request.getParameter("Id");
		int productId = Integer.parseInt(idd);
		////////System.out.println("-----------------"+email);
		if(email==null)
		{
			request.getRequestDispatcher("Ulogin.jsp").forward(request, response);
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(" select productName,productimage1,productprice from product where productId = ? ");
		    ps.setInt(1,productId);
			ResultSet rs = ps.executeQuery();
			boolean check = rs.next();
			
			if(check && email!=null) {
					out.println(" value of c is  ok value is :"+check);
					String name = (String) rs.getString("productName");
					int price = (int) rs.getInt("productprice");
					String img =(String) rs.getString("productimage1");
					request.setAttribute("ima",img);
					
					
					/*  out.println("<br>"+name+" "+img);
					out.println(email);
					out.println(productId);
					
					out.println("<br>"+im);
					out.println("<br>"+name);
					out.println(email);
					out.println(productId);
					out.println(price);
					//out.println(img);*/
					ArrayList<String> sent=new ArrayList<String>();
					 
					sent.add(0,email);
					sent.add(1,idd);
					sent.add(2,name);
					
					String pc = Integer.toString(price);
					sent.add(3,pc);
					sent.add(4,img);
					request.setAttribute("data", sent);
					
					ps.close();
					
					
					PreparedStatement pf=conn.prepareStatement("insert into cart values(?,?,?,?,?) ");
					pf.setString(1,email);
					pf.setInt(2,productId);
					pf.setString(3,name);
					pf.setString(4,img);
					pf.setString(5,pc);
				
					int m = pf.executeUpdate();
					conn.commit();
					pf.close();
					conn.close();
					if(m==1) {
						System.out.println("----- Data inserted Successfully--------");
				    request.setAttribute("inform","success");
					request.getRequestDispatcher("AddtoCart.jsp").forward(request, response);
					}
					
				}
			else{
				//request.setAttribute("email", "value");
				request.getRequestDispatcher("Ulogin.jsp").forward(request, response);
				
			}		
			//conn.commit();
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
		
		doGet(request, response);
	}

}
