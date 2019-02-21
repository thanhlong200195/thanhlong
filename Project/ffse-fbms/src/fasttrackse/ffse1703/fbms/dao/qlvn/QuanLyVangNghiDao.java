package fasttrackse.ffse1703.fbms.dao.qlvn;

import java.util.List;

import org.hibernate.Session;

import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.NgayNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThaiVN;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

public interface QuanLyVangNghiDao {
	public List<ThongKeDonXinPhep> danhSachXinNghiChoDuyet(String maPB);

	public List<ThongKeDonXinPhep> danhSachXinNghiDuyet();
	
	public List<ThongKeDonXinPhep> danhSachXinNghiTuChoi();
	
	public void create(ThongKeDonXinPhep thongKeDonXinPhep);
	
	public void createWait(ThongKeDonXinPhep thongKeDonXinPhep);
	
	public void createBrowse(ThongKeDonXinPhep thongKeDonXinPhep);
	
	public void createfeedback(ThongKeDonXinPhep thongKeDonXinPhep);
	
	public int KiemTraNgayNghi(ThongKeDonXinPhep maNhanVien);
	
	public List<LyDoXinNghi> loadAllLyDo();
	
	public List<HoSoNhanVien> loadAllHoSo();
	
	public List<HoSoNhanVien> loadAllHoSoWhere(String isTPP);
	
	public ThongKeDonXinPhep findById(int id);
	
	public void delete(int id);
	
	public List<ThongKeDonXinPhep> danhSachXinNghiNhap(String maPB);
	
	public List<ThongKeDonXinPhep> findAllForPaging(int startPosition, int maxResult,String maPB);
	
	public List<ThongKeDonXinPhep> findAllForPagingCD(int startPosition, int maxResult,String search, String maPB);
	
	public List<ThongKeDonXinPhep> findAllForPagingD(int startPosition, int maxResult, String search);
	
	public List<ThongKeDonXinPhep> findAllForPagingTC(int startPosition, int maxResult);
	
	public List<NgayNghi> findAllForPagingNN(int startPosition, int maxResult, String search);
	
	public List<PhongBan> loadAllPhongBanWhere(String isTPP);
	
	public List<PhongBan> loadAllPhongBan();
	
	public long totalRecords();
	
	public void updateNhap(ThongKeDonXinPhep thongKeDonXinPhep) ;
	
    public List<NgayNghi> danhSachNgayNghi();
	
	public NgayNghi findByIdDateOff(int id);
	
	public void deleteDateOff(int id); 
	
	public List<TrangThaiVN> danhSachTrangThai();
	
	public List<TrangThaiVN> findAllForPagingTrangThai(int startPosition, int maxResult);
	
	public TrangThaiVN findByIdTrangThai(int id);
	
	public void createTrangThai(TrangThaiVN trangThai);
	
	public void deleteTrangThai(int id);
	
	public void updateTrangThai(TrangThaiVN trangThai);
	
    public void createNgayNghi(NgayNghi ngayNghi);
	
	public void updateNgayNghi(NgayNghi ngayNghi);
	
	public List<ThongKeDonXinPhep> listbyPhongBan(String maPB );

}
