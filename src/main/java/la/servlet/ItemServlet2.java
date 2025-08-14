package la.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO2;

/**
 * Servlet implementation class ItemServlet2
 */
@WebServlet("/ItemServlet2")
public class ItemServlet2 extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータの解析
			String action = request.getParameter("action");
			// モデルの DAO を生成
			ItemDAO2 dao = new ItemDAO2();
			// パラメータなしの場合は全レコード表示
			if (action == null || action.length() == 0) {
			List<ItemBean> list = dao.findAll();
			// list をリクエストスコープに入れて JSP へフォワードする request.setAttribute("items", list);
			gotoPage(request, response, "/showItem2.jsp");
			} else if (action.equals("add")) {
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price")); 
			dao.addItem(name, price);
			// 追加後、全レコード表示
			List<ItemBean> list = dao.findAll(); 
			request.setAttribute("items", list);
			gotoPage(request, response, "/showItem2.jsp");
			} else if (action.equals("sort")) {
				String key = request.getParameter("key"); 
				List<ItemBean> list;
				if (key.equals("price_asc")) {
				list=dao.sortPrice(true);
				} else {
				list=dao.sortPrice(false);
				}
				request.setAttribute("items", list); 
				gotoPage(request, response, "/showItem2.jsp");
			} else if (action.equals("search")) {
				int price = Integer.parseInt(request.getParameter("price")); 
				List<ItemBean> list = dao.findByPrice(price); 
				request.setAttribute("items", list);
				gotoPage(request, response, "/showItem2.jsp");
			} else if (action.equals("delete")) {
				int code = Integer.parseInt(request.getParameter("code")); dao.deleteByPrimaryKey(code);
				// 削除後、全レコード表示
				List<ItemBean> list = dao.findAll(); request.setAttribute("items", list);
				gotoPage(request, response, "/showItem2.jsp");
			}else {
				// どのアクションにも該当しない場合 
				request.setAttribute("message", "正しく操作してください。"); 
				gotoPage(request, response, "/errInternal.jsp");
			}
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。"); 
			    gotoPage(request, response, "/errInternal.jsp");
			} catch (NumberFormatException e) {
			// 数値変換エラーの場合
				e.printStackTrace();
				request.setAttribute("message", "不正な入力値です。数値を入力してください。");
				gotoPage(request, response, "/errInternal.jsp"); 
			} 
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response,
			String page) throws ServletException, IOException { 
		RequestDispatcher rd = request.getRequestDispatcher(page);
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
