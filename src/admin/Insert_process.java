package admin;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Insert_process
 */
@WebServlet("/Insert_process")
public class Insert_process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_process() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String category=request.getParameter("category");
			String subcategory=request.getParameter("subcategory");
			String productName=request.getParameter("productName");
			String productCompany=request.getParameter("productCompany");
		
			int productpricebd=Integer.parseInt(request.getParameter("productpricebd"));
			
			int productprice=Integer.parseInt(request.getParameter("productprice"));
			String productDescription=request.getParameter("productDescription");
			int productShippingcharge=Integer.parseInt(request.getParameter("productShippingcharge"));
			String productAvailability=request.getParameter("productAvailability");
			String productimage1=request.getParameter("productimage1");
			
			
			//PrintWriter out = response.getWriter();
			System.out.println("I am here ");
			
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/buyme","root","11111");
				conn.setAutoCommit(false);
				PreparedStatement pp=conn.prepareStatement("insert into product(category,subcategory,productName,productCompany,productpricebd,"
						+ "productprice,productDescription,productShippingcharge,productAvailability,productimage1) values(?,?,?,?,?,?,?,?,?,?)");
			
				pp.setString(1,category);
				pp.setString(2, subcategory);
				pp.setString(3,productName);
				pp.setString(4, productCompany);
				pp.setInt(5, productpricebd);
				pp.setInt(6, productprice);
				pp.setString(7, productDescription);
				pp.setInt(8, productShippingcharge);
				pp.setString(9, productAvailability);
				pp.setString(10, productimage1);
				int x=pp.executeUpdate();
				conn.commit();
				conn.close();
			 //System.out.println("I a heere ");
				if(x==1) {
					request.getRequestDispatcher("DisplayProduct.jsp").forward(request, response);
				}
				else {
					request.setAttribute("name", "value");
					request.getRequestDispatcher("insert.jsp").forward(request, response);
				}
				
				
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		
			
		
		}

	

}
