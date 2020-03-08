package nextg.bookstore.service;

import nextg.bookstore.domain.Author;
import nextg.bookstore.domain.Book;
import nextg.bookstore.domain.dto.BookDto;
import nextg.bookstore.exceptions.BookNotFoundException;
import nextg.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks() {
        List<BookDto> booksDto = new ArrayList<>();
        for (Book b : bookRepository.findAll()) {
            booksDto.add(bookToDto(b));
        }
        return booksDto;
    }

    public BookDto getOneBook(Long id) {
        Book b = bookRepository
                .findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookToDto(b);
    }

    public BookDto createBook(Book book) {
        return bookToDto(bookRepository.save(book));
    }

    public BookDto updateBook(Long id, Book book) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        } else {
            book.setId(id);
            return bookToDto(bookRepository.save(book));
        }
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        } else {
            bookRepository.deleteById(id);
        }
    }

    private BookDto bookToDto(Book b) {
        return new BookDto(
                b.getId(),
                b.getTitle(),
                b.getPublishYear(),
                b.getAnnotation(),
                b.getAuthors().stream().map(Author::getFullName).collect(Collectors.toSet()));
    }
}
