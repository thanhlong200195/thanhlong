package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;

public interface QuanLyHopDongDaoTT {
	
	public String getRecordsTotal(String maPhongBan);

	public String getRecordsFiltered(String sql);

	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql);

	public List<HopDongTT> getAllHopDong();

	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan);

	public void addHopDong(HopDongTT tt);

	public void updateHopDong(HopDongTT tt);
	
	public void removeHopDong(HopDongTT tt);

	public String getAutoId();
	
	public HopDongTT findByMaHopDong(int maHopDong);
	
	public List<HoSoNhanVienTT> getAllNhanVien();
	
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien);
		
	public List<HopDongTT> viewOne(int maNhanVien);
	
	int checkloaiHopDong(String loaiHopDong, int maNhanVien);
	
}
