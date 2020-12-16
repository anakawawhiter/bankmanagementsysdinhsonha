package bankmanagementsystem;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;
import model.Staff;

@Slf4j
@Controller
@RequestMapping("/staff")
public class StaffCotroller {
	private RestTemplate rest = new RestTemplate();

	@GetMapping("/viewAll")
	public String showDesignForm(Model model) {
		List<Staff> staffs = Arrays.asList(rest.getForObject("http://localhost:8080/staffs", Staff[].class));
		model.addAttribute("staffs", staffs);
		System.out.println(staffs);
		return "viewall";
	}

	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("staff", new Staff());
		return "search";
	}

	@PostMapping("/search")
	public String StaffView(@RequestParam("id") String id, Model model) {
		Staff staff = rest.getForObject("http://localhost:8080/getStaff/" + id, Staff.class);
		model.addAttribute("staff", staff);
		System.out.println(staff);
		return "staffview";
	}

	@PostMapping("/searchtodel")
	public String searchtodel(@RequestParam("id") String id, Model model) {
		Staff staff = rest.getForObject("http://localhost:8080/getStaff/" + id, Staff.class);
		model.addAttribute("staff", staff);
		System.out.println(staff);
		return "viewtodelete";
	}

	@PostMapping("/edit/{id}")
	public String DoUpdate(@PathVariable("id")String id, @RequestParam("name") String name,
			@RequestParam("idstaff") String idstaff, @RequestParam("idcard") String idcard,
			@RequestParam("level") String level, @RequestParam("position") String position,
			@RequestParam("experience") Integer experience, @RequestParam("dob") String dob,
			@RequestParam("address") String address, @RequestParam("phonenumber") String phonenumber, Model model) {

		Staff st = rest.getForObject("http://localhost:8080/getStaff/" + id, Staff.class);
		st.setName(name);
		st.setAddress(address);
		st.setIdstaff(idstaff);
		st.setDob(dob);
		st.setLevel(level);
		st.setPosition(position);
		st.setIdcard(idcard);
		st.setExperience(experience);
		st.setPhonenumber(phonenumber);
		System.out.println(st);
		rest.postForObject("http://localhost:8080/staff", st, Staff.class);
		List<Staff> staffs = Arrays.asList(rest.getForObject("http://localhost:8080/staffs", Staff[].class));
		model.addAttribute("staffs", staffs);
		System.out.println(staffs);
		return "viewall";
	}

	@GetMapping("/del")
	public String del(Model model) {
		model.addAttribute("staff", new Staff());
		return "searchtodelete";
	}

	@PostMapping("/delete")
	public String doDeleteCustomer(@RequestParam("id") String id, Model model) {
		rest.delete("http://localhost:8080/staff/" + id);
		List<Staff> staffs = Arrays.asList(rest.getForObject("http://localhost:8080/staffs", Staff[].class));
		model.addAttribute("staffs", staffs);
		System.out.println(staffs);
		return "viewall";
	}

	@GetMapping("/add")
	public String addstaff(Model model) {
		model.addAttribute("staff", new Staff());
		return "addstaff";
	}

	@PostMapping("/ok")
	public String ok(Model model) {
		return "redirect:/";
	}

	@PostMapping("/add")
	public String addStaff(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("idstaff") String idstaff, @RequestParam("idcard") String idcard,
			@RequestParam("level") String level, @RequestParam("position") String position,
			@RequestParam("experience") Integer experience, @RequestParam("dob") String dob,
			@RequestParam("address") String address, @RequestParam("phonenumber") String phonenumber, Model model) {
		System.out.println(id + name + dob);
		Staff st = new Staff();
		st.setId(id);
		st.setName(name);
		st.setAddress(address);
		st.setIdstaff(idstaff);
		st.setDob(dob);
		st.setLevel(level);
		st.setPosition(position);
		st.setIdcard(idcard);
		st.setExperience(experience);
		st.setPhonenumber(phonenumber);
		System.out.println(st);
		System.out.println(st.toString());
		rest.postForObject("http://localhost:8080/staff", st, Staff.class);
		List<Staff> staffs = Arrays.asList(rest.getForObject("http://localhost:8080/staffs", Staff[].class));
		model.addAttribute("staffs", staffs);
		System.out.println(staffs);
		return "viewall";
	}
}
