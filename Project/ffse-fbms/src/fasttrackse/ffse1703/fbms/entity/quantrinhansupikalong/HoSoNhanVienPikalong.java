package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1703.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Entity
@Table(name= "ThongTinHoSo")
public class HoSoNhanVienPikalong {
	
	@Id
	@Column(name="MaNv")
	private String maNv;
	
	private String hoTenNv;
	
	private String gioiTinh;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	
	private Integer tinhTrangHonNhan;
	
	@ManyToOne
	@JoinColumn(name="ThanhPho")
	private ThanhPhoPikalong thanhPho;
	
	@ManyToOne
	@JoinColumn(name="QuanHuyen")
	private QuanHuyenPikalong quanHuyen;
	
	@ManyToOne
	@JoinColumn(name="PhuongXa")
	private PhuongPikalong phuongXa;
	
	private String noiOHienNay;
	
	private String cMND;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayCap;
	
	private String noiCap;
	
	private String sDT;
	
	private String email;
	
	private String danToc;
	
	private String quocTich;
	@ManyToOne
	@JoinColumn(name="MaChucDanh")
	private ChucDanh maChucDanh;
	
	@ManyToOne
	@JoinColumn(name="MaPhongBan")
	private PhongBan maPhongBan;
	
	private String avatar;
	
	private int isActive;

	public String getMaNv() {
		return maNv;
	}

	public String getHoTenNv() {
		return hoTenNv;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public ThanhPhoPikalong getThanhPho() {
		return thanhPho;
	}

	public QuanHuyenPikalong getQuanHuyen() {
		return quanHuyen;
	}

	public PhuongPikalong getPhuongXa() {
		return phuongXa;
	}

	public String getNoiOHienNay() {
		return noiOHienNay;
	}

	public String getcMND() {
		return cMND;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public String getsDT() {
		return sDT;
	}

	public String getEmail() {
		return email;
	}

	public String getDanToc() {
		return danToc;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public ChucDanh getMaChucDanh() {
		return maChucDanh;
	}

	public PhongBan getMaPhongBan() {
		return maPhongBan;
	}

	public String getAvatar() {
		return avatar;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public void setHoTenNv(String hoTenNv) {
		this.hoTenNv = hoTenNv;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Integer getTinhTrangHonNhan() {
		return tinhTrangHonNhan;
	}

	public void setTinhTrangHonNhan(Integer tinhTrangHonNhan) {
		this.tinhTrangHonNhan = tinhTrangHonNhan;
	}

	public void setThanhPho(ThanhPhoPikalong thanhPho) {
		this.thanhPho = thanhPho;
	}

	public void setQuanHuyen(QuanHuyenPikalong quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public void setPhuongXa(PhuongPikalong phuongXa) {
		this.phuongXa = phuongXa;
	}

	public void setNoiOHienNay(String noiOHienNay) {
		this.noiOHienNay = noiOHienNay;
	}

	public void setcMND(String cMND) {
		this.cMND = cMND;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public void setMaChucDanh(ChucDanh maChucDanh) {
		this.maChucDanh = maChucDanh;
	}

	public void setMaPhongBan(PhongBan maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	
}
