package qlnv.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import qlnv.model.DBConnection;

public class HoSoNhanVien extends JPanel {
	private static final long serialVersionUID = 1L;
	static DBConnection dBConnection = new DBConnection();
	@SuppressWarnings("static-access")
	static Connection conn = dBConnection.ketNoi("localhost", "quan_ly_tien_dien", "root", "");
	@SuppressWarnings("unused")
	private JTextField txtTimKiem,txtMaNhanVien, txtTenNhanVien, txtNamSinh, txtSDT, txtNgayVao, txtCapBac;
	private JButton btnSearch1,butThem,butSua,butXoa;
	//tạo các colum cho bảng thông qua Object
	private DefaultTableModel model = new DefaultTableModel(new Object[] {"Mã Nhân Viên", "Tên Nhân Viên",
			"Năm Sinh", "Số điện thoại", "Bậc lương", "Ngày vào" }, 0);
	private JComboBox<Object> cbBxQuan;
	final JTable table = new JTable(model);
	// add bảng vào JScrollPane
	JScrollPane sc = new JScrollPane(table);
	
	public HoSoNhanVien() throws HeadlessException, SQLException {
		addControls();
	}
	
	public void addControls() throws SQLException{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border);
		this.setBorder(borderTitle);
		
		JPanel pnmain = new JPanel();
		pnmain.setLayout(new BoxLayout(pnmain, BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Quản lý nhân viên");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		
		JPanel pnTimKiem = new JPanel();
		
		JLabel lbTiemKiem = new JLabel("Tên nhân viên");
		txtTimKiem = new JTextField(15);
		pnTimKiem.add(lbTiemKiem);
		pnTimKiem.add(txtTimKiem);
		
		btnSearch1 = new JButton("Tìm kiếm");
		btnSearch1.setPreferredSize(new Dimension(90,20));
		pnTimKiem.add(btnSearch1);

		
		JPanel chucNang = new JPanel();
		butThem = new JButton("Thêm");
		butThem.setPreferredSize(new Dimension(140,50));
		ImageIcon insert = new ImageIcon(
				new ImageIcon("icons/insert.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconInsert = new JLabel(insert);
	    butThem.add(lblIconInsert);
		butSua = new JButton("Sửa");
		butSua.setPreferredSize(new Dimension(140,50));
		ImageIcon update = new ImageIcon(
				new ImageIcon("icons/t.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate = new JLabel(update);
		butSua.add(lblIconUpdate);
		butXoa = new JButton("Xóa");
		butXoa.setPreferredSize(new Dimension(140,50));
		ImageIcon delete = new ImageIcon(
				new ImageIcon("icons/delete.png").getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH));
		JLabel lblIconDelete= new JLabel(delete);
		butXoa.add(lblIconDelete);
		
		chucNang.add(butThem);
		chucNang.add(butSua); 
		chucNang.add(butXoa);
		
		JScrollPane jsContent = new JScrollPane(table);

		JPanel jsContentpanel = new JPanel();
		jsContentpanel.setLayout(new BoxLayout(jsContentpanel, BoxLayout.X_AXIS));
		
		JPanel jsContentpanelleft = new JPanel();
		jsContentpanelleft.setLayout(new BoxLayout(jsContentpanelleft, BoxLayout.Y_AXIS));
		
		JPanel pnMaNhanVien = new JPanel();
		JLabel lbMaNhanVien = new JLabel("Mã Nhân Niên");
		lbMaNhanVien.setPreferredSize(new Dimension(90, 15));
		txtMaNhanVien = new JTextField(15);
		pnMaNhanVien.add(lbMaNhanVien);
		pnMaNhanVien.add(txtMaNhanVien);
		
		JPanel pnTenNhanVien = new JPanel();
		JLabel lbTenNhanVien = new JLabel("Tên Nhân Niên");
		lbTenNhanVien.setPreferredSize(new Dimension(90, 15));
		txtMaNhanVien = new JTextField(15);
		pnTenNhanVien.add(lbTenNhanVien);
		pnTenNhanVien.add(txtMaNhanVien);
		
		JPanel pnCounty = new JPanel();
		JLabel county = new JLabel("Quê Quán");
		county.setPreferredSize(new Dimension(90, 20));
		cbBxQuan = new JComboBox<Object>();
		cbBxQuan.setPreferredSize(new Dimension(170, 20));
		pnCounty.add(county);
		pnCounty.add(cbBxQuan);
		
		jsContentpanelleft.add(pnMaNhanVien);
		jsContentpanelleft.add(pnTenNhanVien);
		jsContentpanelleft.add(pnCounty);
		
		JPanel jsContentpanelrigh = new JPanel();
		jsContentpanelrigh.setLayout(new BoxLayout(jsContentpanelrigh, BoxLayout.Y_AXIS));
		
		JPanel pnNgayVao = new JPanel();
		JLabel lbNgayVao = new JLabel("Ngày Vào");
		lbNgayVao.setPreferredSize(new Dimension(90, 15));
		txtNgayVao = new JTextField(15);
		txtNgayVao.setEditable(false);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		txtNgayVao.setText(dateFormat.format(date));
		pnNgayVao.add(lbNgayVao);
		pnNgayVao.add(txtNgayVao);
		
		JPanel pnSoDienThoai = new JPanel();
		JLabel lbSoDienThoai = new JLabel();
		lbSoDienThoai.setPreferredSize(new Dimension(90, 15));
		txtSDT = new JTextField(15);
		pnSoDienThoai.add(lbSoDienThoai);
		pnSoDienThoai.add(txtSDT);
		
		JPanel pnCapBac = new JPanel();
		JLabel lbCapBac = new JLabel();
		txtCapBac = new JTextField("Cấp Bậc");
		pnCapBac.add(lbCapBac);
		pnCapBac.add(txtCapBac);
		
		jsContentpanelrigh.add(pnNgayVao);
		jsContentpanelrigh.add(pnSoDienThoai);
		jsContentpanelrigh.add(pnCapBac);
		
		jsContentpanel.add(jsContentpanelleft);
		jsContentpanel.add(jsContentpanelrigh);
		
		pnmain.add(pnTimKiem);
		pnmain.add(jsContent);
		pnmain.add(jsContentpanel);
	}
	
}
