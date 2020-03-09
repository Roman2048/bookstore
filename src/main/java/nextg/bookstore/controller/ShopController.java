package nextg.bookstore.controller;

import nextg.bookstore.domain.Shop;
import nextg.bookstore.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shops")
public class ShopController {

    ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(shopService.getOneShop(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.createShop(shop));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Shop shop, @PathVariable Long id) {
        return ResponseEntity.ok(shopService.updateShop(id, shop));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.ok().build();
    }
}