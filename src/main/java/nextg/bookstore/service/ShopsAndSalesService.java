package nextg.bookstore.service;

import nextg.bookstore.domain.dto.ShopAndSalesDto;
import nextg.bookstore.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class ShopsAndSalesService {

    ShopRepository shopRepository;

    public ShopsAndSalesService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopAndSalesDto> getShopsAndSales(LocalDate from, LocalDate to, Set<Long> shopsIds) {
        return null;
    }
}
