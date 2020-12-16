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

	@GetMapping("/spendAccounts")
	public ResponseEntity<List<SpendAccount>> getAllSpendAccounts() {
		List<SpendAccount> spendAccount = spendAccountService.getAllSpendAccounts();
		return new ResponseEntity<>(spendAccount, HttpStatus.OK);
	}

	@PutMapping("/spendAccount")
	public ResponseEntity<SpendAccount> updateSpendAccount(@RequestBody SpendAccount spendAccount) {

		SpendAccount sp = spendAccountService.updateSpendAccount(spendAccount);
		return new ResponseEntity<>(sp, HttpStatus.OK);
	}

	@GetMapping("/getSpendAccount/{id}")
	public ResponseEntity<SpendAccount> getSpendAccountById(
			@PathVariable("id") Integer spendAccountId) {
		SpendAccount sp2 = spendAccountService.getSpendAccountById(spendAccountId);
		return new ResponseEntity<>(sp2, HttpStatus.OK);
	}

	@DeleteMapping("/spendAccount/{id}")
	public ResponseEntity<String> deleteSpendAccounts(
			@PathVariable("id") Integer spendAccountId) {

		spendAccountService.deleteSpendAccounts(spendAccountId);
		return new ResponseEntity<>("SpendAccount with ID :" + spendAccountId + " deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/spendAccount")
	public ResponseEntity<SpendAccount> addSpendAccount(@RequestBody SpendAccount spendAccount) {

		SpendAccount sp3 = spendAccountService.addSpendAccount(spendAccount);
		return new ResponseEntity<>(sp3, HttpStatus.OK);
	}
}
