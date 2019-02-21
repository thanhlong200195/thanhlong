package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.BangCapPikalong;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.BangCapPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;

@Controller
@RequestMapping(value = "/QuanTriNhanSuPikalong/QuanLiBangCap")
public class BangCapPikalongController {
	// Trang index
	public int currentPage = 1;
	// Số sinh viên trên 1 trang
	public int soBanGhi = 4;

	@RequestMapping("/listBangCapPikalong")
	public String redirect(HttpSession session) {
		if (session.getAttribute("page") != null) {
			currentPage = (int) session.getAttribute("page");
		}
		return "redirect:/QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong/" + currentPage;
	}
	
	@Autowired
	private BangCapPikalongService bangCapPikalongService;

	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;

	public void setBangCapPikalongService(BangCapPikalongService bangCapPikalongService) {
		this.bangCapPikalongService = bangCapPikalongService;
	}
	//
	@RequestMapping(value = "/listBangCapPikalong/{pageid}", method = RequestMethod.GET)
	public String listBangCapPikalong(Model model, HttpSession session, @PathVariable int pageid) {
		int tongTrang = (int) Math.ceil((long) bangCapPikalongService.total() / (double) soBanGhi);

		int start = (int) ((pageid - 1) * soBanGhi);
		model.addAttribute("total", tongTrang);
		session.setAttribute("page", pageid);
		model.addAttribute("listBangCap", this.bangCapPikalongService.listBangCapPikalong(start, soBanGhi));
		return "QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong";
	}

	@RequestMapping(value = "/add/{maNV}", method = RequestMethod.GET)
	public String showFormAdd(Model model, HttpSession session, @PathVariable String maNV) {
		BangCapPikalong hsnv = new BangCapPikalong();
		hsnv.setMaNV(maNV);
		model.addAttribute("command", hsnv);
		session.setAttribute("maNv", maNV);
		//model.addAttribute("maNv", maNV);
		return "QuanTriNhanSuPikalong/QuanLiBangCap/formAddBangCapPikalong";
	}

	@RequestMapping("/edit/{maNV}")
	public String showFormUpdate(@PathVariable("maNV") int id, Model model,BangCapPikalong p) throws IllegalStateException, IOException {
		p = bangCapPikalongService.getBangCapPikalongById(id);
		model.addAttribute("command", p);
		model.addAttribute("maNv", p.getMaNV());
		return "QuanTriNhanSuPikalong/QuanLiBangCap/formUpdateBangCapPikalong";
	}

	
	@RequestMapping("/viewOneBangCap/{maNV}")
	public String viewOneBangCap( @PathVariable String maNV,Model model) {
		model.addAttribute("hosonhanvien", this.hoSoNhanVienPikalongService.getEdit(maNV));
		model.addAttribute("viewOne",this.bangCapPikalongService.viewOne(maNV));
		model.addAttribute("maNv", maNV);
		return "QuanTriNhanSuPikalong/QuanLiBangCap/viewOneBangCapPikalong";
	}
	//
	@RequestMapping("/saveOneBangCap")
	public String saveOneBangCap(@ModelAttribute("command") @Valid BangCapPikalong p, BindingResult result) {
		//System.out.println("ma nv " + p.getMaNV());
		if (result.hasErrors()) {
			return "QuanTriNhanSuPikalong/QuanLiBangCap/formAddBangCapPikalong";
		}
		bangCapPikalongService.addBangCapPikalong(p);
		return "redirect:/QuanTriNhanSuPikalong/QuanLiBangCap/viewOneBangCap/" + p.getMaNV();
	}
	@RequestMapping("/editOneBangCap")
	public String updateOneBangCap(@ModelAttribute("command") @Valid BangCapPikalong p, BindingResult result) {
		//System.out.println("ma nv " + p.getMaNV());
		if (result.hasErrors()) {
			return "QuanTriNhanSuPikalong/QuanLiBangCap/formUpdateBangCapPikalong";
		}
		bangCapPikalongService.updateBangCapPikalong(p);
		return "redirect:/QuanTriNhanSuPikalong/QuanLiBangCap/viewOneBangCap/" + p.getMaNV();
	}
	@RequestMapping("/remove/{id}")
	public String removeOneBangCap(@PathVariable("id") int id,BangCapPikalong p) {
		p = bangCapPikalongService.getBangCapPikalongById(id);
		bangCapPikalongService.removeBangCapPikalong(id);
		return "redirect:/QuanTriNhanSuPikalong/QuanLiBangCap/viewOneBangCap/" + p.getMaNV();
	}
}
