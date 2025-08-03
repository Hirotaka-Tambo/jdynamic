package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet2
 */
@WebServlet("/AddToCartServlet2")
public class AddToCartServlet2 extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute("isLoggedIn") == null 
				|| !(Boolean.TRUE.equals(session.getAttribute("isLoggedIn")))) {
			out.println("<h2>ログインしていません。</h2>");
			return;
		}
		
		String itemId = request.getParameter("itemId");
		
		@SuppressWarnings("unchecked")
		List<String> cart = (List<String>) session.getAttribute("shoppingCart");
		if(cart == null) {
			cart = new ArrayList<>();
		}
		
		cart.add("商品ID:"+ itemId);
		session.setAttribute("shoppingCart", cart);
		
		out.println("<h2>カートに追加しました!</h2>");
		out.println("<a href=\"/jdynamic/shopItems.html\">商品一覧に戻る</a>");
	}

}
