package la.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import la.bean.CustomerBean;

/**
 * Servlet implementation class CustomerRegisterController
 */
@WebServlet("/CustomerRegisterController")
public class CustomerRegisterController extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		CustomerBean customer = new CustomerBean();
		customer.setName(name);
		customer.setAddress(address);
		customer.setTel(tel);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("customerData", customer);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<html><body>");
		response.getWriter().println("<p>登録が完了しました</p>");
		response.getWriter().println("<a href ='customer.html'>戻る</a>");
		response.getWriter().println("</body></html>");
		
		
		
	}

}
