package ffse1703004.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class thùngrác {
	private void addEvents() {
//		butThem.addActionListener(eventThem);
//		butSua.addActionListener(eventSua);
//		butXoa.addActionListener(eventXoa);
//	}
//	
//	
//	ActionListener eventThem = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	};
//	
//	ActionListener eventSua = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	};
//	
//	ActionListener eventXoa = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
		
		
//		private void quan() {
//		try {
//			ComboItem item;
//			cb1.addItem(null);
//           	ResultSet rs = connection.getQuan();
//           	while((rs != null) && (rs.next())) {
//           		item = new ComboItem(rs.getString("id"), rs.getString("tenquan"));
//           		cb1.addItem(item);
//           	}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void sellectAll() {
//		arr.clear();
//		try {
//			Statement statement=conn.createStatement();
//			ResultSet result=statement.executeQuery("select * from KhachHang");
//			while(result.next())
//			{
//				String tenKhachHang = result.getString("tenkh");
//				String diaChi = result.getString("diachi");
//				String soDienThoai = result.getString("dienthoai");
//				String email = result.getString("email");
//				String maCongTo = result.getString("mact");
//				String quan = result.getString("quan");
//				String phuong = result.getString("phuong");
//				String maKhachHang =result.getString("makh");
//				arr.add(new KhachHangMD(tenKhachHang,diaChi,soDienThoai,email,maCongTo,quan,phuong,maKhachHang));
//			}
//			} catch (Exception e) {
//			e.printStackTrace();
//			}
//	}
	};
	
//	String sql = "select * from KhachHang";
//	PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
//		ptmt.setString(1, txtMaKH.getText());
//		ptmt.setString(2, txtMCT.getText());
//		ptmt.setString(3, txtTenKH.getText());
//		ptmt.setString(4, txtDiaChi.getText());
//		ptmt.setString(5, cbBxQuan1.getSelectedItem().toString());
//		ptmt.setString(6, cbBxPhuong1.getSelectedItem().toString());
//		ptmt.setString(7, txtSDT.getText());
//		ptmt.setString(8, txtEmail.getText());
//		int t = tab.getSelectedRow();
//			String[] row = {  txtMaKH.getText(), txtMCT.getText(), txtTenKH.getText(),txtDiaChi.getText(),
//					cbBxQuan1.getSelectedItem().toString(),cbBxPhuong1.getSelectedItem().toString(),
//					txtSDT.getText(),txtEmail.getText() };
//			for (int j = 0; j < 8; j++) {
//				tab.setValueAt(row[j], t, j);
//			}
//			int k = ptmt.executeUpdate();
//			if (k != 0) {
//			JOptionPane.showMessageDialog(null, "Sửa thành công");
//			txtMaKH.setText("");
//			txtMCT.setText("");
//			txtTenKH.setText("");
//			txtDiaChi.setText("");
//			cbBxQuan1.setSelectedItem("");
//			cbBxPhuong1.setSelectedItem("");
//			txtSDT.setText("");
//			txtEmail.setText("");
//			}else {
//				JOptionPane.showMessageDialog(null, "Sửa không thành công");
//			}
	
//	
//    public void nhap(){
//		try {
//		String tenkh = txtTenKH.getText();
//		String makh = txtMaKH.getText();
//		String diachi = txtDiaChi.getText();
//		String dienthoai = txtSDT.getText();
//		String email = txtEmail.getText();
//		String mact = txtMCT.getText();
//		String idquan = cbBxQuan.getSelectedItem().toString();
//		String idphuong= cbBxPhuong.getSelectedItem().toString();
//		 int kt = 0;
//		 for(int i = 0; i < arr.size(); i++) {
//				if(txtMaKH.getText().equals(arr.get(i).getMaKhachHang())) {
//					kt = 1;
//				}
//		 }
//				if(kt == 1) {
//					JOptionPane.showMessageDialog(null, "Trùng mã khách hàng");
//				}
//				if ( makh.isEmpty() ||mact.isEmpty()||tenkh.isEmpty() ||  diachi.isEmpty()|| idphuong.isEmpty()|| idquan.isEmpty()|| dienthoai.isEmpty()|| email.isEmpty()) {
//					throw new Exception();
//				} else if ( kt > 0) {
//					String msg = "Khách hàng " + arr.get(kt).getMaKhachHang() + " đã tồn tạ !!";
//					JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
//				} else {
//						DBConnection.insertKhachHang(makh,mact,tenkh,diachi,idphuong,idquan,dienthoai,email);
//						String[] row = {txtMaKH.getText(),txtMCT.getText(),txtTenKH.getText(),txtDiaChi.getText()
//								,cbBxQuan.getSelectedItem().toString(),cbBxPhuong.getSelectedItem().toString(),txtSDT.getText(),txtEmail.getText()
//						};
//								dm.addRow(row);
//						
//							JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
//							txtMCT.setText("");
//							txtTenKH.setText("");
//							txtMaKH.setText("");
//							txtDiaChi.setText("");
//							txtEmail.setText("");
//							txtSDT.setText("");
//							cbBxQuan.getSelectedItem().toString();
//							cbBxPhuong.getSelectedItem().toString();
//						
//					
//				
//		}	
//		}catch(Exception ex) {}
//}
//ActionListener eventThem = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//			try {
//				nhap();
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//	};
	
//	Sửa
//	{
//		if(conn != null){
//				String sql = "UPDATE `KhachHang` SET `tenkh`=?,`diachi`=?,`idquan`=? ,`idphuong`=?,`dienthoai`=?,`email`=?  WHERE `makh` = ?";
//				try {
//					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
//					ptmt.setString(1, txtMaKH.getText());
//					ptmt.setString(2, txtMCT.getText());
//					ptmt.setString(3, txtTenKH.getText());
//					ptmt.setString(4, txtDiaChi.getText());
//					ptmt.setString(5, cbBxPhuong1.getSelectedItem().toString());
//					ptmt.setString(6, cbBxQuan1.getSelectedItem().toString());
//					ptmt.setString(7, txtSDT.getText());
//					ptmt.setString(8, txtEmail.getText());
//
//					int t = tab.getSelectedRow();
//					String[] row = {  txtMaKH.getText(), txtMCT.getText(), txtTenKH.getText(),txtDiaChi.getText(),
//							cbBxQuan1.getSelectedItem().toString(),cbBxPhuong1.getSelectedItem().toString(),
//							txtSDT.getText(),txtEmail.getText() };
//					for (int j = 0; j < 8; j++) {
//						tab.setValueAt(row[j], t, j);
//					}
//					dm.addRow(row);
//					int k = ptmt.executeUpdate();
//					if (k != 0) {
//						JOptionPane.showMessageDialog(null, "Sửa thành công");
//						txtMaKH.setText("");
//						txtMCT.setText("");
//						txtTenKH.setText("");
//						txtDiaChi.setText("");
//						cbBxPhuong1.setSelectedItem("");
//						cbBxQuan1.setSelectedItem("");
//						txtSDT.setText("");
//						txtEmail.setText("");
//					} else
//						JOptionPane.showMessageDialog(null, "Sửa không thành công");
//				} catch (SQLException e1) {
//					System.out.println("Lỗi  " + e1.getMessage());
//
//				}
//			} else {
//				System.out.println("Kết nối MYSQL thất bại");
//			}
//		}	
		//
//	pn7.add(lblMonth);
//	pn7.add(cbBxmonth);
//	pn7.add(cbBxyear);
//	String month[] = {"Tháng 1","Tháng 2","Tháng 3","Tháng 4","Tháng 5","Tháng 6","Tháng 7","Tháng 8","Tháng 9","Tháng 10","Tháng 11","Tháng 12"};
//	cbBxmonth = new JComboBox(month);
//	cbBxmonth.setPreferredSize(new Dimension(90, 20));
//	String year[] = {"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
//	cbBxyear = new JComboBox(year);
//	cbBxyear.setPreferredSize(new Dimension(90, 20));
//	int month = (int) cbBxmonth.getSelectedIndex() + 1;
//	String year =   (String) cbBxyear.getSelectedItem();
//	void getDataToTextField(int row) {
//	txtMeterID.setEditable(false);
//	txtMeterID.setText((String) table.getValueAt(row, 1));
//	txtMeterIndex.setText((String) table.getValueAt(row, 3));
//	cbBxmonth.setSelectedItem(table.getValueAt(row, 4));
//	cbBxyear.setSelectedItem(table.getValueAt(row, 4));
//	txtDateAdded.setText((String) table.getValueAt(row, 2));
//	}
	
//	 ListSelectionListener eventDataToTextField = new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				int row = table.getSelectedRow();
//				if (row != -1 && !e.getValueIsAdjusting()) {
//					getDataToTextField(row);
//				}
//			}
//		};
			
//	int month = (int) cbBxmonth.getSelectedIndex() + 1;
//	String year =   (String) cbBxyear.getSelectedItem();
//	Locale locale = new Locale("vi" ,"VN");
//	NumberFormat formatter =  DecimalFormat.getCurrencyInstance(locale);
//	formatter.setRoundingMode(RoundingMode.HALF_UP);
//	formatter.format(meterNumber);
	JTabbedPane tablePane1 = new JTabbedPane();
//	JPanel pan1 = new JPanel();
//	pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));
//
//	JPanel pnKH = new JPanel();
//
//	JLabel lblSearch = new JLabel("Tên khách hàng");
//	txtSearch = new JTextField(15);
//	pnKH.add(lblSearch);
//	pnKH.add(txtSearch);
//
//	JLabel lblCounty1 = new JLabel("Quận");
//	String County[] = {};
//	cbBxQuan1 = new JComboBox(County);
//	cbBxQuan1.setPreferredSize(new Dimension(115, 20));
//	pnKH.add(lblCounty1);
//	pnKH.add(cbBxQuan1);
//
//	JLabel lblWard1 = new JLabel("Phường");
//	String Ward[] = {};
//	cbBxPhuong1 = new JComboBox(Ward);
//	cbBxPhuong1.setPreferredSize(new Dimension(115, 20));
//	pnKH.add(lblWard1);
//	pnKH.add(cbBxPhuong1);
//
//	JPanel pnRB = new JPanel();
//	String comboBoxItems[] = { "Theo năm", "Theo khoảng thời gian", "Theo kì" };
//	JComboBox cb = new JComboBox(comboBoxItems);
//	pnRB.add(cb);
//
//	 JPanel pnSL = new JPanel();
//	JPanel pnYear = new JPanel();
//	jycPn1 = new JYearChooser();
//	btnSearch2 = new JButton("Tìm kiếm");
//	pnYear.add(jycPn1);
//	pnYear.add(btnSearch2);
//	JPanel pnInterval = new JPanel();
//	jmcStart = new JMonthChooser();
//	jycStart = new JYearChooser();
//	jmcEnd = new JMonthChooser();
//	jycEnd = new JYearChooser();
//	JLabel lblStart = new JLabel("Bắt đầu");
//	JLabel lblEnd = new JLabel("Kết thúc");
//	JButton btnSearch3 = new JButton("Tìm kiếm");
//	pnInterval.add(lblStart);
//	pnInterval.add(jmcStart);
//	pnInterval.add(jycStart);
//	pnInterval.add(lblEnd);
//	pnInterval.add(jmcEnd);
//	pnInterval.add(jycEnd);
//	pnInterval.add(btnSearch3);
//	JPanel pnTerm = new JPanel();
//	jmcPn3 = new JMonthChooser();
//	jycPn3 = new JYearChooser();
//	JButton btnSearch4 = new JButton("Tìm kiếm");
//	pnTerm.add(jmcPn3);
//	pnTerm.add(jycPn3);
//	pnTerm.add(btnSearch4);
//	pnSL.add(pnYear, "0");
//	pnSL.add(pnInterval, "1");
//	pnSL.add(pnTerm, "2");
//	pan1.add(pnKH);
//	pan1.add(pnRB);
//	JScrollPane pnTable1 = new JScrollPane(table);
//	Border bor1 = BorderFactory.createLineBorder(Color.RED);
//	TitledBorder bortitle1 = BorderFactory.createTitledBorder(bor, "Danh sách");
//	pnTable1.setBorder(bortitle1);
//	pan1.add(pnTable1);
//	tablePane1.add(pan1, "Báo Cáo Tình Hình Tiêu Thụ Điện");
	
	// thống kê khách hàng

//	
//	ActionListener eventQuan = new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			cbBxPhuong.removeAllItems();
//			cbBxPhuong.addItem("Chọn phường");
//			int idquan = cbBxQuan.getSelectedIndex()  ;
//			try {
//				addComboBoxWard(ffse1703004.model.DBConnection.getPhuong(idquan), cbBxPhuong);
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			}
//	};
//

//
//	void addComboBoxWard(ResultSet wardList, JComboBox cb) throws SQLException {
//		while (wardList.next()) {
//			cb.addItem(wardList.getObject("tenphuong"));
//		}
//	}
//	
//	
//	
//
//	ActionListener eventTimKiem = new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			timKiem();
//		}
//	};
//
//	public void timKiem() {
//		if (conn != null) {
//			String sql = "SELECT * FROM KhachHang WHERE makh LIKE '%" + txtTimKiem.getText() + "%' or tenkh LIKE '"+ txtTimKiem.getText() +"'";
//			try {
//				if(txtTimKiem.getText().isEmpty()) {
//					Display();
//				} else {
//				PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
//				// khởi tạo resultset
//
//				ResultSet rs = ptmt.executeQuery();
//				model.setRowCount(0);
//				// mdTableSach.getDataVector().removeAllElements();
//				while (rs.next()) {
//					String rows[] = new String[8];
//
//					rows[0] = rs.getString(2);
//					rows[1] = rs.getString(3);
//					rows[2] = rs.getString(4);
//					rows[3] = rs.getString(5);
//					rows[4] = rs.getString(6);
//					rows[5] = rs.getString(7);
//					rows[6] = rs.getString(8);
//					rows[7] = rs.getString(9);
//					model.addRow(rows);
//				}}
//			} catch (SQLException e) {
//				System.out.println("Lỗi " + e.getMessage());
//			}
//		} else {
//			System.out.println("Kết nối MYSQL thất bại");
//		}
//	}
//		ActionListener eventTimKiemQuan = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				timKiemQuan();
//			}
//		};
//		
//		public void timKiemQuan() {
//			if (conn != null) {
//				String sql = "SELECT * FROM KhachHang WHERE idquan = '" + cbBxQuan.getSelectedItem().toString()
//						+ "' AND idphuong = '" +  cbBxPhuong.getSelectedItem().toString() +"'";
//				String sql1 = "SELECT * FROM KhachHang WHERE idquan = '"+ cbBxQuan.getSelectedItem().toString() +"'";
//				try {
//					if(cbBxPhuong.getSelectedItem().toString().equals("Chọn phường")) {
//						PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql1);
//						// khởi tạo resultset
//
//						ResultSet rs = ptmt.executeQuery();
//						model.setRowCount(0);
//						// mdTableSach.getDataVector().removeAllElements();
//						while (rs.next()) {
//							String rows[] = new String[8];
//
//							rows[0] = rs.getString(2);
//							rows[1] = rs.getString(3);
//							rows[2] = rs.getString(4);
//							rows[3] = rs.getString(5);
//							rows[4] = rs.getString(6);
//							rows[5] = rs.getString(7);
//							rows[6] = rs.getString(8);
//							rows[7] = rs.getString(9);
//							model.addRow(rows);
//						}
//					} else {
//					
//					PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
//					// khởi tạo resultset
//
//					ResultSet rs = ptmt.executeQuery();
//					model.setRowCount(0);
//					// mdTableSach.getDataVector().removeAllElements();
//					while (rs.next()) {
//						String rows[] = new String[8];
//
//						rows[0] = rs.getString(2);
//						rows[1] = rs.getString(3);
//						rows[2] = rs.getString(4);
//						rows[3] = rs.getString(5);
//						rows[4] = rs.getString(6);
//						rows[5] = rs.getString(7);
//						rows[6] = rs.getString(8);
//						rows[7] = rs.getString(9);
//						model.addRow(rows);
//					}
//					}
//				    }catch (SQLException e) {
//					System.out.println("Lỗi " + e.getMessage());
//				}
//			}  else {
//				System.out.println("Kết nối MYSQL thất bại");
//			}
//		}
//
//	public void Display() {
//	if (conn != null) {
//
//		String sql = "SELECT BienLai.id, KhachHang.mact,KhachHang.tenkh, KhachHang.diachi, Phuong.tenphuong, Quan.tenquan,"
//				+ " KhachHang.dienthoai, KhachHang.email, BienLai.chuki,BienLai.thanhtien,KhachHang.idphuong,KhachHang.idquan "
//				+ "FROM (((KhachHang INNER JOIN Quan on KhachHang.idquan = Quan.tenquan)"
//				+ "INNER JOIN Phuong ON KhachHang.idphuong = Phuong.tenphuong)"
//				+ " INNER JOIN BienLai ON KhachHang.mact = BienLai.mact) where id ";
//		try {
//			PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
//			// khởi tạo resultset
//			model.setRowCount(0);
//			ResultSet rs = ptmt.executeQuery();
//			while (rs.next()) {
//				
//				String rows[] = new String[11];
//
//				rows[0] = rs.getString(1);
//				rows[1] = rs.getString(2);
//				rows[2] = rs.getString(3);
//				rows[3] = rs.getString(4);
//				rows[4] = rs.getString(5);
//				rows[5] = rs.getString(6);
//				rows[6] = rs.getString(7);
//				rows[7] = rs.getString(8);
//				rows[8] = rs.getString(9);
//				rows[9] = rs.getString(10);
////				rows[10] = rs.getString(11);
//				model.addRow(rows);
//				
//			}
//		} catch (SQLException e) {
//			System.out.println("Lỗi" + e.getMessage());
//
//		}
//	} else {
//		System.out.println("Kết nối MYSQL thất bại");
//	}
//}

}


