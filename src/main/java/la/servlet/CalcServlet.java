package la.servlet; 
 
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
 
@WebServlet("/CalcServlet") 
public class CalcServlet extends HttpServlet { 
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException { 
 
        response.setContentType("text/html; charset=UTF-8"); 
        PrintWriter out = response.getWriter(); 
 
        String num1 = request.getParameter("number1"); 
        String num2 = request.getParameter("number2"); 
 
        int result = Integer.parseInt(num1) + Integer.parseInt(num2); 
 
        out.println("<html><body>"); 
        out.println("<h1>計算結果: " + result + "</h1>"); 
        out.println("</body></html>"); 
    }
}