package nextg.bookstore.service;

import nextg.bookstore.domain.Author;
import nextg.bookstore.domain.Book;
import nextg.bookstore.domain.dto.AuthorDto;
import nextg.bookstore.domain.dto.BookDto;
import nextg.bookstore.exceptions.AuthorNotFoundException;
import nextg.bookstore.exceptions.BookNotFoundException;
import nextg.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        List<AuthorDto> authorsDto = new ArrayList<>();
        for (Author a : authors) {
            authorsDto.add(new AuthorDto(
                    a.getId(),
                    a.getFullName(),
                    a.getYearOfBirth(),
                    a.getBooks().stream()
                            .map(Book::getTitle)
                            .collect(Collectors.toSet())
            ));
        }
        return authorsDto;
    }

    public AuthorDto getOneAuthor(Long id) {
        Author a = authorRepository
                .findById(id)
                .orElseThrow(AuthorNotFoundException::new);
        return new AuthorDto(
                a.getId(),
                a.getFullName(),
                a.getYearOfBirth(),
                a.getBooks().stream()
                        .map(Book::getTitle)
                        .collect(Collectors.toSet())
        );
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException();
        } else {
            author.setId(id);
            return authorRepository.save(author);
        }
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException();
        } else {
            authorRepository.deleteById(id);
        }
    }
}
