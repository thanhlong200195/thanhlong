package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import java.util.List;

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

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Roles;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.NhiemVuService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.ProjectService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.RolesService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;

@Controller
@RequestMapping("/mvpquanliduan/nhiemvu")
public class NhiemVuController {
	@Autowired
	private NhiemVuService nhiemVuService;
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private ProjectService projectService;
	
	public void setNhiemVuService(NhiemVuService nhiemVuService) {
		this.nhiemVuService = nhiemVuService;
	}
	@RequestMapping(value = "/list-nhiemvu/{idProjects}")
	public String listNhiemVu(Model model,@PathVariable String idProjects) {
		List<Nhiemvu> list=nhiemVuService.getByDuAn(idProjects);
		model.addAttribute("idProjects", idProjects);
		model.addAttribute("listNhiemVu", list);
		return "MvpQuanLiDuAn/phancongnhiemvu/list";
	}
	@RequestMapping("/show-form-add/{idProjects}")
	public String showFormAdd(Model model,@PathVariable String idProjects) {
		Projects pr = projectService.findById(idProjects);
		model.addAttribute("duAn", pr);
		model.addAttribute("command", new Nhiemvu());
		List<HoSoNhanVienPikalong> nhanVienList = hoSoNhanVienPikalongService.listNhanVien();
		model.addAttribute("nhanVienList", nhanVienList);
		List<Roles> list = rolesService.findAll();
		model.addAttribute("listRoles", list);
		return "MvpQuanLiDuAn/phancongnhiemvu/add_form";
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("nhiemVu") Nhiemvu nhiemVu, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/phancongnhiemvu/add_form";
		}
		
		
		nhiemVu.setStatus(1);
		nhiemVuService.add(nhiemVu);
		;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Th�m th�nh c�ng');</script>");
		return "redirect: list-nhiemvu";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable int id) {
		Nhiemvu nhiemVu = nhiemVuService.getByID(id);
		model.addAttribute("nhiemVu", nhiemVu);
		return "MvpQuanLiDuAn/phancongnhiemvu/update_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("nhiemVu") Nhiemvu nhiemVu, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/phancongnhiemvu/update_form";
		}
		nhiemVu.setStatus(1);
		nhiemVuService.update(nhiemVu);
		return "redirect: /ffse-fbms/mvpquanliduan/nhiemvu/list-nhiemvu";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		Nhiemvu nhiemVu  = nhiemVuService.getByID(id);
		nhiemVu.setStatus(0);
		nhiemVuService.update(nhiemVu);
		return "redirect: /ffse-fbms/mvpquanliduan/nhiemvu/list-nhiemvu";
	}
}
