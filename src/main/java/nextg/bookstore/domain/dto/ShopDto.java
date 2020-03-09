package nextg.bookstore.domain.dto;

import java.util.HashSet;
import java.util.Set;

public class ShopDto {

    private Long id;

    private String address;

    private Set<String> books = new HashSet<>();

    public ShopDto() {}

    public ShopDto(Long id, String address, Set<String> books) {
        this.id = id;
        this.address = address;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getBooks() {
        return books;
    }

    public void setBooks(Set<String> books) {
        this.books = books;
    }
}
