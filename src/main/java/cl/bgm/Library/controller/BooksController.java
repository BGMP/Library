package cl.bgm.Library.controller;

import cl.bgm.Library.model.Author;
import cl.bgm.Library.model.Book;
import cl.bgm.Library.sevice.AuthorsService;
import cl.bgm.Library.sevice.BooksService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class BooksController {
  private BooksService booksService;
  private AuthorsService authorsService;

  @Autowired
  public BooksController(BooksService booksService, AuthorsService authorsService) {
    this.booksService = booksService;
    this.authorsService = authorsService;
  }

  @PostMapping("/books")
  public Book create(@RequestBody @Valid Book book) {
    Author author = this.authorsService.get(book.getAuthor().getId());
    if (author == null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

    book.setAuthor(author);
    book.setId(0L);

    return this.booksService.save(book);
  }

  @GetMapping("/books")
  public Collection<Book> get() {
    return this.booksService.get();
  }

  @GetMapping("/books/{id}")
  public Book get(@PathVariable Long id) {
    Book book = this.booksService.get(id);
    if (book == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    return book;
  }

  @PutMapping("/books/{id}")
  public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
    Author author = this.authorsService.get(book.getAuthor().getId());
    if (author == null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

    Book match = this.booksService.get(id);
    if (match == null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

    book.setAuthor(author);
    book.setId(match.getId());

    return this.booksService.update(book);
  }

  @DeleteMapping("/books/{id}")
  public void delete(@PathVariable Long id) {
    this.booksService.delete(id);
  }
}
