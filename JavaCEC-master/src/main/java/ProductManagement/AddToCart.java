package ProductManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCart
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/javaCEC", "root", "");
			Statement st = con.createStatement();
			String query = "SELECT * FROM product WHERE id = '"+id+"'";
			ResultSet rs = st.executeQuery(query);
			
			HttpSession ses = request.getSession(false);
			ArrayList<ProductDetails> products = (ArrayList<ProductDetails>) ses.getAttribute("products");
			ProductDetails pd = new ProductDetails();
			
			if(rs.next()) {
				
				pd.setProductID(rs.getInt(1));
				pd.setProductName(rs.getString(2));
				pd.setProductDes(rs.getString(3));
				pd.setProductPrice(rs.getInt(4));
			}			
			products.add(pd);
				
			ses.setAttribute("products", products);
			response.sendRedirect("UserHomePage.jsp");		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
