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

import banks.data.CustomerRepository;
import banks.Customer;
import banks.DepositAccount;
import banks.web.service.CustomerService;
import banks.web.service.DepositAccountService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/getCustomer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customer = customerService.getAllCustomers();
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomers(@RequestBody Customer customer) {
		Customer cus = customerService.editCustomers(customer);
		return new ResponseEntity<>(cus, HttpStatus.OK);
	}

	@GetMapping( "/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(
			@PathVariable("id") Integer customerId){
		Customer cus2 = customerService.getCustomerById(customerId);
		return new ResponseEntity<>(cus2, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomers(
			@PathVariable("id") Integer customerId){

		customerService.deleteCustomers(customerId);
		return new ResponseEntity<>("Customer with ID :" + customerId + " deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {

		Customer cus2 = customerService.addCustomer(customer);
		return new ResponseEntity<>(cus2, HttpStatus.OK);
	}
}

