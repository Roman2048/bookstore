package nextg.bookstore.domain.dto;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ClientsAndOrdersDto {

    private Long clientId;

    private String clientName;

    private List<Map<String, Object>> ordersOfClient;

    public ClientsAndOrdersDto() {}

    public ClientsAndOrdersDto(Long clientId, String clientName, List<Map<String, Object>> ordersOfClient) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.ordersOfClient = ordersOfClient;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Map<String, Object>> getOrdersOfClient() {
        return ordersOfClient;
    }

    public void setOrdersOfClient(List<Map<String, Object>> ordersOfClient) {
        this.ordersOfClient = ordersOfClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsAndOrdersDto that = (ClientsAndOrdersDto) o;
        return clientId.equals(that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}
