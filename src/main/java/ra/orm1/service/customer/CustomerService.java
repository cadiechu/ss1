package ra.orm1.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.orm1.model.Customer;
import ra.orm1.reppsitory.CusRepo;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CusRepo cusRepo;
    @Autowired
    private ICustomerService customerService;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        return customers;
    }

    @Override
    public Page<Customer> findAllByName(String name, Pageable pageable) {
        Page<Customer> customers = customerService.findAllByName(name, pageable);
        return customers;
    }

    @Override
    public Customer save(Customer customer) {
        return cusRepo.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        cusRepo.deleteById(id);
    }
}
