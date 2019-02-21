package fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "icon")
public class IconTaiLieu {
	@Id
	@Column(name = "ma_icon")
	private String maIcon;

	@Column(name = "link_file")
	private String linkIcon;

	public String getMaIcon() {
		return maIcon;
	}

	public void setMaIcon(String maIcon) {
		this.maIcon = maIcon;
	}

	public String getLinkIcon() {
		return linkIcon;
	}

	public void setLinkIcon(String linkIcon) {
		this.linkIcon = linkIcon;
	}

}
