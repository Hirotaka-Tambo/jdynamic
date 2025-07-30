package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectProductServlet
 */
@WebServlet("/SelectProductServlet")
public class SelectProductServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// レスポンスの文字コードを設定 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// リクエストパラメータの読み込み
		// URL に付加された"product_no"パラメータの値を取得します。
		String productNo = request.getParameter("product_no");
		int no = 0; // 商品番号を数値として保持する変数
		String productName = null; // 商品名を保持する変数
		// 入力チェック(数値であるか、null でないか)
		if (productNo == null || productNo.isEmpty()) {
		productName = "商品番号が指定されていません。"; } else {
		try {
		no = Integer.parseInt(productNo); // 文字列を数値に変換 // 選択された商品の判定
		    switch (no) {
		      case 100:
		productName = "パソコン";
		         break;
		      case 101:
		productName = "プリンタ";
		         break;
		      case 102:
		productName = "デジタルカメラ";
		         break;
		      default:
		productName = "不明な商品番号です。"; // 想定外の数値の場合 
		}
		} catch (NumberFormatException e) {
		productName = "商品番号が不正な形式です。"; // 数値に変換できない場合
		} 
		}
		out.println("<html><head><title>SelectProduct</title></head><body>"); 
		out.println("<h1>選択された商品は「" + productName + "」です</h1>"); 
		out.println("</body></html>");
	} 

}
