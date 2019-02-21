package fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "cong_viec")
public class NhiemVu {
	
	@Id
	@Column(name = "ID")
	@NotNull
	private int ID;

	@Column(name = "ten_cong_viec")
	@NotEmpty
	private String tenCongViec;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CV", nullable=false)
	@NotNull
	private LoaiCongViecNghiaBT maCongViec;
	
	@Column(name = "mo_ta")
	@NotEmpty
	private String moTa;
	
	@Column(name = "tg_bat_dau")
	@NotEmpty
	private String tgBatDau;
	
	@Column(name = "tg_ket_thuc")
	@NotEmpty
	private String tgKetThuc;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_nhan_vien", nullable=false)
	private HoSoNhanVien phanCong;
	
	@Column(name = "tg_du_kien")
	@NotEmpty
	private String tgDuKien;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TT", nullable=false)
	@NotNull
	private TrangThaiNghiaBT maTrangThai;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_du_an", nullable=false)
	private DuAnNghiaBT duAn;
	
	@Column(name = "is_delete")
	@NotNull
	private int isDelete;
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTenCongViec() {
		return tenCongViec;
	}

	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}

	

	public LoaiCongViecNghiaBT getMaCongViec() {
		return maCongViec;
	}

	public void setMaCongViec(LoaiCongViecNghiaBT maCongViec) {
		this.maCongViec = maCongViec;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTgBatDau() {
		return tgBatDau;
	}

	public void setTgBatDau(String tgBatDau) {
		this.tgBatDau = tgBatDau;
	}

	public String getTgKetThuc() {
		return tgKetThuc;
	}

	public void setTgKetThuc(String tgKetThuc) {
		this.tgKetThuc = tgKetThuc;
	}

	public HoSoNhanVien getPhanCong() {
		return phanCong;
	}

	public void setPhanCong(HoSoNhanVien phanCong) {
		this.phanCong = phanCong;
	}

	public String getTgDuKien() {
		return tgDuKien;
	}

	public void setTgDuKien(String tgDuKien) {
		this.tgDuKien = tgDuKien;
	}

	

	public TrangThaiNghiaBT getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(TrangThaiNghiaBT maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public DuAnNghiaBT getDuAn() {
		return duAn;
	}

	public void setDuAn(DuAnNghiaBT duAn) {
		this.duAn = duAn;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
}
