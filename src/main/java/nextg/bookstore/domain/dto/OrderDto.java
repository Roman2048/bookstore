package nextg.bookstore.domain.dto;

import java.time.LocalDate;
import java.util.Set;

public class OrderDto {

    private Long id;

    private String clientFullName;

    private Set<String> books;

    private LocalDate creationDate;

    private LocalDate completionDate;

    private Boolean isCompleted;

    public OrderDto() {}

    public OrderDto(Long id,
                    String clientFullName,
                    Set<String> books,
                    LocalDate creationDate,
                    LocalDate completionDate,
                    Boolean isCompleted) {
        this.id = id;
        this.clientFullName = clientFullName;
        this.books = books;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public Set<String> getBooks() {
        return books;
    }

    public void setBooks(Set<String> books) {
        this.books = books;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
