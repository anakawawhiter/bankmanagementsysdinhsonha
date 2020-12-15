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
import banks.SpendAccount;
import banks.web.service.SpendAccountService;

@RestController
public class SpendAccountController {
	@Autowired
	private SpendAccountService spendAccountService;

	@GetMapping("/getSpendAccount")
	public ResponseEntity<List<SpendAccount>> getAllSpendAccounts() {
		List<SpendAccount> spendAccount = spendAccountService.getAllSpendAccounts();
		return new ResponseEntity<>(spendAccount, HttpStatus.OK);
	}

	@PutMapping("/updateSpendAccount")
	public ResponseEntity<SpendAccount> updateSpendAccounts(@RequestBody SpendAccount spendAccount) {

		SpendAccount sp = spendAccountService.editSpendAccounts(spendAccount);
		return new ResponseEntity<>(sp, HttpStatus.OK);
	}

	@GetMapping("/getSpendAccountById/{id}")
	public ResponseEntity<SpendAccount> getSpendAccountById(
			@PathVariable("id") Integer spendAccountId) {
		SpendAccount sp2 = spendAccountService.getSpendAccountById(spendAccountId);
		return new ResponseEntity<>(sp2, HttpStatus.OK);
	}

	@DeleteMapping("/deleteSpendAccount/{id}")
	public ResponseEntity<String> deleteSpendAccounts(
			@PathVariable("id") Integer spendAccountId) {

		spendAccountService.deleteSpendAccounts(spendAccountId);
		return new ResponseEntity<>("SpendAccount with ID :" + spendAccountId + " deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/saveSpendAccount")
	public ResponseEntity<SpendAccount> saveSpendAccount(@RequestBody SpendAccount spendAccount) {

		SpendAccount sp3 = spendAccountService.addSpendAccount(spendAccount);
		return new ResponseEntity<>(sp3, HttpStatus.OK);
	}
}
