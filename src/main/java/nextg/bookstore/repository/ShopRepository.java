package nextg.bookstore.repository;

import nextg.bookstore.domain.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
