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
public class DepositAccountService {
	@Autowired
	private DepositAccountRepository depositAccountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StaffRepository staffRepository;

	public List<DepositAccount> getAllDepositAccounts() {

		return (List<DepositAccount>) depositAccountRepository.findAll();
	}

	public DepositAccount getDepositAccountById(Integer id) {
		Optional<DepositAccount> optDepositAccount = depositAccountRepository.findById(id);
		if (optDepositAccount.isPresent()) {
			return optDepositAccount.get();
		}
		return null;
	}

	public DepositAccount addDepositAccount(DepositAccount depositAccount) {

		Customer cus = customerRepository.findById(depositAccount.getCustomer().getId()).orElse(null);
		if (null == cus) {
			cus = new Customer();
		}
		cus.setName(depositAccount.getCustomer().getName());
		depositAccount.setCustomer(cus);

		Staff staff = staffRepository.findById(depositAccount.getStaff().getId()).orElse(null);
		if (null == staff) {
			staff = new Staff();
		}
		staff.setName(depositAccount.getStaff().getName());
		depositAccount.setStaff(staff);

		return depositAccountRepository.save(depositAccount);
	}

	public DepositAccount updateDepositAccount(DepositAccount entity) {

		return depositAccountRepository.save(entity);
	}

	public void deleteDepositAccount(Integer id) {

		depositAccountRepository.deleteById(id);
	}
}
