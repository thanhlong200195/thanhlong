package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TrangThaiTaiLieu;

public interface TrangThaiService {
	
	public List<TrangThaiTaiLieu> listAllTrangThai();

	public void addTT(TrangThaiTaiLieu tt);

	public void updateTT(TrangThaiTaiLieu tt);

	public void deleteTT(String id);

	public TrangThaiTaiLieu getTTbyID(String id);

}
