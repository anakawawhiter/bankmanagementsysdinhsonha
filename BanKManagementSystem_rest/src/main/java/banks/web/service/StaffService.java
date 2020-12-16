package banks.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import banks.Staff;
import banks.data.StaffRepository;
import banks.Customer;
import banks.DepositAccount;
import banks.data.CustomerRepository;
import banks.data.DepositAccountRepository;
import banks.SpendAccount;
import banks.data.SpendAccountRepository;
@Service
public class StaffService {
	@Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return (List<Staff>) staffRepository.findAll();
    }
	public Staff getStaffById(Integer id) {
		Optional<Staff> optCustomer = staffRepository.findById(id);
		if (optCustomer.isPresent()) {
			return optCustomer.get();
		}
		return null;
	}    
//	public Staff checkLogin(String username, String password) {
//		Staff optCustomer = staffRepository.findByUsernameAndPassword(username,password);
//		if (optCustomer!=null) {
//			return optCustomer;
//		}
//		return null;
//	}    
	public Staff addStaff(Staff staff) {

		return staffRepository.save(staff);
	}	
    public Staff updateStaff(Staff staff) {
    	 
        return staffRepository.save(staff);
    }
 
    public void deleteStaff(Integer id) {
 
    	staffRepository.deleteById(id);
    }
}
