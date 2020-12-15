package banks.web.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import banks.Staff;
import banks.data.StaffRepository;
import banks.DepositAccount;
import banks.data.DepositAccountRepository;
import banks.SpendAccount;
import banks.data.SpendAccountRepository;
import banks.Customer;
import banks.data.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
	public Customer getCustomerById(Integer id) {
		Optional<Customer> optCustomer = customerRepository.findById(id);
		if (optCustomer.isPresent()) {
			return optCustomer.get();
		}
		return null;
	}    
    
	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}
    public Customer editCustomers(Customer entity) {
    	 
        return customerRepository.save(entity);
    }
 
    public void deleteCustomers(Integer id) {
 
    	customerRepository.deleteById(id);
    }
}
