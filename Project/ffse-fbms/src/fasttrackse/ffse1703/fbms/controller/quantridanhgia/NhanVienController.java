package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.NhanVienService;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping("/quantridanhgia/nhanvien")
public class NhanVienController {

	public NhanVienService nhanVienService;

	public UserAccountService accountService;

	@Autowired
	@Qualifier(value = "userAccountServiceImpl")
	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	@Qualifier(value = "nhanVienServiceImpl")
	public void setNhanVienService(NhanVienService nhanVienService) {
		this.nhanVienService = nhanVienService;
	}

	@RequestMapping(value = "/**")
	public String redirectPage(Model model, HttpSession session) {
		String page = "redirect:/quantridanhgia/nhanvien/danhgiabanthan";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			page = "redirect:/login";
		} else {
			UserAccount user = accountService.loadUserByUsername(auth.getName());
			HoSoNhanVien hoSo = user.getNhanVien();
			ChucDanh chucDanh = hoSo.getChucDanh();
			session.setAttribute("chucDanh", chucDanh.getMaChucDanh());
			session.setAttribute("nhanVien", hoSo.getMaNhanVien());
		}
		return page;
	}

	@RequestMapping(value = { "/danhgiabanthan" })
	public String getDanhGiaBanThan(Model model, HttpSession session) {
		int nhanVien = (int) session.getAttribute("nhanVien");
		model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(nhanVien));
		return "QuanTriDanhGia/nhanvien/danhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/add")
	public String createDanhGiaBanThan(Model model) {
		model.addAttribute("command", new DanhGiaBanThan());
		return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/edit/{id}")
	public String editDanhGiaBanThan(Model model, @PathVariable int id) {
		model.addAttribute("command", nhanVienService.getDanhGiaBanThan(id));
		return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
	}

	@RequestMapping(value = "/danhgiabanthan/submit", method = RequestMethod.POST)
	public String submitDanhGiaBanThan(Model model, @ModelAttribute("command") DanhGiaBanThan danhGia) {
		if (danhGia.getId() == 0) {
			danhGia.setTrangThai(2);
			nhanVienService.insertDanhGiaBanThan(danhGia);
		} else {
			nhanVienService.updateDanhGiaBanThan(danhGia);
		}
		return "redirect:/quantridanhgia/nhanvien";
	}

	@RequestMapping(value = "/danhgiabanthan/draft", method = RequestMethod.POST)
	public String addDraftDanhGiaBanThan(Model model, @ModelAttribute("command") DanhGiaBanThan danhGia) {
		if (danhGia.getId() == 0) {
			danhGia.setTrangThai(1);
			nhanVienService.insertDanhGiaBanThan(danhGia);
		} else {
			nhanVienService.updateDanhGiaBanThan(danhGia);
		}
		return "redirect:/quantridanhgia/nhanvien";
	}

	@RequestMapping(value = { "/danhgianhanvien" })
	public String getListDanhGiaNhanVien(Model model, HttpSession session) {
		int nhanVien = (int) session.getAttribute("nhanVien");
		List<DanhGiaNhanVien> list = nhanVienService.getListDanhGiaNhanVien(nhanVien);
		model.addAttribute("listDanhGiaNhanVien", list);
		return "QuanTriDanhGia/nhanvien/danhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/add/{nhanvien}/{id}")
	public String createDanhGiaNhanVien(Model model, @PathVariable("id") int id,
			@PathVariable("nhanvien") int nhanVien) {
		model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(nhanVien));
		model.addAttribute("command", nhanVienService.getDanhGiaNhanVien(id));
		return "QuanTriDanhGia/nhanvien/formdanhgianhanvien";
	}

	@RequestMapping(value = "/danhgianhanvien/submit", method = RequestMethod.POST)
	public String submitDanhGiaNhanVien(Model model, @ModelAttribute("command") DanhGiaNhanVien danhGia) {
		nhanVienService.updateDanhGiaNhanVien(danhGia);
		return "redirect:/quantridanhgia/nhanvien/danhgianhanvien";
	}

	@RequestMapping("/nhanviendanhgia")
	public String getListNhanVienDanhGia(Model model, HttpSession session) {
		int maNhanVien = (int) session.getAttribute("nhanVien");
		model.addAttribute("listDanhGia", nhanVienService.getListNhanVienDanhGia(maNhanVien));
		return "QuanTriDanhGia/nhanvien/nhanviendanhgia";
	}

	@RequestMapping("/nhanviendanhgia/view/{id}")
	public String viewNhanVienDanhGia(Model model, @PathVariable int id) {
		model.addAttribute("danhGia", nhanVienService.getNhanVienDanhGia(id));
		return "QuanTriDanhGia/nhanvien/viewnhanviendanhgia";
	}
	
	@RequestMapping("/danhgiacuatruongphong")
	public String viewDanhGiaCuaTruognPhong(Model model, HttpSession session) {
		int maNhanVien = (int) session.getAttribute("nhanVien");
		model.addAttribute("danhGia", nhanVienService.getDanhGiaCuaTruongPhong(maNhanVien));
		return "QuanTriDanhGia/nhanvien/danhgiacuatruongphong";
	}
}
