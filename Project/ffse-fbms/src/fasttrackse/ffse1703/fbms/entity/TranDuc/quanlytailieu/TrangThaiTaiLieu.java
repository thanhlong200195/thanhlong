package fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai")
public class TrangThaiTaiLieu {

	@Id
	@Column(name = "ma_trang_thai")
	private String maTT;

	@Column(name = "ten_trang_thai")
	private String tenTT;

	public TrangThaiTaiLieu() {

	}

	public TrangThaiTaiLieu( String maTT, String tenTT) {
		super();
		this.maTT = maTT;
		this.tenTT = tenTT;
	}

	public String getMaTT() {
		return maTT;
	}

	public void setMaTT(String maTT) {
		this.maTT = maTT;
	}

	public String getTenTT() {
		return tenTT;
	}

	public void setTenTT(String tenTT) {
		this.tenTT = tenTT;
	}

}
