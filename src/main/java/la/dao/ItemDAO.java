package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ItemBean;

/**
 * Servlet implementation class ItemDAO
 */
public class ItemDAO{
	private String url="jdbc:postgresql:sample";
	private String user="postgres";
	private String pass="postgres";
	
	public ItemDAO() throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			throw new DAOException("ドライバの取得に失敗しました");
		}
	}
	
	public List<ItemBean>findAll() throws DAOException{
		String sql = "SELECT * FROM item";
		
		try(Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();){
			List<ItemBean> list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(id, name, price);
				list.add(bean);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}
	}
}