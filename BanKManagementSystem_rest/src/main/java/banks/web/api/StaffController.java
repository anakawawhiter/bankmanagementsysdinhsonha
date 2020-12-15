package banks.web.api;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import banks.Staff;
import banks.data.StaffRepository;
import banks.DepositAccount;
import banks.data.DepositAccountRepository;
import banks.SpendAccount;
import banks.data.SpendAccountRepository;
import banks.Customer;
import banks.data.CustomerRepository;
import banks.web.service.StaffService;
@RestController
public class StaffController {
	@Autowired
	private StaffService staffService;

	@GetMapping("/getStaff")
	public ResponseEntity<List<Staff>> getAllStaffs() {
		List<Staff> staff = staffService.getAllStaffs();
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}

	@PutMapping("/updateStaff")
	public ResponseEntity<Staff> updateStaffs(@RequestBody Staff staff) {
		Staff st = staffService.editStaffs(staff);
		return new ResponseEntity<>(st, HttpStatus.OK);
	}

	@GetMapping("/getStaffById/{id}")//http://localhost:8080/getStaffById?staffId=1
	public ResponseEntity<Staff> getStaffById(
			@PathVariable("id") Integer staffId) {
		Staff st2 = staffService.getStaffById(staffId);
		return new ResponseEntity<>(st2, HttpStatus.OK);
	}
	@GetMapping("/checkLogin/{username},{password}")//http://localhost:8080/getStaffById?staffId=1
	public ResponseEntity<Staff> checkLogin(
			@PathVariable("username") String username, @PathVariable ("password") String password){
		Staff st2 = staffService.checkLogin(username,password);
		return new ResponseEntity<>(st2, HttpStatus.OK);
	}
	@DeleteMapping("/deleteStaff/{id}")
	public ResponseEntity<String> deleteStaffs(
			@PathVariable("id") Integer staffId) {
		staffService.deleteStaffs(staffId);
		return new ResponseEntity<>("Staff with ID :" + staffId + " deleted successfully", HttpStatus.OK);
	}
	@PostMapping("/saveStaff")
	public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff) {

		Staff st3 = staffService.addStaff(staff);
		return new ResponseEntity<>(st3, HttpStatus.OK);
	}
}

