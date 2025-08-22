package la.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuizJudgeController
 */
@WebServlet("/QuizJudgeController")
public class QuizJudgeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String answer = request.getParameter("answer");
		String result;
		
		if("3776".equals(answer)) {
			result = "正解!富士山の標高は3776mです!!";
		}else {
			result ="不正解,,富士山の標高は3776mです!!";
		}
		
		request.setAttribute("resultMessage", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuizResultDisplayController");
		dispatcher.forward(request, response);
		
		
	}
	
}
