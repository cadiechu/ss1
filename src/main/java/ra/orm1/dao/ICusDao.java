package ra.orm1.dao;

import ra.orm1.model.Customer;

import java.util.List;

public class ICusDao {
    List<Customer> findAll();
    Customer findById(Long id);
    void deleteById(Long id);
    void save(Customer customer);
}
