package ra.orm1.reppsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.orm1.model.Book;


public interface IBookRepo extends JpaRepository<Book,Long> {
}
