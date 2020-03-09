package nextg.bookstore.repository;

import nextg.bookstore.domain.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Long> {
}
