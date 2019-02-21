package fasttrackse.ffse1703.fbms.controller.qlynhiemvunghiabt;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.NhiemVu;
import fasttrackse.ffse1703.fbms.service.qlynhiemvunghiabt.QLyNhiemVuServiceNghiaBT;




@Controller
@RequestMapping("/QuanLyNhiemVuNghiaBT/")
public class QLyNhiemVuControllerNghiaBT {
	QLyNhiemVuServiceNghiaBT nhiemVuService;

	@Autowired
	public void setnhiemVuService(QLyNhiemVuServiceNghiaBT nhiemVuService) {
		this.nhiemVuService = nhiemVuService;
	}

	//public int totalPage(int perPage) {
	//	int totalPage = (int) Math.ceil((double) nhiemVuService.findAll().size() / (double) perPage);
	//	return totalPage;
	//}
	@RequestMapping(value = {"/","/list"})
	public String index(Model model) {
		model.addAttribute("listNhiemVu", nhiemVuService.findAll());
		return "/QuanLyNhiemVuNghiaBT/list";
	}
	
	
	
//	@RequestMapping(value = {"/","/list"}, method = RequestMethod.GET)
//	public String viewTaiLieu(Model model,
//			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
//		int perPage = 2;
//		int totalPage = totalPage(perPage);
//		int start = (currentPage - 1) * perPage;
//		model.addAttribute("listNhiemVu", nhiemVuService.findAllForPaging(start, perPage));
//		model.addAttribute("lastPage", totalPage);
//		model.addAttribute("currentPage", currentPage);
//
//		return "/QuanLyNhiemVuNghiaBT/list";
//	}
	
	@RequestMapping(value= "/view/{ID}")
	public String viewOne(@PathVariable("ID") int id, HttpServletRequest request, Model model) {
		model.addAttribute("list", nhiemVuService.findByID(id));
		return "/QuanLyNhiemVuNghiaBT/viewOne";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("NhiemVu", new NhiemVu());
		model.addAttribute("TrangThai", nhiemVuService.trangThai());
		model.addAttribute("LoaiCongViec", nhiemVuService.loaiCongViec());
		model.addAttribute("DuAn", nhiemVuService.duAn());
		model.addAttribute("NhanVien", nhiemVuService.nhanVien());
		return "/QuanLyNhiemVuNghiaBT/add_form";
	}
// thêm mới 
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createCongViec(Model model, @ModelAttribute("NhiemVu") @Valid NhiemVu cv,BindingResult bindingResult,final RedirectAttributes redirectAttributes) {
//		cv.setIsDelete(0);
//		nhiemVuService.addNew(cv);
		try {
			cv.setIsDelete(0);
			nhiemVuService.addNew(cv);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Vui Lòng Nhập Lại !");
			return "redirect:/QuanLyNhiemVuNghiaBT/create";
		}
		
		return "redirect:/QuanLyNhiemVuNghiaBT/list";
	}
//xóa theo ID
	@RequestMapping("/delete/{ID}")
	public String delete(@PathVariable("ID") int id, HttpServletRequest request, Model model) {
		NhiemVu nv = nhiemVuService.findByID(id);
		nv.setIsDelete(1);
		nhiemVuService.delete(nv);
		return "redirect:/QuanLyNhiemVuNghiaBT/list";
	}
//sửa 
	@RequestMapping(value = "/edit/{ID}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("ID") int id, Model model) {
		model.addAttribute("NhiemVu", nhiemVuService.findByID(id));
		model.addAttribute("TrangThai", nhiemVuService.trangThai());
		model.addAttribute("LoaiCongViec", nhiemVuService.loaiCongViec());
		model.addAttribute("DuAn", nhiemVuService.duAn());
		model.addAttribute("NhanVien", nhiemVuService.nhanVien());
		return "/QuanLyNhiemVuNghiaBT/edit_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("NhiemVu") @Valid NhiemVu NhiemVu,  BindingResult bindingResult,final RedirectAttributes redirectAttributes)
			throws IllegalStateException {
		
		try {
			nhiemVuService.update(NhiemVu);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thay Đổi Thành Công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Vui Lòng Nhập Lại !");
			return "redirect:/QuanLyNhiemVuNghiaBT/edit/"+ NhiemVu.getID();
		}
		
		
		return "redirect:/QuanLyNhiemVuNghiaBT/list";
	}

}