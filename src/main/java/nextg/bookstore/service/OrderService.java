package nextg.bookstore.service;

import nextg.bookstore.domain.Book;
import nextg.bookstore.domain.Order;
import nextg.bookstore.domain.dto.OrderDto;
import nextg.bookstore.exceptions.OrderNotFoundException;
import nextg.bookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getAllOrders() {
        List<OrderDto> ordersDto = new ArrayList<>();
        for (Order o : orderRepository.findAll()) {
            ordersDto.add(orderToDto(o));
        }
        return ordersDto;
    }

    public OrderDto getOneOrder(Long id) {
        Order o = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return orderToDto(o);
    }

    public OrderDto createOrder(Order order) {
        return orderToDto(orderRepository.save(order));
    }

    public OrderDto updateOrder(Long id, Order order) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException();
        } else {
            order.setId(id);
            return orderToDto(orderRepository.save(order));
        }
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException();
        } else {
            orderRepository.deleteById(id);
        }
    }

    private OrderDto orderToDto(Order o) {
        return new OrderDto(
                o.getId(),
                o.getClient().getFullName(),
                o.getBooks().stream().map(Book::getTitle).collect(Collectors.toSet()),
                o.getCreationDate(),
                o.getCompletionDate(),
                o.getCompleted()
        );
    }
}
