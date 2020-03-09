package nextg.bookstore.controller;

import nextg.bookstore.service.ShopsAndSalesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("shopsAndSales")
public class ShopsAndSalesController {

    ShopsAndSalesService shopsAndSalesService;

    public ShopsAndSalesController(ShopsAndSalesService shopsAndSalesService) {
        this.shopsAndSalesService = shopsAndSalesService;
    }

    @GetMapping
    public ResponseEntity<?> getShopsAndSales(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
            @RequestParam(required = false) Set<Long> shopsIds) {
        return ResponseEntity.ok(shopsAndSalesService.getShopsAndSales(from, to, shopsIds));
    }
}
