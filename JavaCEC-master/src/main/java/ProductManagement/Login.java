package ProductManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String em = request.getParameter("email");
		String ps = request.getParameter("pass");
		out.print(em);
		out.print(ps);
		HttpSession session = request.getSession(true);
		ArrayList<ProductDetails> products = new ArrayList<ProductDetails>();
//		ProductDetails pd= new ProductDetails();
//		products.add(pd);
		session.setAttribute("products", products);
		
		if(em.equals("jaymin9037@gmail.com") && ps.equals("12345")) {
			response.sendRedirect("HomePage.jsp");
		}
		else{
			out.print("Invallid UserName or Password");
			response.sendRedirect("UserHomePage.jsp");
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
