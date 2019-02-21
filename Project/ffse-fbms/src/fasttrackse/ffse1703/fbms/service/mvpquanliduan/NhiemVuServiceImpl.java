package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.NhiemVuDao;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;
@Service
@Transactional
public class NhiemVuServiceImpl implements NhiemVuService {
@Autowired
private NhiemVuDao nhiemVuDao;
@Override
	public void add(Nhiemvu nhiemVu) {
		
	nhiemVuDao.add(nhiemVu);
	}

	@Override
	public Nhiemvu getByID(int id) {
		
		return nhiemVuDao.getByID(id);
	}

	@Override
	public List<Nhiemvu> getByDuAn(String idProjects) {
		
		return nhiemVuDao.getByDuAn(idProjects);
	}

	@Override
	public void update(Nhiemvu nhiemVu) {
		nhiemVuDao.update(nhiemVu);

	}

	@Override
	public void delete(int id) {
		nhiemVuDao.delete(id);
	}

	@Override
	public List<Nhiemvu> getByMaNhanVien(String idNv) {
		
		return nhiemVuDao.getByMaNhanVien(idNv);
	}

}
