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
 * Servlet implementation class ItemDAO2
 */
public class ItemDAO2{
	private String url = "jdbc:postgresql:sample";
	private String user = "postgres";
	private String pass = "postgres";
	
	public ItemDAO2() throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました");
		}
	}
	
	// 全件取得
	
	public List<ItemBean> findAll() throws DAOException{
		String sql = "SELECT * FROM item";
		try (
			Connection con = DriverManager.getConnection(url,user, pass);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
		){
			List<ItemBean> list = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(id, name, price);
				list.add(bean);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new DAOException("全件取得に失敗しました");
		}	
	}
	
	// 価格昇順/降順ソート
	public List<ItemBean> sortPrice(boolean ascending) throws DAOException {
		String sql = "SELECT * FROM item ORDER BY price " + (ascending ? "ASC" : "DESC");
		try (
			Connection con = DriverManager.getConnection(url, user, pass); 
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			){
			List<ItemBean> list = new ArrayList<>(); 
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(id, name, price); 
				list.add(bean);
			}
			return list;	
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new DAOException("ソートに失敗しました。");
		}
	}
		
		// 価格以下検索
		public List<ItemBean> findByPrice(int price) throws DAOException {
			String sql = "SELECT * FROM item WHERE price <= ?"; 
			try (
					Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement st = con.prepareStatement(sql); 
			){
				st.setInt(1, price);
				try (ResultSet rs = st.executeQuery()) {
				List<ItemBean> list = new ArrayList<>(); 
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int p = rs.getInt("price");
					ItemBean bean = new ItemBean(id, name, p); 
					list.add(bean);
			     }return list;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new DAOException("価格検索に失敗しました。");
		}
	 }
		
		// 商品追加
		public void addItem(String name, int price) throws DAOException {
		String sql = "INSERT INTO item(category_id, name, price) VALUES(1, ?, ?)"; 
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql); 
			){
			st.setString(1, name); 
			st.setInt(2, price); 
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("商品の追加に失敗しました。");
		} 
	}
		
		// 商品削除
		public void deleteByPrimaryKey(int code) throws DAOException {
			String sql = "DELETE FROM item WHERE id = ?"; try (
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement(sql); ){
			        st.setInt(1, code);
			st.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("商品の削除に失敗しました。");
			}
		}
	
		

}