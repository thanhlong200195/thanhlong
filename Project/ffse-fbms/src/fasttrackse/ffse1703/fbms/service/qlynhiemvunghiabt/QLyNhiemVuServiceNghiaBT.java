package fasttrackse.ffse1703.fbms.service.qlynhiemvunghiabt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.NhiemVu;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.DuAnNghiaBT;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.LoaiCongViecNghiaBT;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.TrangThaiNghiaBT;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;




 public interface QLyNhiemVuServiceNghiaBT {
 	public List<NhiemVu> findAll();

 	public void addNew(NhiemVu cv);

 	public void update(NhiemVu cv);

 	public void delete(NhiemVu cv);

 	public NhiemVu findByID(int ID);
	
 	public List<NhiemVu> findAll(int iDisplayStart, int iDisplayLength, String sql);
 	
 	public List<TrangThaiNghiaBT> trangThai();
 	
 	public List<LoaiCongViecNghiaBT> loaiCongViec();
 	
 	public List<DuAnNghiaBT> duAn();
 	
 	public List<HoSoNhanVien> nhanVien();
// 	public String getRecordsTotal();
//	
// 	public String getRecordsFiltered(String sql);
//	
 	//public List<NhiemVu> findAllForPaging(int startPosition, int maxResult);
 }

	
 