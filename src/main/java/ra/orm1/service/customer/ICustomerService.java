package ra.orm1.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.orm1.model.Customer;
import ra.orm1.reppsitory.CusRepo;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByName(String name, Pageable pageable);

    Customer save(Customer customer);

    void deleteById(Long id);
}
