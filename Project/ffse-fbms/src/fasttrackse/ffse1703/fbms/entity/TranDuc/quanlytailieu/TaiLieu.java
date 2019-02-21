package fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Entity
@Table(name = "tai_lieu")
public class TaiLieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tai_lieu")
	Integer idTL;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Ma_Danh_Muc", nullable = false)
	@NotNull
	DanhMuc danhMuc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_trang_thai", nullable = false)
	@NotNull
	TrangThaiTaiLieu trangThai;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	@NotNull
	PhongBan phongBan;

	@Column(name = "ma_tai_lieu")
	String maTL;
	
	@Column(name = "Hinh_Bieu_Tuong")
	String iconTL;

	@Column(name = "Ten_Tai_Lieu")
	String tenTL;

	@Column(name = "mo_taTL")
	String motaTL;

	@Column(name = "Link")
	String link;

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public TrangThaiTaiLieu getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiTaiLieu trangThai) {
		this.trangThai = trangThai;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public TaiLieu() {

	}

	public Integer getIdTL() {
		return idTL;
	}

	public void setIdTL(Integer idTL) {
		this.idTL = idTL;
	}

	public String getMaTL() {
		return maTL;
	}

	public void setMaTL(String maTL) {
		this.maTL = maTL;
	}

	public String getIconTL() {
		return iconTL;
	}

	public void setIconTL(String iconTL) {
		this.iconTL = iconTL;
	}

	public String getTenTL() {
		return tenTL;
	}

	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}

	public String getMotaTL() {
		return motaTL;
	}

	public void setMotaTL(String motaTL) {
		this.motaTL = motaTL;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
