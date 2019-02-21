package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.TruongPhongDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Service
public class TruongPhongServiceImpl implements TruongPhongService {

	@Autowired
	TruongPhongDAO dao;

	public void setDao(TruongPhongDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public DanhGiaBanThan getNhanVienTuDanhGia(int id) {
		return dao.getNhanVienTuDanhGia(id);
	}

	@Override
	@Transactional
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(String phongBan) {
		return dao.getListNhanVienPhongBan(phongBan);
	}

	@Override
	@Transactional
	public void insertDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		dao.insertDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public TruongPhongDanhGia getDanhGiaNhanVien(int id) {
		return dao.getDanhGiaNhanVien(id);
	}

	@Override
	@Transactional
	public void createListNhanVienPhongBan(List<TruongPhongDanhGia> danhGia) {
		dao.createListNhanVienPhongBan(danhGia);
	}

	@Override
	@Transactional
	public void updateNhanVienTuDanhGia(DanhGiaBanThan danhGia) {
		dao.updateNhanVienTuDanhGia(danhGia);
	}

	@Override
	@Transactional
	public List<DanhGiaBanThan> getListDanhGiaBanThan(String phongBan) {
		return dao.getListDanhGiaBanThan(phongBan);
	}

	@Override
	@Transactional
	public List<HoSoNhanVien> getNhanVienPhongBan(String phongBan) {
		return dao.getNhanVienPhongBan(phongBan);
	}

	@Override
	public LichDanhGia getActiveLichDanhGia(String phongBan) {
		// TODO Auto-generated method stub
		return null;
	}

}
