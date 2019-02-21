package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface PhongNhanSuDAO {

	public List<KyDanhGia> getListKyDanhGia();
	
	public List<KyDanhGia> getListKyDanhGia(int start, int maxItems);

	public void insertKyDanhGia(KyDanhGia kyDanhGia);

	public void updateKyDanhGia(KyDanhGia kyDanhGia);

	public KyDanhGia getKyDanhGia(int maKy);

	public void deleteKyDanhGia(KyDanhGia kyDanhGia);

	public List<HoSoNhanVien> getNhanVienPhongBan(String phongBan);

	public List<LichDanhGia> getListLichDanhGia(int start, int maxItems);

	public int checkLichDanhGia(LichDanhGia lichDanhGia);

	public void insertLichDanhGia(LichDanhGia lichDanhGia);

	public LichDanhGia getLichDanhGia(int id);
	
	public int checkActiveLichDanhGia(String phongBan);

	public int countNhanVienPhongBan(String phongBan);
	
	public int countDanhGiaPhongBan(String phongBan);
	
	public int checkCompleteLichDanhGia(String phongBan);
	
	public void activeLichDanhGia(LichDanhGia lichDanhGia);

	public void createPhanCongDanhGia(List<DanhGiaNhanVien> pc);

	public void createDanhGiaBanThan(List<DanhGiaBanThan> danhGia);
	
	public List<DanhGiaBanThan> getListDanhGiaBanThan();
	
	public List<DanhGiaBanThan> getListDanhGiaBanThan(int start, int maxItems);

	public List<LichDanhGia> getListLichDanhGia();

}
