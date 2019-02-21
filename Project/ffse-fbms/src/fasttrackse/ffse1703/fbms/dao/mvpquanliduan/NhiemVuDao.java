package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;


public interface NhiemVuDao {
	public void add(Nhiemvu nhiemVu);

	public Nhiemvu getByID(int id);

	public List<Nhiemvu> getByDuAn(String idProjects);

	public void update(Nhiemvu nhiemVu);

	public void delete(int id);
	
	public List<Nhiemvu> getByMaNhanVien(String idNv);
}
