package banks.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import banks.Staff;
import banks.data.StaffRepository;
import banks.DepositAccount;
import banks.data.DepositAccountRepository;
import banks.SpendAccount;
import banks.data.SpendAccountRepository;
import banks.Customer;
import banks.data.CustomerRepository;

@Service
public class SpendAccountService {
	@Autowired
	private SpendAccountRepository spendAccountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StaffRepository staffRepository;

	public List<SpendAccount> getAllSpendAccounts() {

		return (List<SpendAccount>) spendAccountRepository.findAll();
	}

	public SpendAccount getSpendAccountById(Integer id) {
		Optional<SpendAccount> optSpendAccount = spendAccountRepository.findById(id);
		if (optSpendAccount.isPresent()) {
			return optSpendAccount.get();
		}
		return null;
	}

	public SpendAccount addSpendAccount(SpendAccount spendAccount) {

		Customer cus = customerRepository.findById(spendAccount.getCustomer().getId()).orElse(null);
		if (null == cus) {
			cus = new Customer();
		}
		cus.setName(spendAccount.getCustomer().getName());
		spendAccount.setCustomer(cus);

		Staff staff = staffRepository.findById(spendAccount.getStaff().getId()).orElse(null);
		if (null == staff) {
			staff = new Staff();
		}
		staff.setName(spendAccount.getStaff().getName());
		spendAccount.setStaff(staff);

		return spendAccountRepository.save(spendAccount);
	}

	public SpendAccount editSpendAccounts(SpendAccount entity) {

		return spendAccountRepository.save(entity);
	}

	public void deleteSpendAccounts(Integer id) {

		spendAccountRepository.deleteById(id);
	}
}
