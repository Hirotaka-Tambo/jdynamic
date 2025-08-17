package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import la.bean.UserProfile;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		if("register".equals(action)) {
			//入力値を取得
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			//JavaBeansに格納
			UserProfile profile = new UserProfile(username, email, phone);
			
			//セッションに保存
			session.setAttribute("userProfile", profile);
			
			out.println("<html><body>");
			out.println("<h2>登録が完了しました。</h2>"); 
			out.println("<a href=\"customerInfo.html\">戻る</a>"); 
			out.println("</body></html>");
		}else if("confirm".equals(action)){
			
			UserProfile profile = (UserProfile) session.getAttribute("userProfile");
			out.println("<html><body>");
			if (profile == null) { out.println("<h2>情報が登録されていません。</h2>");
			} else {
			out.println("<h2>登録済みの情報</h2>");
			out.println("<p>お名前: " + profile.getUsername() + "</p>"); 
			out.println("<p>メールアドレス: " + profile.getEmail() + "</p>"); 
			out.println("<p>電話番号: " + profile.getPhone() + "</p>");
			}
			out.println("<a href=\"customerInfo.html\">戻る</a>");
			out.println("</body></html>");
			} else {
			out.println("<html><body>");
			out.println("<h2>不正なリクエストです。</h2>");
			out.println("</body></html>");
			} 
			
		}
		
	
}
