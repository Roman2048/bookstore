package nextg.bookstore.controller;

import nextg.bookstore.service.ClientsAndOrdersService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("clientsAndOrders")
public class ClientAndOrdersController {

    ClientsAndOrdersService clientsAndOrdersService;

    public ClientAndOrdersController(ClientsAndOrdersService clientsAndOrdersService) {
        this.clientsAndOrdersService = clientsAndOrdersService;
    }

    @GetMapping
    public ResponseEntity<?> getClientsAndOrders(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
            @RequestParam(required = false) Boolean onlyCompleted) {
        return ResponseEntity.ok(clientsAndOrdersService.getClientsAndOrders(from, to, onlyCompleted));
    }
}
