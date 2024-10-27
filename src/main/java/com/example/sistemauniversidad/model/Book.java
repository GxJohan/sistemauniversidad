package com.example.sistemauniversidad.model;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "El título del libro es requerido")
    @Size(min = 3, max = 50, message = "El título del libro debe tener entre 3 y 50 caracteres")
    private String title;

    @NotNull(message = "El ISBN del libro es requerido")
    @Pattern(regexp = "^[0-9-]*$", message = "El ISBN del libro no es válido")
    private String isbn;

    @Min(value=1900, message = "El año de publicación debe ser mayor o igual a 1900")
    @Max(value=2100, message = "El año de publicación debe ser menor o igual a 2100")
    private int publicationYear;

    //Agrgamos la relacion con el autor
    //Cada libro tiene un unico autor
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "El título del libro es requerido") @Size(min = 3, max = 50, message = "El título del libro debe tener entre 3 y 50 caracteres") String getTitle() {
        return title;
    }

    public void setTitle(@NotNull(message = "El título del libro es requerido") @Size(min = 3, max = 50, message = "El título del libro debe tener entre 3 y 50 caracteres") String title) {
        this.title = title;
    }

    public @NotNull(message = "El ISBN del libro es requerido") @Pattern(regexp = "^[0-9-]*$", message = "El ISBN del libro no es válido") String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotNull(message = "El ISBN del libro es requerido") @Pattern(regexp = "^[0-9-]*$", message = "El ISBN del libro no es válido") String isbn) {
        this.isbn = isbn;
    }

    @Min(value = 1900, message = "El año de publicación debe ser mayor o igual a 1900")
    @Max(value = 2100, message = "El año de publicación debe ser menor o igual a 2100")
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(@Min(value = 1900, message = "El año de publicación debe ser mayor o igual a 1900") @Max(value = 2100, message = "El año de publicación debe ser menor o igual a 2100") int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
