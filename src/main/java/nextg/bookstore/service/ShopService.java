package nextg.bookstore.service;

import nextg.bookstore.domain.Book;
import nextg.bookstore.domain.Shop;
import nextg.bookstore.domain.dto.ShopDto;
import nextg.bookstore.exceptions.ShopNotFoundException;
import nextg.bookstore.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopDto> getAllShops() {
        List<ShopDto> shopsDto = new ArrayList<>();
        for (Shop s : shopRepository.findAll()) {
            shopsDto.add(shopToDto(s));
        }
        return shopsDto;
    }

    public ShopDto getOneShop(Long id) {
        Shop s = shopRepository.findById(id).orElseThrow(ShopNotFoundException::new);
        return shopToDto(s);
    }

    public ShopDto createShop(Shop shop) {
        return shopToDto(shopRepository.save(shop));
    }

    public ShopDto updateShop(Long id, Shop shop) {
        if (!shopRepository.existsById(id)) {
            throw new ShopNotFoundException();
        } else {
            shop.setId(id);
            return shopToDto(shopRepository.save(shop));
        }
    }

    public void deleteShop(Long id) {
        if (!shopRepository.existsById(id)) {
            throw new ShopNotFoundException();
        } else {
            shopRepository.deleteById(id);
        }
    }

    private ShopDto shopToDto(Shop s) {
        return new ShopDto(
                s.getId(),
                s.getAddress(),
                s.getBooks().stream().map(Book::getTitle).collect(Collectors.toSet())
        );
    }
}