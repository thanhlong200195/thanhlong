package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu.TaiLieuDao;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
@Service
public class TaiLieuServiceImpl implements TaiLieuService {
	@Autowired
	private TaiLieuDao daoTL;
	@Override
	public List<TaiLieu> listAll() {
		return daoTL.listAll();
	}

	@Override
	public void addTL(TaiLieu tl) {
		daoTL.addTL(tl);
	}

	@Override
	public void updateTL(TaiLieu tl) {
		daoTL.updateTL(tl);
	}

	@Override
	public void deleteTL(Integer idTL) {
		daoTL.deleteTL(idTL);
	}

	@Override
	public TaiLieu getTLbyID(Integer idTL) {
		return daoTL.getTLbyID(idTL);
	}

	@Override
	public List<TaiLieu> listAllPaging(int start, int limit) {
		return daoTL.listAll(start,limit);
	}

	@Override
	public List<PhongBan> listPhongBan() {
		return daoTL.listPhongBan();
	}

	@Override
	public List<DanhMuc> listDanhMuc() {
		return daoTL.listDanhMuc();
	}

}
