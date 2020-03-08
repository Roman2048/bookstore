package nextg.bookstore.service;

import nextg.bookstore.domain.Client;
import nextg.bookstore.domain.Order;
import nextg.bookstore.domain.dto.ClientDto;
import nextg.bookstore.exceptions.ClientNotFoundException;
import nextg.bookstore.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDto> getAllClients() {
        List<ClientDto> clientsDto = new ArrayList<>();
        for (Client c : clientRepository.findAll()) {
            clientsDto.add(clientToDto(c));
        }
        return clientsDto;
    }

    public ClientDto getOneClient(Long id) {
        Client c = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        return clientToDto(c);
    }

    public ClientDto createClient(Client client) {
        return clientToDto(clientRepository.save(client));
    }

    public ClientDto updateClient(Long id, Client client) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        } else {
            client.setId(id);
            return clientToDto(clientRepository.save(client));
        }
    }

    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        } else {
            clientRepository.deleteById(id);
        }
    }

    private ClientDto clientToDto(Client c) {
        return new ClientDto(
                c.getId(),
                c.getFullName(),
                c.getPhone(),
                c.getOrders().stream()
                        .map(Order::getId)
                        .map(Objects::toString)
                        .collect(Collectors.toSet())
        );
    }
}
