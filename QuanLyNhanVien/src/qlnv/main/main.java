package qlnv.main;

import java.sql.Connection;

import qlnv.model.DBConnection;
import qlnv.ui.DanhMuc;
import qlnv.ui.Login;

public class main {
		public static void main(String[] args) {
			Login login = new Login("QUẢN LÝ NHÂN VIÊN");
			login.showWindow();
			Connection conn = DBConnection.ketNoi("localhost", "quanlynhanvien", "root", "");
			if(conn != null) {
				System.out.println("Kết nối Mysql thành công");
			} else {
				System.out.println("Kết nối MySql thất bại");
			}
		}
}
