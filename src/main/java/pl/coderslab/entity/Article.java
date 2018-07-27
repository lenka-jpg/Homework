package pl.coderslab.entity;

import javafx.scene.input.DataFormat;
import pl.coderslab.validator.CategoryValidator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Wartość konieczna",groups = CategoryValidator.class)
    @Size(max = 200, message = "Za dlugi tekst")
    private String title; // (max. 200 znaków),

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author; //- (powiązanie relacją do klasy Author) - artykuł może mieć tylko jednego autora

    @ManyToMany(fetch = FetchType.EAGER)
    @NotNull(message = "Wartość konieczna")
    private List <Category> category = new ArrayList<>();// - (powiązanie relacją do klasy Author) - artykuł może należeć do wielu kategorii

    @NotNull(message = "Wartość konieczna", groups = CategoryValidator.class)
    @Size(min=500, message = "Za zmalo znakow")
    private String content;

    private String draft;

    private LocalDateTime created;//(wartość ma być automatycznie dodawana podczas zapisu)
    private LocalDateTime updated; //(wartość ma być automatycznie zmieniana podczas edycji).

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

