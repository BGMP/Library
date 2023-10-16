package cl.bgm.Library.sevice;

import cl.bgm.Library.model.Author;
import cl.bgm.Library.repository.AuthorsRepository;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {
  private final AuthorsRepository authorsRepository;

  public AuthorsService(AuthorsRepository authorsRepository) {
    this.authorsRepository = authorsRepository;
  }

  public Author save(Author author) {
    return this.authorsRepository.save(author);
  }

  public Collection<Author> get() {
    return this.authorsRepository.findAll();
  }

  public Author get(Long id) {
    return this.authorsRepository.findById(id).orElse(null);
  }

  public Author update(Author author) {
    return authorsRepository.save(author);
  }

  public void delete(Long id) {
    this.authorsRepository.deleteById(id);
  }
}
