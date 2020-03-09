package nextg.bookstore.controller;

import nextg.bookstore.domain.Order;
import nextg.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOneOrder(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Long id) {
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}