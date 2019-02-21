package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.PhongNhanSuDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Service
public class PhongNhanSuServiceImpl implements PhongNhanSuService {

	@Autowired
	public PhongNhanSuDAO dao;

	public void setDao(PhongNhanSuDAO dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<KyDanhGia> getListKyDanhGia() {
		return this.dao.getListKyDanhGia();
	}

	@Transactional
	@Override
	public List<KyDanhGia> getListKyDanhGia(int start, int maxItems) {
		return this.dao.getListKyDanhGia(start, maxItems);
	}

	@Transactional
	@Override
	public void insertKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.insertKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public void updateKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.updateKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public KyDanhGia getKyDanhGia(int maKy) {
		return this.dao.getKyDanhGia(maKy);
	}

	@Transactional
	@Override
	public void deleteKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.deleteKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public List<HoSoNhanVien> getNhanVienPhongBan(String phongBan) {
		return this.dao.getNhanVienPhongBan(phongBan);
	}

	@Transactional
	@Override
	public List<LichDanhGia> getListLichDanhGia(int start, int maxItems) {
		return this.dao.getListLichDanhGia(start, maxItems);
	}

	@Transactional
	@Override
	public int checkLichDanhGia(LichDanhGia lichDanhGia) {
		return this.dao.checkLichDanhGia(lichDanhGia);
	}

	@Transactional
	@Override
	public void insertLichDanhGia(LichDanhGia lichDanhGia) {
		this.dao.insertLichDanhGia(lichDanhGia);
	}

	@Transactional
	@Override
	public LichDanhGia getLichDanhGia(int id) {
		return this.dao.getLichDanhGia(id);
	}

	@Transactional
	@Override
	public void activeLichDanhGia(LichDanhGia lichDanhGia) {
		this.dao.activeLichDanhGia(lichDanhGia);
	}

	@Transactional
	@Override
	public void createPhanCongDanhGia(List<DanhGiaNhanVien> pc) {
		this.dao.createPhanCongDanhGia(pc);
	}

	@Transactional
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan(int start, int maxItems) {
		return this.dao.getListDanhGiaBanThan(start, maxItems);
	}

	@Transactional
	@Override
	public int checkActiveLichDanhGia(String phongBan) {
		return this.dao.checkActiveLichDanhGia(phongBan);
	}

	@Transactional
	@Override
	public int checkCompleteLichDanhGia(String phongBan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan() {
		return dao.getListDanhGiaBanThan();
	}

	@Transactional
	@Override
	public List<LichDanhGia> getListLichDanhGia() {
		return dao.getListLichDanhGia();
	}

	@Override
	@Transactional
	public int countNhanVienPhongBan(String phongBan) {
		return dao.countDanhGiaPhongBan(phongBan);
	}

	@Override
	@Transactional
	public int countDanhGiaPhongBan(String phongBan) {
		return dao.countDanhGiaPhongBan(phongBan);
	}

	@Transactional
	@Override
	public void createDanhGiaBanThan(List<DanhGiaBanThan> danhGia) {
		dao.createDanhGiaBanThan(danhGia);
	}

}
