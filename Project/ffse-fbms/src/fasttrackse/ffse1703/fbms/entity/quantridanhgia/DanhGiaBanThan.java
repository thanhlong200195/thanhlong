package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "danh_gia_ban_than")
public class DanhGiaBanThan {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ma_ky_danh_gia")
	@NotEmpty
	private String kyDanhGia;

	@Column(name = "ma_phong_ban")
	@NotEmpty
	private String phongBan;

	@NaturalId
	@Column(name = "nhan_vien")
	private int nhanVien;

	@Column(name = "ky_luat_cong_viec_danh_gia")
	private int kyLuatCongViec_DG;

	@Column(name = "ky_luat_cong_viec_mo_ta", nullable = false)
	@NotEmpty
	private String kyLuatCongViec_MT;

	@Column(name = "tinh_than_lam_viec_danh_gia")
	private int tinhThanLamViec_DG;

	@Column(name = "tinh_than_lam_viec_mo_ta", nullable = false)
	@NotEmpty
	private String tinhThanLamViec_MT;

	@Column(name = "khoi_luong_cong_viec_danh_gia")
	private int khoiLuongCongViec_DG;

	@Column(name = "khoi_luong_cong_viec_mo_ta", nullable = false)
	@NotEmpty
	private String khoiLuongCongViec_MT;

	@Column(name = "ket_qua_cong_viec_danh_gia")
	private int ketQuaCongViec_DG;

	@Column(name = "ket_qua_cong_viec_mo_ta", nullable = false)
	@NotEmpty
	private String ketQuaCongViec_MT;

	@Column(name = "ky_nang_tich_luy_danh_gia")
	private int kyNangTichLuy_DG;

	@Column(name = "ky_nang_tich_luy_mo_ta", nullable = false)
	@NotEmpty
	private String kyNangTichLuy_MT;

	@Column(name = "dinh_huong", nullable = false)
	@NotEmpty
	private String dinhHuong;

	@Column(name = "danh_gia_tong_the")
	private int danhGiaTongThe;

	@Column(name = "ma_trang_thai")
	private int trangThai;

	@Column(name = "is_delete")
	private int isDelete;

	public DanhGiaBanThan() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKyDanhGia() {
		return kyDanhGia;
	}

	public void setKyDanhGia(String kyDanhGia) {
		this.kyDanhGia = kyDanhGia;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public void setNhanVien(int nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getNhanVien() {
		return nhanVien;
	}

	public int getKyLuatCongViec_DG() {
		return kyLuatCongViec_DG;
	}

	public void setKyLuatCongViec_DG(int kyLuatCongViec_DG) {
		this.kyLuatCongViec_DG = kyLuatCongViec_DG;
	}

	public String getKyLuatCongViec_MT() {
		return kyLuatCongViec_MT;
	}

	public void setKyLuatCongViec_MT(String kyLuatCongViec_MT) {
		this.kyLuatCongViec_MT = kyLuatCongViec_MT;
	}

	public int getTinhThanLamViec_DG() {
		return tinhThanLamViec_DG;
	}

	public void setTinhThanLamViec_DG(int tinhThanLamViec_DG) {
		this.tinhThanLamViec_DG = tinhThanLamViec_DG;
	}

	public String getTinhThanLamViec_MT() {
		return tinhThanLamViec_MT;
	}

	public void setTinhThanLamViec_MT(String tinhThanLamViec_MT) {
		this.tinhThanLamViec_MT = tinhThanLamViec_MT;
	}

	public int getKhoiLuongCongViec_DG() {
		return khoiLuongCongViec_DG;
	}

	public void setKhoiLuongCongViec_DG(int khoiLuongCongViec_DG) {
		this.khoiLuongCongViec_DG = khoiLuongCongViec_DG;
	}

	public String getKhoiLuongCongViec_MT() {
		return khoiLuongCongViec_MT;
	}

	public void setKhoiLuongCongViec_MT(String khoiLuongCongViec_MT) {
		this.khoiLuongCongViec_MT = khoiLuongCongViec_MT;
	}

	public int getKetQuaCongViec_DG() {
		return ketQuaCongViec_DG;
	}

	public void setKetQuaCongViec_DG(int ketQuaCongViec_DG) {
		this.ketQuaCongViec_DG = ketQuaCongViec_DG;
	}

	public String getKetQuaCongViec_MT() {
		return ketQuaCongViec_MT;
	}

	public void setKetQuaCongViec_MT(String ketQuaCongViec_MT) {
		this.ketQuaCongViec_MT = ketQuaCongViec_MT;
	}

	public int getKyNangTichLuy_DG() {
		return kyNangTichLuy_DG;
	}

	public void setKyNangTichLuy_DG(int kyNangTichLuy_DG) {
		this.kyNangTichLuy_DG = kyNangTichLuy_DG;
	}

	public String getKyNangTichLuy_MT() {
		return kyNangTichLuy_MT;
	}

	public void setKyNangTichLuy_MT(String kyNangTichLuy_MT) {
		this.kyNangTichLuy_MT = kyNangTichLuy_MT;
	}

	public String getDinhHuong() {
		return dinhHuong;
	}

	public void setDinhHuong(String dinhHuong) {
		this.dinhHuong = dinhHuong;
	}

	public int getDanhGiaTongThe() {
		return danhGiaTongThe;
	}

	public void setDanhGiaTongThe(int danhGiaTongThe) {
		this.danhGiaTongThe = danhGiaTongThe;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
