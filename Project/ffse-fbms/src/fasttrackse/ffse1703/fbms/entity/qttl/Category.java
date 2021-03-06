package fasttrackse.ffse1703.fbms.entity.qttl;

//import java.io.Serializable;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "danh_muc")
public class Category  {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "image")
	private String image;

	

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "ten_danh_muc")
	private String ten_danh_muc;

	@Column(name = "ma_danh_muc")
	private String ma_danh_muc;

	public String getTen_danh_muc() {
		return ten_danh_muc;
	}

	public void setTen_danh_muc(String ten_danh_muc) {
		this.ten_danh_muc = ten_danh_muc;
	}

	public String getMa_danh_muc() {
		return ma_danh_muc;
	}

	public void setMa_danh_muc(String ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}
	
	public Category(int id, String ma_danh_muc, String ten_danh_muc, String image) {
		super();
		this.id = id;
		this.ma_danh_muc = ma_danh_muc;
		this.ten_danh_muc = ten_danh_muc;
		this.image = image;
	}
	
	public Category() {
		
		super();
	}
	
}