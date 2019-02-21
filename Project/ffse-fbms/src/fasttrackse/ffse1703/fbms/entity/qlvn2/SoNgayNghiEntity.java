package fasttrackse.ffse1703.fbms.entity.qlvn2;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "so_ngay_nghi")
public class SoNgayNghiEntity {
	@Id
	@Column(name = "ma_nhan_vien")
	private int  maNhanVien;
	
	@Column(name = "so_ngay_nghi")
	private int soNgayNghi;
	
	@Column(name = "so_ngay_nghi_con_lai")
	private int ngayNghiConLai;

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

	public int getNgayNghiConLai() {
		return ngayNghiConLai;
	}

	public void setNgayNghiConLai(int ngayNghiConLai) {
		this.ngayNghiConLai = ngayNghiConLai;
	}

	

	
	
	
}
