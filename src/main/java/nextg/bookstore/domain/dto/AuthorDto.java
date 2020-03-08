package nextg.bookstore.domain.dto;

import java.util.HashSet;
import java.util.Set;

public class AuthorDto {

    private Long id;

    private String fullName;

    private Integer yearOfBirth;

    private Set<String> booksNames = new HashSet<>();

    public AuthorDto() {}

    public AuthorDto(Long id, String fullName, Integer yearOfBirth, Set<String> booksNames) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.booksNames = booksNames;
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

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Set<String> getBooksNames() {
        return booksNames;
    }

    public void setBooksNames(Set<String> booksNames) {
        this.booksNames = booksNames;
    }
}
