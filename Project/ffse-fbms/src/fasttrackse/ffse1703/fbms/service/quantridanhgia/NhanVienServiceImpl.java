package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.NhanVienDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;

@Service
public class NhanVienServiceImpl implements NhanVienService {

	@Autowired
	NhanVienDAO dao;

	public void setDao(NhanVienDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public DanhGiaBanThan getDanhGiaBanThan(int maNhanVien) {
		return dao.getDanhGiaBanThan(maNhanVien);
	}

	@Override
	@Transactional
	public void insertDanhGiaBanThan(DanhGiaBanThan danhgia) {
		dao.insertDanhGiaBanThan(danhgia);

	}

	@Override
	@Transactional
	public void updateDanhGiaBanThan(DanhGiaBanThan danhgia) {
		dao.updateDanhGiaBanThan(danhgia);
	}

	@Override
	@Transactional
	public void deleteDanhGiaBanThan(DanhGiaBanThan danhgia) {
		dao.deleteDanhGiaBanThan(danhgia);
	}

	@Override
	@Transactional
	public List<DanhGiaNhanVien> getListDanhGiaNhanVien(int maNhanVien) {
		return dao.getListPhanCongDanhGia(maNhanVien);
	}

	@Override
	@Transactional
	public void insertDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		dao.insertDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public DanhGiaNhanVien getDanhGiaNhanVien(int id) {
		return dao.getDanhGiaNhanVien(id);
	}

	@Override
	@Transactional
	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		dao.updateDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		dao.deleteDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public TruongPhongDanhGia getDanhGiaCuaTruongPhong(int maNhanVien) {
		return dao.getDanhGiaCuaTruongPhong(maNhanVien);
	}

	@Transactional
	@Override
	public List<DanhGiaNhanVien> getListNhanVienDanhGia(int maNhanVien) {
		return dao.getListNhanVienDanhGia(maNhanVien);
	}

	@Transactional
	@Override
	public DanhGiaNhanVien getNhanVienDanhGia(int id) {
		return dao.getNhanVienDanhGia(id);
	}

}
