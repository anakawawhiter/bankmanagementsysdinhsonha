package banks.data;

import org.springframework.data.repository.CrudRepository;
import banks.Customer;
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
