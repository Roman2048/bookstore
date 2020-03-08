package nextg.bookstore.controller;

import nextg.bookstore.domain.Client;
import nextg.bookstore.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getOneClient(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Long id) {
        return ResponseEntity.ok(clientService.updateClient(id, client));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
