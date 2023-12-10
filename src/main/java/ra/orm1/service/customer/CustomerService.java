package ra.orm1.service.customer;
import org.springframework.stereotype.Service;
import ra.orm1.model.Customer;
import ra.orm1.repository.CustomerRepo;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    public CustomerRepo customerRepo;

    public Customer getUserById(Long id) {
        Optional<Customer> rs = customerRepo.findById(id);
        return rs.get();
    }

    public Customer save(Customer cus) {
        return customerRepo.save(cus);
    }

    public void delete(Long id) {
        customerRepo.deleteById(id);
    }

    public List<Customer> findAllUser() {
        return (List<Customer>) customerRepo.findAll();
    }

}
