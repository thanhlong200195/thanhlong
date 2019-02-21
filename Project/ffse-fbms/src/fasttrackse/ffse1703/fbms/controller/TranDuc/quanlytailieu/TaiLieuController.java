package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.IconTaiLieu;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.IconService;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TaiLieuService;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TrangThaiService;

@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/TaiLieu")
public class TaiLieuController {
	private static final String UPLOAD_DIRECTORY = "/upload/";
	@Autowired
	private TaiLieuService serviceTL;
	@Autowired
	private TrangThaiService serviceTT;
	@Autowired
	private IconService serviceIC;
	
	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) serviceTL.listAll().size() / (double) perPage);
		return totalPage;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewTaiLieu(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int perPage = 5;
		int totalPage = totalPage(perPage);
		int start = (currentPage - 1) * perPage;
		model.addAttribute("listTaiLieu", serviceTL.listAllPaging(start, perPage));
		model.addAttribute("lastPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		return "TranDuc-QuanLyTaiLieu/TaiLieu/TaiLieuList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addFormTL(Model model) {
		List<DanhMuc> listdm = serviceTL.listDanhMuc();
		model.addAttribute("listDanhMuc", listdm);
		model.addAttribute("TaiLieu", new TaiLieu());
		List<PhongBan> listpb = serviceTL.listPhongBan();
		model.addAttribute("listPhongBan", listpb);
		return "TranDuc-QuanLyTaiLieu/TaiLieu/add_formTL";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submitTL(@ModelAttribute("TaiLieu") TaiLieu tl, @RequestParam("file") MultipartFile file,
			HttpServletRequest request, Model model, final RedirectAttributes redirectAttributes) {
		try {
			String nameFile = file.getOriginalFilename();
			File fileDir = new File(request.getServletContext().getRealPath(UPLOAD_DIRECTORY));
			byte[] bytes = file.getBytes();
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			File serverFile = new File(fileDir.getAbsolutePath() + File.separator + nameFile);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.flush();
			stream.close();
			tl.setTenTL(nameFile);
			tl.setLink(fileDir.getAbsolutePath());
			String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());
			List<IconTaiLieu> listIC = serviceIC.listAllIconTaiLieu();
			for(IconTaiLieu x:listIC) {
				if(x.getMaIcon().equalsIgnoreCase(format)) {
					tl.setIconTL(format);
				} else {
					tl.setIconTL("unknow");
				}
			}
			tl.setTrangThai(serviceTT.getTTbyID("Wait"));
			serviceTL.addTL(tl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin Thử Lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/draft", method = RequestMethod.POST)
	public String draftTL(@ModelAttribute("TaiLieu") TaiLieu tl, @RequestParam("file") MultipartFile file,
			HttpServletRequest request, Model model, final RedirectAttributes redirectAttributes) {
		try {
			String nameFile = file.getOriginalFilename();
			File fileDir = new File(request.getServletContext().getRealPath(UPLOAD_DIRECTORY));
			byte[] bytes = file.getBytes();
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			File serverFile = new File(fileDir.getAbsolutePath() + File.separator + nameFile);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.flush();
			stream.close();
			tl.setTenTL(nameFile);
			tl.setLink(fileDir.getAbsolutePath());
			String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());
			List<IconTaiLieu> listIC = serviceIC.listAllIconTaiLieu();
			for(IconTaiLieu x:listIC) {
				if(x.getMaIcon().equalsIgnoreCase(format)) {
					tl.setIconTL(format);
				} else {
					tl.setIconTL("unknow");
				}
			}
			tl.setTrangThai(serviceTT.getTTbyID("Draft"));
			serviceTL.addTL(tl);
			redirectAttributes.addFlashAttribute("messageSuccess", "Lưu Nháp Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin Thử Lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/sua/{idTL}", method = RequestMethod.GET)
	public String editFormTL(@PathVariable("idTL") Integer idTL, Model model) {
		model.addAttribute("TaiLieu", serviceTL.getTLbyID(idTL));
		return "TranDuc-QuanLyTaiLieu/TaiLieu/edit_formTL";
	}

	@RequestMapping(value = "/cancel")
	public String cancelTL(Model model) {
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/xoa/{idTL}", method = RequestMethod.GET)
	public String delete(@PathVariable("idTL") Integer idTL, final RedirectAttributes redirectAttributes) {
		try {
			serviceTL.deleteTL(idTL);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/view/{idTL}", method = RequestMethod.GET)
	public String viewOneTL(@PathVariable("idTL") Integer idTL, Model model) {
		model.addAttribute("TaiLieu", serviceTL.getTLbyID(idTL));
		model.addAttribute("icon",serviceIC.getICbyID(serviceTL.getTLbyID(idTL).getIconTL()));
		return "TranDuc-QuanLyTaiLieu/TaiLieu/view_oneTL";
	}

}
