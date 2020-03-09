package nextg.bookstore.repository;

import nextg.bookstore.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.creationDate BETWEEN :from AND :to")
    Iterable<Order> findAllWithinDate(@Param("from") LocalDate from, @Param("to") LocalDate to);

    @Query("SELECT o FROM Order o WHERE o.creationDate BETWEEN :from AND :to AND o.completed = :completed")
    Iterable<Order> findAllWithinDate(@Param("from") LocalDate from,
                                      @Param("to") LocalDate to,
                                      @Param("completed") Boolean completed);
}
