package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;

public interface NhiemVuService {
	public void add(Nhiemvu nhiemVu);

	public Nhiemvu getByID(int id);

	public List<Nhiemvu> getByDuAn(String idProjects);

	public void update(Nhiemvu nhiemVu);

	public void delete(int id);
	
	public List<Nhiemvu> getByMaNhanVien(String idNv);
}
