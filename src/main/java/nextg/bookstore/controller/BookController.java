package nextg.bookstore.controller;

import nextg.bookstore.domain.Book;
import nextg.bookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getOneBook(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable Long id) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
