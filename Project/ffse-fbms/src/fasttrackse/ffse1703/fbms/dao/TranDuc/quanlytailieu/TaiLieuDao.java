package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

public interface TaiLieuDao {
	public List<TaiLieu> listAll();

	public void addTL(TaiLieu tl);

	public void updateTL(TaiLieu tl);

	public void deleteTL(Integer idTL);

	public TaiLieu getTLbyID(Integer maTL);

	public List<TaiLieu> listAll(int start,int limit);

	public List<DanhMuc> listDanhMuc();

	List<PhongBan> listPhongBan();

	List<TaiLieu> listTaiLieu();

}
