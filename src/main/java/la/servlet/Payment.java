package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String payment = request.getParameter("payment");
		String[] options = request.getParameterValues("option");
		
		out.println("<html><body>");
		out.println("<h2>支払い方法:" + (payment != null ? payment:"未選択") + "</h2>");
		
		if(options != null) {
			out.println("<h3>オプション:</h3>");
			for(String opt:options) {
				out.println("<p>"+ opt + "</p>");
			}
		}else {
			out.println("<p>オプションは選択されませんでした。</p>");
				
			}
		out.println("</body></html>");
		
	}
}
