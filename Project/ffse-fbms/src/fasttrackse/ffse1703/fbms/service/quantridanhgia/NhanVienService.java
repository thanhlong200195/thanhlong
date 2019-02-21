package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;

public interface NhanVienService {
	public DanhGiaBanThan getDanhGiaBanThan(int id);

	public void insertDanhGiaBanThan(DanhGiaBanThan danhgia);

	public void updateDanhGiaBanThan(DanhGiaBanThan danhgia);

	public void deleteDanhGiaBanThan(DanhGiaBanThan danhgia);

	public List<DanhGiaNhanVien> getListDanhGiaNhanVien(int id);

	public void insertDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public DanhGiaNhanVien getDanhGiaNhanVien(int id);

	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public List<DanhGiaNhanVien> getListNhanVienDanhGia(int maNhanVien);
	
	public DanhGiaNhanVien getNhanVienDanhGia(int id);
	
	public TruongPhongDanhGia getDanhGiaCuaTruongPhong(int maNhanVien);
}
