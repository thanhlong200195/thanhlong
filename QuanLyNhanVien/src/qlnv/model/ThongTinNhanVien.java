package qlnv.model;

import java.util.Date;

public class ThongTinNhanVien {
		private int maNhanVien;
		private String tenNhanVien,namSinh, diaChi, queQuan, soDienThoai;
		private Date ngayVao;
		public ThongTinNhanVien() {
			super();
		}
		public ThongTinNhanVien(int maNhanVien, String tenNhanVien, String namSinh, String diaChi, String queQuan,
				String soDienThoai, Date ngayVao) {
			super();
			this.maNhanVien = maNhanVien;
			this.tenNhanVien = tenNhanVien;
			this.namSinh = namSinh;
			this.diaChi = diaChi;
			this.queQuan = queQuan;
			this.soDienThoai = soDienThoai;
			this.ngayVao = ngayVao;
		}
		public ThongTinNhanVien(String tenNhanVien, String namSinh, String diaChi, String queQuan, String soDienThoai,
				Date ngayVao) {
			super();
			this.tenNhanVien = tenNhanVien;
			this.namSinh = namSinh;
			this.diaChi = diaChi;
			this.queQuan = queQuan;
			this.soDienThoai = soDienThoai;
			this.ngayVao = ngayVao;
		}
		public int getMaNhanVien() {
			return maNhanVien;
		}
		public void setMaNhanVien(int maNhanVien) {
			this.maNhanVien = maNhanVien;
		}
		public String getTenNhanVien() {
			return tenNhanVien;
		}
		public void setTenNhanVien(String tenNhanVien) {
			this.tenNhanVien = tenNhanVien;
		}
		public String getNamSinh() {
			return namSinh;
		}
		public void setNamSinh(String namSinh) {
			this.namSinh = namSinh;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		public String getQueQuan() {
			return queQuan;
		}
		public void setQueQuan(String queQuan) {
			this.queQuan = queQuan;
		}
		public String getSoDienThoai() {
			return soDienThoai;
		}
		public void setSoDienThoai(String soDienThoai) {
			this.soDienThoai = soDienThoai;
		}
		public Date getNgayVao() {
			return ngayVao;
		}
		public void setNgayVao(Date ngayVao) {
			this.ngayVao = ngayVao;
		}
		
		
}
