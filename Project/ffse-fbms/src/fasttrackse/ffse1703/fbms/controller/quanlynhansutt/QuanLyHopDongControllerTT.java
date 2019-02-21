package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import java.io.IOException;

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

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.HopDongServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.LoaiHopDongServiceTT;

@Controller
@RequestMapping("/quanlynhansutt/hop_dong/")
public class QuanLyHopDongControllerTT {

	@Autowired
	private LoaiHopDongServiceTT loaiHopDongServiceTT;

	@Autowired
	private HopDongServiceTT hopDongServiceTT;

	public LoaiHopDongServiceTT getLoaiHopDongServiceTT() {
		return loaiHopDongServiceTT;
	}

	public void setLoaiHopDongServiceTT(LoaiHopDongServiceTT loaiHopDongServiceTT) {
		this.loaiHopDongServiceTT = loaiHopDongServiceTT;
	}

	public HopDongServiceTT getHopDongServiceTT() {
		return hopDongServiceTT;
	}

	public void setHopDongServiceTT(HopDongServiceTT hopDongServiceTT) {
		this.hopDongServiceTT = hopDongServiceTT;
	}

	// List all contracts
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHopDong(Model model) {
		model.addAttribute("listHopDong", hopDongServiceTT.getAllHopDong());
		return "QuanLyNhanSuTT/QuanLyHopDongTT/list";
	}

	// add a contract to an employee
	@RequestMapping(value = "/add_hopdong/{maNhanVien}", method = RequestMethod.GET)
	public String showFormAdd(Model model, final RedirectAttributes redirectAttributes, @PathVariable int maNhanVien) {
		model.addAttribute("hopDongTT", new HopDongTT());
		model.addAttribute("hosonv", hopDongServiceTT.getHoSoNhanVienById(maNhanVien));
		model.addAttribute("listLoaiHopDong", loaiHopDongServiceTT.findAll());
		return "QuanLyNhanSuTT/QuanLyHopDongTT/add_form";
	}

	// edit the contract for employees
	@RequestMapping("/edit_hopdong/{maNhanVien}")
	public String showFormUpdate(@PathVariable("maNhanVien") int maNhanVien, Model model)
			throws IllegalStateException, IOException {
		model.addAttribute("hopDongTT", hopDongServiceTT.findByMaHopDong(maNhanVien));
		model.addAttribute("listLoaiHopDong", loaiHopDongServiceTT.findAll());
		return "QuanLyNhanSuTT/QuanLyHopDongTT/edit_form";
	}

	// delete an employee's contract
	@RequestMapping("/remove/{maHopDong}")
	public String remove(@PathVariable("maHopDong") int maHopDong, final RedirectAttributes redirectAttributes) {
		HopDongTT hd = hopDongServiceTT.findByMaHopDong(maHopDong);
		hd.setIsdelete(0);
		hopDongServiceTT.updateHopDong(hd);
		return "redirect:/quanlynhansutt/hop_dong/";
	}

	// Processing additional information, correcting a degree for an employee
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHopDong(@ModelAttribute("hopDongTT") @Valid HopDongTT hd, BindingResult result, Model model) {
		if (hd.getMaHopDong() == 0) {
			// new person, add it
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/QuanLyHopDongTT/add_form";

			}
			// check trùng quan hệ
						int checkloaiHopDong = hopDongServiceTT.checkloaiHopDong(hd.getLoaiHopDong().getTenHopDong(),hd.getHoSoNhanVienTT().getMaNhanVien());
						System.out.println("nnnnn"+checkloaiHopDong);
						System.out.println("nnnnn"+hd.getHoSoNhanVienTT().getMaNhanVien());
						System.out.println("nnnnn"+hd.getLoaiHopDong().getTenHopDong());
						if (checkloaiHopDong >= 1) {
							model.addAttribute("messageQuanHe",
									"<script>alert('Nhân Viên Đã Có " + hd.getLoaiHopDong().getTenHopDong() + "');</script>");
							return "QuanLyNhanSuTT/QuanLyHopDongTT/add_form";
						}
			hd.setIsdelete(1);
			hopDongServiceTT.addHopDong(hd);
		} else {
			// existing person, call update
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/QuanLyHopDongTT/edit_form";
			}
			hd.setIsdelete(1);
			hopDongServiceTT.updateHopDong(hd);
		}
		return "redirect:/quanlynhansutt/ho_so/";
	}

	/*int checkQuanHe = thongTinGiaDinhServiceTT.checkQuanHe(gd.getQuanHe(),
			gd.getHoSoNhanVienTT().getMaNhanVien());
	if (checkQuanHe >= 1) {
		model.addAttribute("messageQuanHe",
				"<script>alert('Nhân Viên Đã Có " + gd.getQuanHe() + "');</script>");
		return "QuanLyNhanSuTT/ThongTinGiaDinh/add_form";
	}*/
	
	// Show the contract to an employee
	@RequestMapping("/viewOneHopDong/{maNhanVien}")
	public String viewOneHopDong(@PathVariable int maNhanVien, Model model) {
		model.addAttribute("viewOne", this.hopDongServiceTT.viewOne(maNhanVien));
		model.addAttribute("maNhanVien", maNhanVien);
		return "QuanLyNhanSuTT/QuanLyHopDongTT/viewOneHopDong";
	}

}
