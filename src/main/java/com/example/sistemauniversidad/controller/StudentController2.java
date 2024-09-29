package com.example.sistemauniversidad.controller;

import com.example.sistemauniversidad.model.Student;
import com.example.sistemauniversidad.service.StudentService;
import com.example.sistemauniversidad.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController2 {

    @Autowired
    private StudentService studentService;

    //Página principal
    @GetMapping
    public String index() {
        return "index";
    }

    //Listar Alumnos
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "listar";
    }

    //Mostrar formulario para Agregar Alumno
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("student", new Student());
        return "crear";
    }

    //Accion de Agregar Alumno
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/students/listar";
    }




}
