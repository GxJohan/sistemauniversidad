package com.example.sistemauniversidad.service;

import com.example.sistemauniversidad.model.Promedio;
import com.example.sistemauniversidad.model.Student;
import com.example.sistemauniversidad.repository.PromedioRepository;
import com.example.sistemauniversidad.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromedioService {

    private final PromedioRepository promedioRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public PromedioService(PromedioRepository promedioRepository, StudentRepository studentRepository) {
        this.promedioRepository = promedioRepository;
        this.studentRepository = studentRepository;
    }

    public List<Promedio> getAllPromedios() {
        return promedioRepository.findAll();
    }

    public Optional<Promedio> getPromedioById(Long id) {
        return promedioRepository.findById(id);
    }

    public Promedio addPromedio(Promedio promedio) {
        Student student = studentRepository.findById(promedio.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        promedio.setStudent(student);
        return promedioRepository.save(promedio);
    }

    public Promedio updatePromedio(Long promedioId, Promedio promedioDetails) {
        Promedio promedio = promedioRepository.findById(promedioId)
                .orElseThrow(() -> new RuntimeException("Promedio not found"));
        Student student = studentRepository.findById(promedioDetails.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        promedio.setPromedio(promedioDetails.getPromedio());
        promedio.setStudent(student);
        return promedioRepository.save(promedio);
    }

    public void deletePromedio(Long promedioId) {
        Promedio promedio = promedioRepository.findById(promedioId)
                .orElseThrow(() -> new RuntimeException("Promedio not found"));
        promedioRepository.delete(promedio);
    }
}
