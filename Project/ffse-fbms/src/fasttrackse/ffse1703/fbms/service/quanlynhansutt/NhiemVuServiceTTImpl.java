package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.NhiemVuDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.NhiemVuTT;

@Service
public class NhiemVuServiceTTImpl implements NhiemVuServiceTT {
	@Autowired
	private NhiemVuDaoTT nhiemVuDao;

	@Override
	@Transactional
	public void add(NhiemVuTT nhiemVu) {
		// TODO Auto-generated method stub
		nhiemVuDao.add(nhiemVu);
	}

	@Override
	@Transactional
	public NhiemVuTT getByID(int id) {
		// TODO Auto-generated method stub
		return nhiemVuDao.getByID(id);
	}

	@Override
	@Transactional
	public List<NhiemVuTT> getByDuAn(String idProjects) {
		// TODO Auto-generated method stub
		return nhiemVuDao.getByDuAn(idProjects);
	}

	@Override
	@Transactional
	public void update(NhiemVuTT nhiemVu) {
		// TODO Auto-generated method stub
		nhiemVuDao.update(nhiemVu);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		nhiemVuDao.delete(id);
	}

	@Override
	@Transactional
	public List<NhiemVuTT> getByMaNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub
		return nhiemVuDao.getByMaNhanVien(maNhanVien);
	}

}
