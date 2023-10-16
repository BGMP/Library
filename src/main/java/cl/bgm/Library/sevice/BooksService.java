package cl.bgm.Library.sevice;

import cl.bgm.Library.model.Book;
import cl.bgm.Library.repository.BooksRepository;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
  private BooksRepository booksRepository;

  public BooksService(BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }

  public Book save(Book book) {
    return this.booksRepository.save(book);
  }

  public Collection<Book> get() {
    return this.booksRepository.findAll();
  }

  public Book get(Long id) {
    return this.booksRepository.findById(id).orElse(null);
  }

  public Book update(Book book) {
    return this.booksRepository.save(book);
  }

  public void delete(Long id) {
    this.booksRepository.deleteById(id);
  }
}
