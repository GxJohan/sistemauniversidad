package com.example.sistemauniversidad.service;

import com.example.sistemauniversidad.model.Student;
import com.example.sistemauniversidad.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //Metodo para obtener todos los estudiantes en una lista
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Metodo para obtener un estudiante por su id
    public Student getStudentById(Long id) {
        return
                studentRepository.findById(id).orElse(null);
    }

    //Metodo para registrar un estudiante
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    //Metodo para edutar un estudiante
    public Student updateStudent(Long id, Student student) {
        Student student1 = studentRepository.findById(id).orElse(null);

        if (student1 != null) {
            student1.setName(student.getName());
            student1.setEmail(student.getEmail());
            return studentRepository.save(student1);
        }
        return null;

    }

    //Metedo eliminar un estudiante
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }



















}
