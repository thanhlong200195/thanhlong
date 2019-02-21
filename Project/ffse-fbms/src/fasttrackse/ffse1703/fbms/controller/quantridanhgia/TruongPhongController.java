package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.TruongPhongService;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping("/quantridanhgia/truongphong")
public class TruongPhongController {

	@Autowired
	public TruongPhongService service;

	@Autowired
	public UserAccountService accountService;
	
	public void setService(TruongPhongService service) {
		this.service = service;
	}
	
	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}


	@RequestMapping(value = "")
	public String redirectPage(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return "redirect:/login";
		} else {
			UserAccount user = accountService.loadUserByUsername(auth.getName());
			HoSoNhanVien hoSo = user.getNhanVien();
			ChucDanh chucDanh = hoSo.getChucDanh();
			PhongBan phongBan = hoSo.getPhongBan();
			session.setAttribute("chucDanh", chucDanh.getMaChucDanh());
			session.setAttribute("phongBan", phongBan.getMaPhongBan());
		}
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia";
	}
	
	@RequestMapping(value = "/duyetdanhgia")
	public String getListDanhGiaBanThan(Model model, HttpSession session) {
		String phongBan = session.getAttribute("phongBan").toString();
		model.addAttribute("listNhanVien", service.getListDanhGiaBanThan(phongBan));
		return "QuanTriDanhGia/truongphong/duyetdanhgia";
	}
	
	@RequestMapping(value = "/duyetdanhgia/accept/{id}")
	public String acceptDanhGiaNhanVien(Model model, @PathVariable int id) {
		DanhGiaBanThan danhGia = service.getNhanVienTuDanhGia(id);
		danhGia.setTrangThai(3);
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia";
	}
	
	@RequestMapping(value = "/duyetdanhgia/ignore/{id}")
	public String ignoreDanhGiaNhanVien(Model model, @PathVariable int id) {
		DanhGiaBanThan danhGia = service.getNhanVienTuDanhGia(id);
		danhGia.setTrangThai(4);
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia";
	}
	
	@RequestMapping(value = "/duyetdanhgia/view/{id}")
	public String showDanhGiaNhanVien(Model model, @PathVariable int id) {
		model.addAttribute("danhGia", service.getNhanVienTuDanhGia(id));
		return "QuanTriDanhGia/truongphong/viewdanhgia";
	}
	
	@RequestMapping(value = "/danhgianhanvien")
	public String getListDanhGiaNhanVien(Model model, HttpSession session) {
		String phongBan = session.getAttribute("phongBan").toString();
		LichDanhGia lich = service.getActiveLichDanhGia(phongBan);
		String kyDanhGia = lich.getKyDanhGia();
		if (service.getListNhanVienPhongBan(phongBan).size() < 1) {
			createListDanhGiaNhanVien(kyDanhGia, phongBan);
			return "redirect:/quantridanhgia/truongphong/danhgianhanvien";
		} else {
			model.addAttribute("listDanhGia", service.getListNhanVienPhongBan(phongBan));
		}
		return "QuanTriDanhGia/truongphong/danhgianhanvien";
	}
	
	public void createListDanhGiaNhanVien(String kyDanhGia, String phongBan) {
		List<HoSoNhanVien> hoSo = service.getNhanVienPhongBan(phongBan);
		List<TruongPhongDanhGia> listDanhGia = new ArrayList<>();
		for (HoSoNhanVien x : hoSo) {
			TruongPhongDanhGia danhGia = new TruongPhongDanhGia();
			danhGia.setKyDanhGia(kyDanhGia);
			danhGia.setPhongBan(phongBan);
			danhGia.setNhanVien(x.getMaNhanVien());
			listDanhGia.add(danhGia);
		}
		service.createListNhanVienPhongBan(listDanhGia);
	}
}
