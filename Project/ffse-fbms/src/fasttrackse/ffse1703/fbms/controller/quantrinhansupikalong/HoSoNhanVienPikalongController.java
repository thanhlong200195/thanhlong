package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.PhuongPikalong;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.QuanHuyenPikalong;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.BangCapPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.GiaDinhPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.PhuongPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.QuanHuyenPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.QuocTichPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.ThanhPhoPikalongService;
import fasttrackse.ffse1703.fbms.service.security.ChucDanhService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;
import fasttrackse.ffse1703.fbms.excel.quantrinhansupikalong.HoSoNhanVienExcel;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/quantrinhansu/hosonhanvien/")
public class HoSoNhanVienPikalongController {
	
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	
	@Autowired 
	private QuocTichPikalongService quocTichPikalongService;
	
	@Autowired
	private ThanhPhoPikalongService thanhPhoPikalongService;
	
	@Autowired
	private QuanHuyenPikalongService quanHuyenPikalongService;
	
	@Autowired
	private PhuongPikalongService phuongPikalongService;
	
	@Autowired
	private ChucDanhService chucDanhService;
	
	@Autowired
	private PhongBanService phongBanService;
	
	@Autowired
	private GiaDinhPikalongService giaDinhPikalongService;
	
	@Autowired
	private BangCapPikalongService bangCapPikalongService;
	
	private static final String UPLOAD_DIRECTORY ="/upload"; 
	
	HoSoNhanVienPikalong getNhanVien = new HoSoNhanVienPikalong();
	
	@RequestMapping("/")
	public String index(Model model) {
		List<HoSoNhanVienPikalong> nhanVienList = hoSoNhanVienPikalongService.listNhanVien();
		model.addAttribute("nhanVienList", nhanVienList);
		return "QuanTriNhanSuPikalong/ThongTinHoSo/index";
	}
	
	@RequestMapping("delete/{maNv}") // delete employee
	public String delete(@PathVariable String maNv) {
		hoSoNhanVienPikalongService.delete(maNv);
		return "redirect:/quantrinhansu/hosonhanvien/";
	}
	
	@RequestMapping(value= "addform", method= RequestMethod.GET)
	public String addform(Model model) {
		model.addAttribute("formHosopkl", new HoSoNhanVienPikalong());
		model.addAttribute("listQuocTich", quocTichPikalongService.listQuocTich());
		model.addAttribute("listThanhPho",  thanhPhoPikalongService.listTinhThanh());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listChucDanh", chucDanhService.findAll());
		return "QuanTriNhanSuPikalong/ThongTinHoSo/thongtinhosoaddform";
	}
	
	@RequestMapping(value= "insert", method= RequestMethod.POST)
	public String addsave(@ModelAttribute("formHosopkl") @Valid HoSoNhanVienPikalong hoSoNhanVien, 
			BindingResult result, @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		File fileUpload = new File(path);
		 if (!fileUpload.exists()) {
			 fileUpload.mkdir();
		 }


		String filename = file.getOriginalFilename();
		System.out.println(path + " " + filename);
		byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename))); 
	    hoSoNhanVien.setAvatar(filename);
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
		
		hoSoNhanVienPikalongService.insert(hoSoNhanVien);
		return "redirect:/quantrinhansu/hosonhanvien/";
	}
	
	// ThanhPho Json
	@RequestMapping(value= "selectquan/{maThanhPho}", method= RequestMethod.GET, produces= "text/plain;charset=UTF-8")
	@ResponseBody // khi return ko tráº£ vá»� trang jsp mÃ Â  tráº£ vá»� code html
	public String selectQuan(@PathVariable String maThanhPho) {
		List<QuanHuyenPikalong> listQuanHuyen =  quanHuyenPikalongService.listQuanHuyen(maThanhPho);
		
		String json = "[";
		
		for(int i =0; i < listQuanHuyen.size(); i++) {
			
			if (i == listQuanHuyen.size() - 1) {
				json += "{\"maQuanHuyen\":" + "\"" + listQuanHuyen.get(i).getMaQuanHuyen() + "\"" + ", \"tenQuanHuyen\" :" + "\"" + listQuanHuyen.get(i).getTenQuanHuyen() + "\"" + "}";
			} else {
				json += "{\"maQuanHuyen\":" + "\"" + listQuanHuyen.get(i).getMaQuanHuyen() + "\"" + ", \"tenQuanHuyen\" :" + "\"" + listQuanHuyen.get(i).getTenQuanHuyen() + "\"" + "},";
			}
		}
		json += "]";
		
		return json;
		
	}
	
	// QuanHuyen Json
	@RequestMapping(value= "selectphuong/{maQuanHuyen}", method= RequestMethod.GET,  produces= "text/plain;charset=UTF-8")
	@ResponseBody // khi return ko tráº£ vá»� trang jsp mÃ Â  tráº£ vá»� code html
	public String selectPhuong(@PathVariable String maQuanHuyen) {
		List<PhuongPikalong> listPhuong= phuongPikalongService.listPhuong(maQuanHuyen);
		
		String json = "[";
		
		for(int i= 0; i < listPhuong.size(); i++) {
			if(i == listPhuong.size() - 1) {
				json += "{\"maPhuong\": \"" + listPhuong.get(i).getMaPhuong() + "\", " + "\"tenPhuong\": \"" + listPhuong.get(i).getTenPhuong() + "\"}" ;
			}
			else {
				json += "{\"maPhuong\": \"" + listPhuong.get(i).getMaPhuong() + "\", " + "\"tenPhuong\": \"" + listPhuong.get(i).getTenPhuong() + "\"}" + "," ;
			}
		}
		json+= "]";
		
		return json;
	}

	
	@RequestMapping(value= "editform/{maNv}", method= RequestMethod.GET)
	public String editform(Model model, @PathVariable String maNv) {
		getNhanVien = hoSoNhanVienPikalongService.getEdit(maNv);
		model.addAttribute("formHosopkl", hoSoNhanVienPikalongService.getEdit(maNv));
		model.addAttribute("listQuocTich", quocTichPikalongService.listQuocTich());
		model.addAttribute("listThanhPho",  thanhPhoPikalongService.listTinhThanh());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listChucDanh", chucDanhService.findAll());
		return"QuanTriNhanSuPikalong/ThongTinHoSo/thongtinhosoeditform";
	}
	
	@RequestMapping(value= "update", method= RequestMethod.POST)
	public String editSave(@ModelAttribute("formHosopkl") HoSoNhanVienPikalong hoSoNhanVienPikalong, 
			BindingResult result, @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		hoSoNhanVienPikalong.setAvatar(getNhanVien.getAvatar());
		
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		File fileUpload = new File(path);
		 if (!fileUpload.exists()) {
			 fileUpload.mkdir();
		 }
		String filename = file.getOriginalFilename();
		if(!filename.isEmpty()) { // khi ngÆ°á»�i dÃ¹ng ko thay Ä‘á»•i áº£nh Ä‘áº¡i diá»‡n
		System.out.println(path + " " + filename);
		byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename))); 
	    hoSoNhanVienPikalong.setAvatar(filename);
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
		}
		hoSoNhanVienPikalongService.update(hoSoNhanVienPikalong);
		return "redirect:/quantrinhansu/hosonhanvien/";
	}
	

	
	
	// page view
	@RequestMapping("view/{maNv}")
	public String view(@PathVariable String maNv, Model model) {
		model.addAttribute("maNv", maNv);
		return "QuanTriNhanSuPikalong/ThongTinHoSo/view";
	}
	
	// page Há»“ sÆ¡ chi tiáº¿t
	@RequestMapping("hosochitiet/{maNv}")
	public String details(@PathVariable String maNv, Model model) {
		model.addAttribute("hoSoNhanVien", hoSoNhanVienPikalongService.getEdit(maNv));
		model.addAttribute("thongTinGiaDinh", giaDinhPikalongService.viewOne(maNv));
		model.addAttribute("thongTinBangCap", bangCapPikalongService.viewOne(maNv));
		return "QuanTriNhanSuPikalong/ThongTinHoSo/hosochitiet";
	}
	
	// export flie excel
	@RequestMapping("exportexcel/{maNv}")
	public ModelAndView exportExcelFile(@PathVariable String maNv, Model model) {
		
		return new ModelAndView("HoSoNhanVienExcelId", "hoSoNhanVien", hoSoNhanVienPikalongService.getEdit(maNv));
	}
}
