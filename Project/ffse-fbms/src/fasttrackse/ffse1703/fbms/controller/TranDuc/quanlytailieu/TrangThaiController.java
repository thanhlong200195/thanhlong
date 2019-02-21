package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TrangThaiTaiLieu;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TrangThaiService;

@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/TrangThai")
public class TrangThaiController {
	@Autowired
	private TrangThaiService serviceTT;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewTrangThai(Model model) {
		model.addAttribute("listTrangThai", serviceTT.listAllTrangThai());
		return "TranDuc-QuanLyTaiLieu/TrangThai/TrangThaiList";
	}

	@RequestMapping(value = "/add_formTT", method = RequestMethod.GET)
	public String addFormTT(Model model) {
		model.addAttribute("TrangThai", new TrangThaiTaiLieu());
		return "TranDuc-QuanLyTaiLieu/TrangThai/add_formTT";
	}

	@RequestMapping(value = "/add_formTT", method = RequestMethod.POST)
	public String doAddTT(@ModelAttribute("TrangThai") TrangThaiTaiLieu tt,
			final RedirectAttributes redirectAttributes) {
		try {
			serviceTT.addTT(tt);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin Thử Lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
	}

	@RequestMapping(value = "/sua/{maTT}", method = RequestMethod.GET)
	public String editFormTT(@PathVariable("maTT") String maTT, Model model) {
		model.addAttribute("TrangThai", serviceTT.getTTbyID(maTT));
		return "TranDuc-QuanLyTaiLieu/TrangThai/edit_formTT";
	}

	@RequestMapping(value = "/sua/{maTT}", method = RequestMethod.POST)
	public String doEditTT(Model model, @ModelAttribute("TrangThai") TrangThaiTaiLieu tt,
			final RedirectAttributes redirectAttributes) {
		try {
			serviceTT.updateTT(tt);;
			redirectAttributes.addFlashAttribute("messageSuccess", "Update Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có Lỗi. Xin Thử Lại!");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
	}

	@RequestMapping(value = "/xoa/{maTT}", method = RequestMethod.GET)
	public String deleteTT(@PathVariable("maTT") String maTT, final RedirectAttributes redirectAttributes) {
		try {
			serviceTT.deleteTT(maTT);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
	}

	@RequestMapping(value = "/view/{maTT}", method = RequestMethod.GET)
	public String viewOneTT(@PathVariable("maTT") String maTT, Model model) {
		model.addAttribute("TrangThai", serviceTT.getTTbyID(maTT));
		return "TranDuc-QuanLyTaiLieu/TrangThai/view_oneTT";
	}
}
