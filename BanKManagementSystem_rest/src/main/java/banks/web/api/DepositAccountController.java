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

import banks.data.DepositAccountRepository;
import banks.DepositAccount;
import banks.web.service.DepositAccountService;

@RestController
public class DepositAccountController {
	@Autowired
	private DepositAccountService depositAccountService;

	@GetMapping("/depositAccounts")
	public ResponseEntity<List<DepositAccount>> getAllDepositAccounts() {
		List<DepositAccount> depositAccount = depositAccountService.getAllDepositAccounts();
		return new ResponseEntity<>(depositAccount, HttpStatus.OK);
	}

	@PutMapping("/depositAccount")
	public ResponseEntity<DepositAccount> updateDepositAccount(@RequestBody DepositAccount depositAccount) {

		DepositAccount depAcc = depositAccountService.updateDepositAccount(depositAccount);
		return new ResponseEntity<>(depAcc, HttpStatus.OK);
	}

	@GetMapping("/getDepositAccount/{id}")
	public ResponseEntity<DepositAccount> getDepositAccountById(
			@PathVariable("id") Integer depositAccountId){
		DepositAccount depositAccount = depositAccountService.getDepositAccountById(depositAccountId);
		return new ResponseEntity<>(depositAccount, HttpStatus.OK);
	}

	@DeleteMapping("/depositAccount/{id}")
	public ResponseEntity<String> deleteDepositAccount(
			@PathVariable("id") Integer depositAccountId){

		depositAccountService.deleteDepositAccount(depositAccountId);
		return new ResponseEntity<>("DepositAccount with ID :" + depositAccountId + " deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/depositAccount")
	public ResponseEntity<DepositAccount> saveDepositAccount(@RequestBody DepositAccount depositAccount) {

		DepositAccount depAcc2 = depositAccountService.addDepositAccount(depositAccount);
		return new ResponseEntity<>(depAcc2, HttpStatus.OK);
	}
}
