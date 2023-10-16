package cl.bgm.Library.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "BOOKS")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", length = 255)
  @NotEmpty
  private String title;

  @Column(name = "publication_date")
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate publicationDate;

  @Column(name = "pages")
  @NotNull(message = "El número de páginas no puede estar vacío")
  @Range(min = 1)
  @Positive
  private Integer pages;

  @Column(name = "price")
  @NotNull(message = "El precio no puede estar vacío")
  @Range(min = 0)
  @Positive
  private Float price;

  @Column(name = "hardcover")
  private Boolean hardcover = false;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @NotNull(message = "El autor no puede estar vacío")
  private Author author;

  public Book() {}

  public Book(
      Long id,
      String title,
      LocalDate publicationDate,
      Integer pages,
      Float price,
      Boolean hardcover,
      Author author) {
    this.id = id;
    this.title = title;
    this.publicationDate = publicationDate;
    this.pages = pages;
    this.price = price;
    this.hardcover = hardcover;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(LocalDate publicationDate) {
    this.publicationDate = publicationDate;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public void setHardcover(Boolean hardcover) {
    this.hardcover = hardcover;
  }

  public Boolean isHardcover() {
    return hardcover;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
