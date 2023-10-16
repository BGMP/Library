package cl.bgm.Library.controller;

import cl.bgm.Library.model.Author;
import cl.bgm.Library.sevice.AuthorsService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class AuthorsController {
  private final AuthorsService authorsService;

  @Autowired
  public AuthorsController(AuthorsService authorsService) {
    this.authorsService = authorsService;
  }

  @PostMapping("/authors")
  public Author create(@RequestBody @Valid Author author) {
    return this.authorsService.save(author);
  }

  @GetMapping("/authors")
  public Collection<Author> get() {
    return this.authorsService.get();
  }

  @GetMapping("/authors/{id}")
  public Author get(@PathVariable Long id) {
    Author author = this.authorsService.get(id);
    if (author == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    return author;
  }

  @PutMapping("/authors/{id}")
  public Author update(@PathVariable Long id, @RequestBody Author author) {
    author.setId(id);
    return this.authorsService.update(author);
  }

  @DeleteMapping("/authors/{id}")
  public void delete(@PathVariable Long id) {
    this.authorsService.delete(id);
  }
}
