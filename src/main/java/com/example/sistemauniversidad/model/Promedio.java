package com.example.sistemauniversidad.model;

import jakarta.persistence.*;

@Entity
public class Promedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double promedio;

    @ManyToOne
    private Student student;

    // Constructor vacío necesario para JPA
    public Promedio() {}

    // Constructor con parámetros
    public Promedio(double promedio, Student student) {
        this.promedio = promedio;
        this.student = student;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
