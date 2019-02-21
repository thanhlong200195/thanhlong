package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Table(name="truong_phong_danh_gia")
@Entity
public class TruongPhongDanhGia {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ma_ky_danh_gia")
	private String kyDanhGia;

	@Column(name = "ma_phong_ban")
	private String phongBan;

	@NaturalId
	@Column(name = "nhan_vien")
	private int nhanVien;

	@Column(name = "ky_luat_cong_viec")
	private int kyLuatCongViec;

	@Column(name = "tinh_than_lam_viec")
	private int tinhThanLamViec;

	@Column(name = "khoi_luong_cong_viec")
	private int khoiLuongCongViec;

	@Column(name = "ket_qua_cong_viec")
	private int ketQuaCongViec;

	@Column(name = "ky_nang_tich_luy")
	private int kyNangTichLuy;

	@Column(name = "nhan_xet_chung")
	private String nhanXet;

	@Column(name = "xep_loai")
	private int xepLoai;

	@Column(name = "is_active")
	private int isActive;

	public TruongPhongDanhGia() {
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

	public int getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(int nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getKyLuatCongViec() {
		return kyLuatCongViec;
	}

	public void setKyLuatCongViec(int kyLuatCongViec) {
		this.kyLuatCongViec = kyLuatCongViec;
	}

	public int getTinhThanLamViec() {
		return tinhThanLamViec;
	}

	public void setTinhThanLamViec(int tinhThanLamViec) {
		this.tinhThanLamViec = tinhThanLamViec;
	}

	public int getKhoiLuongCongViec() {
		return khoiLuongCongViec;
	}

	public void setKhoiLuongCongViec(int khoiLuongCongViec) {
		this.khoiLuongCongViec = khoiLuongCongViec;
	}

	public int getKetQuaCongViec() {
		return ketQuaCongViec;
	}

	public void setKetQuaCongViec(int ketQuaCongViec) {
		this.ketQuaCongViec = ketQuaCongViec;
	}

	public int getKyNangTichLuy() {
		return kyNangTichLuy;
	}

	public void setKyNangTichLuy(int kyNangTichLuy) {
		this.kyNangTichLuy = kyNangTichLuy;
	}

	public String getNhanXet() {
		return nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}

	public int getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(int xepLoai) {
		this.xepLoai = xepLoai;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
