package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TrangThaiTaiLieu;

public interface TrangThaiDao {
	
	public List<TrangThaiTaiLieu> listAllTrangThai();

	public void addTT(TrangThaiTaiLieu tt);

	public void updateTT(TrangThaiTaiLieu tt);

	public void deleteTT(String id);

	public TrangThaiTaiLieu getTTbyID(String id);
	
}
