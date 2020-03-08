package nextg.bookstore.service;

import nextg.bookstore.domain.Author;
import nextg.bookstore.domain.Book;
import nextg.bookstore.domain.dto.BookDto;
import nextg.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

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
}
