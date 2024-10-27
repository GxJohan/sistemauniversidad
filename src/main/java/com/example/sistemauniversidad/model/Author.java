package com.example.sistemauniversidad.model;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
@Table(name = "author")
public class Author {

    @Id//Define este campo como la clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Genera un valor automático para este campo autoincremental
    private Long id;

    @NotNull(message = "El nombre del autor es requerido")//Valida que el campo no sea nulo
    @Size(min = 3, max = 50, message = "    El nombre del autor debe tener entre 3 y 50 caracteres")//Valida que el campo tenga una longitud entre 3 y 50 caracteres
    @Column(name = "name")//Define el nombre de la columna en la tabla
    private String name;

    @NotNull(message = "El correo del autor es requerido")//Valida que el campo no sea nulo
    @Column(unique = true)//Valida que el campo sea único
    @Pattern(regexp = "^[a-zA-Z0-9_.%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "El correo del autor no es válido")//Valida que el campo cumpla con una expresión regular
    private String email;




}
