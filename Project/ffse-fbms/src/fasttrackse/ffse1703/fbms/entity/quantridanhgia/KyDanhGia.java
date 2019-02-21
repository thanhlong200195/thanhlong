package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ky_danh_gia")
@Entity
public class KyDanhGia {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ma_ky_danh_gia")
	private String maKy;

	@Column(name = "ten_ky_danh_gia")
	private String tenKy;

	@Column(name = "is_delete")
	private int isDelete;

	public KyDanhGia() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaKy() {
		return maKy;
	}

	public void setMaKy(String maKy) {
		this.maKy = maKy;
	}

	public String getTenKy() {
		return tenKy;
	}

	public void setTenKy(String tenKy) {
		this.tenKy = tenKy;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
