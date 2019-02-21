package fasttrackse.ffse1703.fbms.service.qlvn2;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.qlvn2.DonXinPhepDao;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.SoNgayNghiEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Service
@Transactional
public class DonXinPhepServicelmpl implements DonXinPhepService {
	@Autowired 
	DonXinPhepDao DonXinPhepDao;
	

	public void setDonXinPhepDao(DonXinPhepDao donXinPhepDao) {
		DonXinPhepDao = donXinPhepDao;
	}

	public List<DonXinPhepEntity> danhsachnhap003() {
		return this.DonXinPhepDao.danhsachnhap003();
	}

	
	public List<DonXinPhepEntity> danhsachchoduyet003() {
		return this.DonXinPhepDao.danhsachchoduyet003();
	}


	public List<DonXinPhepEntity> danhsachdaduyet003() {
		return this.DonXinPhepDao.danhsachdaduyet003();
	}

	
	public List<DonXinPhepEntity> danhsachbituchoi003() {
		return this.DonXinPhepDao.danhsachbituchoi003();
		}

	
	public List<LyDoEntity> danhSachLyDo() {
		return this.DonXinPhepDao.danhSachLyDo();
	}

	
	public List<TrangThaiEntity> danhSachTrangThai() {
		return this.DonXinPhepDao.danhSachTrangThai();
	}

	
	public List<HoSoNhanVien> danhSachHoSo() {
	return this.DonXinPhepDao.danhSachHoSo();
	}

	
	public void create(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.create(DonXinPhepEntity);
		
	}
	
	public void createcho(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.createcho(DonXinPhepEntity);
		
	}

	
	public void createduyet(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.createduyet(DonXinPhepEntity);
		
	}

	
	public void createtuchoi(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.createtuchoi(DonXinPhepEntity);
		
	}

	
	public DonXinPhepEntity findById(int id) {
		return this.DonXinPhepDao.findById(id);
	}

	public void delete(int id) {
	DonXinPhepDao.delete(id);
		
	}

	public void updatecho(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.Updatecho(DonXinPhepEntity);
		
	}
	
	public List<DonXinPhepEntity> findAllForPaging1(int startPosition, int maxResult) {
		return this.DonXinPhepDao.findAllForPaging1(startPosition, maxResult);
	}
	
	public List<DonXinPhepEntity> findAllForPaging2(int startPosition, int maxResult) {
		return this.DonXinPhepDao.findAllForPaging2(startPosition, maxResult);
	}
	public List<DonXinPhepEntity> findAllForPaging3(int startPosition, int maxResult) {
		return this.DonXinPhepDao.findAllForPaging3(startPosition, maxResult);
	}
	public List<DonXinPhepEntity> findAllForPaging4(int startPosition, int maxResult) {
		return this.DonXinPhepDao.findAllForPaging4(startPosition, maxResult);
	}


	public List<SoNgayNghiEntity> bangNgayNghi() {
		return this.DonXinPhepDao.bangNgayNghi();
	}


	public SoNgayNghiEntity findByIdngay(int id) {
		return this.DonXinPhepDao.findByIdngay(id);
	}

	public void deletengay(int id) {
		DonXinPhepDao.delete(id);
		
	}

	@Override
	public List<DonXinPhepEntity> findAllForPagingngaynghi(int startPosition, int maxResult) {
		
		return null;
	}
	
	

	


}
