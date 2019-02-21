package fasttrackse.ffse1703.fbms.excel.quantrinhansupikalong;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;


public class HoSoNhanVienExcel extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workBook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HoSoNhanVienPikalong hoSo =  (HoSoNhanVienPikalong) model.get("hoSoNhanVien");
		Sheet sheet = workBook.createSheet("Hồ Sơ Chi Tiết");
		
		Row header = sheet.createRow(1);
		header.createCell(0).setCellValue("Hồ Sơ Chi Tiết");
		
		
		Row row = sheet.createRow(2);
		row.createCell(0).setCellValue("Mã Nhân Viên");
		row.createCell(1).setCellValue("Họ và Tên");
		row.createCell(2).setCellValue("Giới Tính");
		row.createCell(3).setCellValue("Ngày Sinh");
		row.createCell(4).setCellValue("Quốc Tịch");
		row.createCell(5).setCellValue("Dân Tộc");
		row.createCell(6).setCellValue("Quê Quán");
		row.createCell(7).setCellValue("Nơi Ở Hiện Nay");
		row.createCell(8).setCellValue("Số Điện Thoại");
		row.createCell(9).setCellValue("Email");
		row.createCell(10).setCellValue("Tình Trạng Hôn Nhân");
		row.createCell(11).setCellValue("Số CMND");
		row.createCell(12).setCellValue("Nơi Cấp");
		row.createCell(13).setCellValue("Ngày Cấp");
		
		
		row = sheet.createRow(3);
		row.createCell(0).setCellValue(hoSo.getMaNv());
		row.createCell(1).setCellValue(hoSo.getHoTenNv());
		row.createCell(2).setCellValue(hoSo.getGioiTinh());
		row.createCell(3).setCellValue(hoSo.getNgaySinh().toString());
		row.createCell(4).setCellValue(hoSo.getQuocTich());
		row.createCell(5).setCellValue(hoSo.getDanToc());
		row.createCell(6).setCellValue(hoSo.getPhuongXa().getTenPhuong());
		row.createCell(7).setCellValue(hoSo.getNoiOHienNay());
		row.createCell(8).setCellValue(hoSo.getsDT());
		row.createCell(9).setCellValue(hoSo.getEmail());
		if(hoSo.getTinhTrangHonNhan() == 0) {
			row.createCell(10).setCellValue("Chưa Kết Hôn");
		} else {
			row.createCell(10).setCellValue("Đã Kết Hôn");
		}
		
		row.createCell(11).setCellValue(hoSo.getcMND());
		row.createCell(12).setCellValue(hoSo.getNgayCap().toString());
		row.createCell(13).setCellValue(hoSo.getNoiCap());
	}

}
