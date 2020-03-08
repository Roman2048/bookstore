package nextg.bookstore.domain.dto;

import java.util.HashSet;
import java.util.Set;

public class BookDto {

    private Long id;

    private String title;

    private Integer publishYear;

    private String annotation;

    private Set<String> authorsFullNames = new HashSet<>();

    public BookDto() {
    }

    public BookDto(Long id, String title, Integer publishYear, String annotation, Set<String> authorsFullNames) {
        this.id = id;
        this.title = title;
        this.publishYear = publishYear;
        this.annotation = annotation;
        this.authorsFullNames = authorsFullNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Set<String> getAuthorsFullNames() {
        return authorsFullNames;
    }

    public void setAuthorsFullNames(Set<String> authorsFullNames) {
        this.authorsFullNames = authorsFullNames;
    }
}
