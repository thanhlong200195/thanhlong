package qlnv.ui;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class DanhMuc extends JFrame {
	private JComboBox<String> comboHeThong,comboQuanLy,comboTimKiem,comboThongKe,comboTroGiup;
	@SuppressWarnings("rawtypes")
	public DanhMuc(String arg0) throws HeadlessException {
		super(arg0);
		try {
			addControls();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@SuppressWarnings("unchecked")
	public void addControls() throws SQLException{
		Container con = getContentPane();
		JPanel pnContent = new JPanel();
		pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));
		JPanel pnContentMenu = new JPanel();
		pnContentMenu.setLayout(new BoxLayout(pnContentMenu, BoxLayout.X_AXIS));
		 
		JPanel pnContentUn = new JPanel();
		pnContentUn.setLayout(new BorderLayout());
		JPanel pnContentUnder = new JPanel();
		pnContentUn.add(pnContentUnder, BorderLayout.CENTER);
		ImageIcon img=new ImageIcon("icons/cay.jpg");
		JLabel lbContentUnder = new JLabel(img);
		pnContentUnder.add(lbContentUnder);
		pnContentUn.add(pnContentUnder);
		
        JPanel panComboHeThong = new JPanel();
        panComboHeThong.setPreferredSize(new Dimension(100,40));
		String comboBoxItems[] = { "Hệ Thống", "Đăng Xuất", "Thoát"};
		comboHeThong = new JComboBox(comboBoxItems);
		panComboHeThong.add(comboHeThong);
		
		JPanel panComboQuanLy = new JPanel();
		panComboQuanLy.setPreferredSize(new Dimension(100,40));
		String comboboxQuanLy[] = { "Quản Lý", "Thông Tin Nhân Viên", "Chấm Công"};
		comboQuanLy = new JComboBox(comboboxQuanLy);
		panComboQuanLy.add(comboQuanLy);
		
		JPanel panTimKiem = new JPanel();
		panTimKiem.setPreferredSize(new Dimension(100,40));
		String comboboxTimKiem[] = {"Tìm Kiếm", "Khách Hàng"};
		comboTimKiem = new JComboBox(comboboxTimKiem);
		panTimKiem.add(comboTimKiem);
		
		JPanel panThongKe = new JPanel();
		panThongKe.setPreferredSize(new Dimension(100,40));
		String comboboxThongKe[] = {"Thống Kê","Theo Tháng", "Theo Qúi", "Theo Năm"};
		comboThongKe = new JComboBox(comboboxThongKe);
		panThongKe.add(comboThongKe);
		
		JPanel panTroGiup = new JPanel();
		panTroGiup.setPreferredSize(new Dimension(100,40));
		String comboboxTroGiup[] = {"Trợ Giúp", "Máy Tính"};
		comboTroGiup = new JComboBox(comboboxTroGiup);
		panTroGiup.add(comboTroGiup);
		
		pnContentMenu.add(panComboHeThong);
		pnContentMenu.add(panComboQuanLy);
		pnContentMenu.add(panTimKiem);
		pnContentMenu.add(panThongKe);
		pnContentMenu.add(panTroGiup);
		pnContent.add(pnContentMenu);
		pnContent.add(pnContentUn);
		con.add(pnContent);
	
		
	}
	
	
	public void showWindow() {
		this.setSize(750, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	protected HoSoNhanVien HoSoNhanVien() {
		// TODO Auto-generated method stub
		return null;
	}
}
