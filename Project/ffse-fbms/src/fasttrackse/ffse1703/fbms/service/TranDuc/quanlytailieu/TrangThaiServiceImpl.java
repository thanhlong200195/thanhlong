package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu.TrangThaiDao;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TrangThaiTaiLieu;
@Service
public class TrangThaiServiceImpl implements TrangThaiService {

	@Autowired
	private TrangThaiDao daoTT;

	@Override
	public List<TrangThaiTaiLieu> listAllTrangThai() {
		return daoTT.listAllTrangThai();
	}

	@Override
	public void addTT(TrangThaiTaiLieu tt) {
		daoTT.addTT(tt);
	}

	@Override
	public void updateTT(TrangThaiTaiLieu tt) {
		daoTT.updateTT(tt);
	}

	@Override
	public void deleteTT(String id) {
		daoTT.deleteTT(id);
	}

	@Override
	public TrangThaiTaiLieu getTTbyID(String id) {
		return daoTT.getTTbyID(id);
	}

}
