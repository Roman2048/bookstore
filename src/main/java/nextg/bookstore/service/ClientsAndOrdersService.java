package nextg.bookstore.service;

import nextg.bookstore.domain.Order;
import nextg.bookstore.domain.dto.ClientsAndOrdersDto;
import nextg.bookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ClientsAndOrdersService {

    OrderRepository orderRepository;

    public ClientsAndOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Set<ClientsAndOrdersDto> getClientsAndOrders(LocalDate from, LocalDate to, Boolean completed) {
        if (from == null) { from = LocalDate.of(2000, 1, 1); }
        if (to == null) { to = LocalDate.now(); }
        if (completed == null) { completed = false; }
        List<Order> orders = getOrdersFromDb(from, to, completed);
        Set<ClientsAndOrdersDto> result = new LinkedHashSet<>();
        filterOrders(completed, orders, result);
        return result;
    }

    private void filterOrders(Boolean completed, List<Order> orders, Set<ClientsAndOrdersDto> result) {
        for (Order order : orders) {
            List<Map<String, Object>> ordersOfClient = new ArrayList<>();
            for (Order o: orders) {
                if (order.getClient().getId().equals(o.getClient().getId())) {
                    ordersOfClient.add(getOrderDetalis(completed, o));
                }
            }
            result.add(new ClientsAndOrdersDto(
                    order.getClient().getId(),
                    order.getClient().getFullName(),
                    ordersOfClient));
        }
    }

    private List<Order> getOrdersFromDb(LocalDate from, LocalDate to, Boolean completed) {
        List<Order> orders = new ArrayList<>();
        if (completed) {
            orderRepository.findAllWithinDate(from, to, true).forEach(orders::add);
        } else {
            orderRepository.findAllWithinDate(from, to).forEach(orders::add);
        }
        return orders;
    }

    private Map<String, Object> getOrderDetalis(Boolean completed, Order o) {
        Map<String, Object> lineItem = new HashMap<>();
        lineItem.put("orderId", o.getId());
        lineItem.put("booksCount", o.getBooks().size());
        lineItem.put("creationDate", o.getCreationDate());
        lineItem.put("completionDate", o.getCompletionDate());
        if (!completed) { lineItem.put("completed", o.getCompleted()); }
        return lineItem;
    }
}
