package nextg.bookstore.domain.dto;

import java.util.Set;

public class ClientDto {

    private Long id;

    private String fullName;

    private String phone;

    private Set<String> orders;

    public ClientDto() {}

    public ClientDto(Long id, String fullName, String phone, Set<String> orders) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<String> getOrders() {
        return orders;
    }

    public void setOrders(Set<String> orders) {
        this.orders = orders;
    }
}
