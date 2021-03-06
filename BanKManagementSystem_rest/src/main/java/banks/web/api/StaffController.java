package banks.web.api;

import java.util.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/staffs")
	public ResponseEntity<List<Staff>> getAllStaffs() {
		List<Staff> staff = staffService.getAllStaff();
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}

	@GetMapping("/getStaff/{id}") // http://localhost:8080/getStaffById?staffId=1
	public ResponseEntity<Staff> getStaffById(@PathVariable("id") Integer staffId) {
		Staff st2 = staffService.getStaffById(staffId);
		return new ResponseEntity<>(st2, HttpStatus.OK);
	}

//	@GetMapping("/checkLogin/{username},{password}") // http://localhost:8080/getStaffById?staffId=1
//	public ResponseEntity<Staff> checkLogin(@PathVariable("username") String username,
//			@PathVariable("password") String password) {
//		Staff st2 = staffService.checkLogin(username, password);
//		return new ResponseEntity<>(st2, HttpStatus.OK);
//	}

	@DeleteMapping("/staff/{id}")
	public ResponseEntity<String> deleteStaff(@PathVariable("id") Integer staffId) {
		staffService.deleteStaff(staffId);
		return new ResponseEntity<>("Staff with ID :" + staffId + " deleted successfully", HttpStatus.OK);
	}

	@PostMapping(path = "/staff", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff emp) {
        return new ResponseEntity<>(staffService.addStaff(emp), HttpStatus.CREATED);
    }

	
    @PutMapping(consumes = "application/json", produces = "application/json", path = "/employee")
    public ResponseEntity<Staff> updateStaff(@RequestBody Staff emp) {
        return new ResponseEntity<>(staffService.updateStaff(emp), HttpStatus.CREATED);
    }
}
