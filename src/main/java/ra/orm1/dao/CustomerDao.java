package ra.orm1.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
@Component
public class CustomerDao implements ICusDao {
    public class CustomerDao implements ICusDao {
        @PersistenceContext
        private EntityManager entityManager;
        @Override
        public List<Customer> findAll() {
            return entityManager.createQuery("select C from Customer C", Customer.class).getResultList();
        }

        @Override
        public Customer findById(Long id) {
            return entityManager.find(Customer.class, id);
        }

        @Transactional
        @Override
        public void deleteById(Long id) {
            entityManager.remove(findById(id));
        }

        @Transactional
        @Override
        public void save(Customer customer) {
            if (customer.getId() != null) {
                // Add new
                entityManager.persist(customer);
            } else {
                // Update
                entityManager.merge(customer);
            }
        }

    }
