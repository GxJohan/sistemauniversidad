package com.example.sistemauniversidad.model;

import jakarta.persistence.*;

@Entity
//Esta tabla de nombre promedio se relacina con la entidad student
//La tabla promedio tiene id, promedio y estudiante_id
public class Promedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //El promedio es un atributo de la tabla promedio y es decimal
    private double promedio;

    //Relacion de uno a muchos con la tabla student
    @ManyToOne
    private Student student;

    //Getters y Setters


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
