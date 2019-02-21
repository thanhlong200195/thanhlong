package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.HoSoNhanVienPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;


@Service
public class HoSoNhanVienPikalongServiceImpl implements HoSoNhanVienPikalongService {
	@Autowired
	private HoSoNhanVienPikalongDao hoSoNhanVienPikalongDao;
	
	public void setHoSoNhanVienPikalongDao(HoSoNhanVienPikalongDao hoSoNhanVienPikalongDao) {
		this.hoSoNhanVienPikalongDao = hoSoNhanVienPikalongDao;
	}


	@Override
	@Transactional
	public List<HoSoNhanVienPikalong> listNhanVien() {
		
		return hoSoNhanVienPikalongDao.listNhanVien();
	}


	@Override
	@Transactional
	public void delete(String maNv) {
		hoSoNhanVienPikalongDao.delete(maNv);
	}


	@Override
	@Transactional
	public void insert(HoSoNhanVienPikalong hoSoNhanVien) {
		hoSoNhanVienPikalongDao.insert(hoSoNhanVien);
		
	}
	
	@Override
	@Transactional
	public String getId() {
		return this.hoSoNhanVienPikalongDao.getAutoId();
	}
	
	@Override
	@Transactional
	public HoSoNhanVienPikalong getHoSoNhanVienById(String maNv) {
		return this.hoSoNhanVienPikalongDao.getHoSoNhanVienById(maNv);
	}
	@Override
	@Transactional
	public HoSoNhanVienPikalong getEdit(String maNv) {
		
		return hoSoNhanVienPikalongDao.getEdit(maNv);
	}


	@Override
	@Transactional
	public void update(HoSoNhanVienPikalong hoSoNhanVienPikalong) {
		hoSoNhanVienPikalongDao.update(hoSoNhanVienPikalong);
		
	}
}
