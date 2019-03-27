package qlnv.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class DBConnection {
		//gọi tới phương thức kết nối
		static Connection conn = ketNoi("localhost","quanlynhanvien","root","");

		public static void main(String[] args) {
			if(conn != null) {
				System.out.println("Kết nối MYSQL thành công");
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
			
		}
		
		public static Connection ketNoi(String strServer, String strDatabase,
				String strUser, String strPass) {
			Connection conn = null;
			String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=true&characterEncoding=utf-8";
			Properties pro = new Properties();
			pro.put("username", strUser);
			pro.put("password", strPass);
			try {
				com.mysql.jdbc.Driver driver = new Driver();
				conn = (Connection) driver.connect(strConnect, pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		
		public static boolean checkLogin(String username, String passsword) {
			try {
				String sql = "select * from user where username =? and password = ?";
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
				stm.setString(1, username);
				stm.setString(2, passsword);
				ResultSet result = stm.executeQuery();
				if(!result.next()) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		
		public static boolean checkConnection() {
			if(conn != null) {
				return true;
			} else {
				return false;
			}
		}
		
}

