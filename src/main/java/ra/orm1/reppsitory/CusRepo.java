package ra.orm1.reppsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.orm1.model.Customer;
@Repository
public interface CusRepo extends JpaRepository<Customer, Long> {
}
