package banks.data;

import org.springframework.data.repository.CrudRepository;
import banks.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> {
	Staff findByUsernameAndPassword (String username , String password);
}
