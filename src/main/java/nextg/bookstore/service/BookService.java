package nextg.bookstore.service;

import nextg.bookstore.domain.Author;
import nextg.bookstore.domain.Book;
import nextg.bookstore.domain.dto.BookDto;
import nextg.bookstore.exceptions.BookNotFoundException;
import nextg.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        List<BookDto> booksDto = new ArrayList<>();
        for (Book b : books) {
            booksDto.add(new BookDto(
                    b.getId(),
                    b.getTitle(),
                    b.getPublishYear(),
                    b.getAnnotation(),
                    b.getAuthors().stream().map(Author::getFullName).collect(Collectors.toSet())
            ));
        }
        return booksDto;
    }

    public BookDto getOneBook(Long id) {
        Book b = bookRepository
                .findById(id)
                .orElseThrow(BookNotFoundException::new);
        return new BookDto(
                b.getId(),
                b.getTitle(),
                b.getPublishYear(),
                b.getAnnotation(),
                b.getAuthors().stream().map(Author::getFullName).collect(Collectors.toSet()));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        } else {
            book.setId(id);
            return bookRepository.save(book);
        }
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        } else {
            bookRepository.deleteById(id);
        }
    }
}
