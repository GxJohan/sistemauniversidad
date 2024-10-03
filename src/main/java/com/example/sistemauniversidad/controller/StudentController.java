package com.example.sistemauniversidad.controller;

import com.example.sistemauniversidad.model.Student;
import com.example.sistemauniversidad.service.StudentService;
import com.example.sistemauniversidad.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Obtener la lista de estdiantes - http
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //obtener un estudiante por su id - http
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    //Registramos a un estudiante - http
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return
                studentService.addStudent(student);
    }

    //Actualizamos a un estudiante por su ID - http
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }

    //Eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }













}
