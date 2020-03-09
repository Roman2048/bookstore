package nextg.bookstore.repository;

import nextg.bookstore.domain.Sale;
import nextg.bookstore.domain.Shop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Long> {
    List<Sale> findByShop(Shop shop);
}
