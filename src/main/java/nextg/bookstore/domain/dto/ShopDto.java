package nextg.bookstore.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class ShopDto {

    private Long id;

    private String address;

    private List<String> books = new ArrayList<>();

    public ShopDto() {}

    public ShopDto(Long id, String address, List<String> books) {
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

    public List<String>getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
