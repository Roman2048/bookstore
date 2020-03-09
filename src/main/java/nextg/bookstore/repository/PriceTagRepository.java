package nextg.bookstore.repository;

import nextg.bookstore.domain.PriceTag;
import org.springframework.data.repository.CrudRepository;

public interface PriceTagRepository extends CrudRepository<PriceTag, Long> {
}
