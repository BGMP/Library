package cl.bgm.Library.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "AUTHORS")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", length = 255)
  @NotEmpty
  private String name;

  @Column(name = "last_name", length = 255)
  @NotEmpty
  private String lastName;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private Set<Book> books = new HashSet<>();

  public Author() {}

  public Author(Long id, String name, String lastName, Set<Book> books) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;

    for (Book book : this.books) {
      book.setAuthor(this);
    }
  }
}
