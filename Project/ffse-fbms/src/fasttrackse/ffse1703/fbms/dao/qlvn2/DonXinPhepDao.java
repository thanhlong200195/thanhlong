package fasttrackse.ffse1703.fbms.dao.qlvn2;

import java.util.List;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.SoNgayNghiEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface DonXinPhepDao {
	public List<DonXinPhepEntity> danhsachnhap003();

	public List<DonXinPhepEntity> danhsachchoduyet003();

	public List<DonXinPhepEntity> danhsachdaduyet003();

	public List<DonXinPhepEntity> danhsachbituchoi003();

	public List<LyDoEntity> danhSachLyDo();

	public List<TrangThaiEntity> danhSachTrangThai();

	public List<HoSoNhanVien> danhSachHoSo();

	public void create(DonXinPhepEntity DonXinPhepEntity);

	public void createcho(DonXinPhepEntity DonXinPhepEntity);

	public void createduyet(DonXinPhepEntity DonXinPhepEntity);

	public void createtuchoi(DonXinPhepEntity DonXinPhepEntity);

	public DonXinPhepEntity findById(int id);

	public void delete(int id);

	public void Updatecho(DonXinPhepEntity DonXinPhepEntity);
	
	public List<DonXinPhepEntity>  findAllForPaging1(int startPosition,int maxResult);
	public List<DonXinPhepEntity>  findAllForPaging2(int startPosition,int maxResult);
	public List<DonXinPhepEntity>  findAllForPaging3(int startPosition,int maxResult);
	public List<DonXinPhepEntity>  findAllForPaging4(int startPosition,int maxResult);
	
public List<SoNgayNghiEntity> bangNgayNghi();
	
	public SoNgayNghiEntity findByIdngay(int id);
	
	public void deletengay(int id); 
	

}

