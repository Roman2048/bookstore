package nextg.bookstore.service;

import nextg.bookstore.domain.Sale;
import nextg.bookstore.domain.Shop;
import nextg.bookstore.domain.dto.ShopAndSalesDto;
import nextg.bookstore.repository.PriceTagRepository;
import nextg.bookstore.repository.SaleRepository;
import nextg.bookstore.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ShopsAndSalesService {

    ShopRepository shopRepository;
    SaleRepository saleRepository;
    PriceTagRepository priceTagRepository;

    public ShopsAndSalesService(ShopRepository shopRepository, SaleRepository saleRepository, PriceTagRepository priceTagRepository) {
        this.shopRepository = shopRepository;
        this.saleRepository = saleRepository;
        this.priceTagRepository = priceTagRepository;
    }

    public List<ShopAndSalesDto> getShopsAndSales(LocalDate from, LocalDate to, Set<Long> shopsIds) {
        Iterable<Shop> shops = getShops(from, to, shopsIds);
        List<Shop> shopsList = new ArrayList<>();
        shops.forEach(shopsList::add);
        List<ShopAndSalesDto> result = new ArrayList<>();
        computeDtoList(shopsList, result);
        return result;
    }

    private void computeDtoList(List<Shop> shopsList, List<ShopAndSalesDto> result) {
        for (Shop s : shopsList) {
            ShopAndSalesDto dto = new ShopAndSalesDto();
            dto.setShopId(s.getId());
            dto.setShopAddress(s.getAddress());
            List<Sale> byShop = saleRepository.findByShop(s);
            long count = byShop.stream().filter(sale -> sale.getShop().getId().equals(s.getId())).count();
            dto.setSoldBooksCount((int) count);
            result.add(dto);
        }
    }

    private Iterable<Shop> getShops(LocalDate from, LocalDate to, Set<Long> shopsIds) {
        if (from == null) { from = LocalDate.of(2000, 1, 1); }
        if (to == null) { to = LocalDate.now(); }
        Iterable<Shop> shops;
        if (shopsIds == null) {
            shops = shopRepository.findAll();
        } else {
            shops = shopRepository.findAllById(shopsIds);
        }
        return shops;
    }
}
