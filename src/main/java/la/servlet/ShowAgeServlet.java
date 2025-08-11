package la.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import la.bean.PersonBean;
import la.business.CalcAge;

/**
 * Servlet implementation class ShowAgeServlet
 */
@WebServlet("/ShowAgeServlet")
public class ShowAgeServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String strYear = request.getParameter("year");
		String strMonth = request.getParameter("month");
		String strDate = request.getParameter("date");
		
		if(strYear == null || strYear.length() == 0
		   || strMonth == null || strMonth.length() == 0
		   || strDate == null || strDate.length() == 0) {
			
			request.setAttribute("message", "生年月日を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}
		
		int year,month,date;
		
		try {
			year = Integer.parseInt(strYear);
			month = Integer.parseInt(strMonth);
			date = Integer.parseInt(strDate);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			request.setAttribute("message", "生年月日は数値として入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}
		
		//モデルを使って年齢を計算
		CalcAge ca = new CalcAge();
		int age = ca.howOld(year,month,date);
		
		// 表示データをJavaBeansにする
		PersonBean p = new PersonBean(name,age);
		
		// JavaBeanをリクエストスコープに入れてjspにフォワードする
		request.setAttribute("person", p);
		RequestDispatcher rd = request.getRequestDispatcher("/showAge.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
