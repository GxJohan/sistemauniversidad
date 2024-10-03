package com.example.sistemauniversidad.service;

import org.springframework.stereotype.Service;
import com.example.sistemauniversidad.model.Promedio;
import com.example.sistemauniversidad.model.Student;
import com.example.sistemauniversidad.repository.PromedioRepository;
import com.example.sistemauniversidad.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public Promedio getPromedioById(Long id) {
        return promedioRepository.findById(id).orElse(null);
    }

    public Promedio addPromedio(Promedio promedio) {
        // Buscamos el estudiante por su id
        Student student = studentRepository.findById(promedio.getStudent().getId().intValue()).orElseThrow();
       if (student != null) {

           return promedioRepository.save(promedio);
       }
        return null;
    }

    public Promedio updatePromedio(Long promedioId, Promedio promedioDetails) {
        Promedio promedio = promedioRepository.findById(promedioId).orElse(null);
        Student student = studentRepository.findById(promedioDetails.getStudent().getId().intValue()).orElseThrow();

        if (promedio != null && student != null) {
            promedio.setPromedio(promedioDetails.getPromedio());
            promedio.setStudent(student);
            return promedioRepository.save(promedio);
        }
        return null;
    }

    public void deletePromedio(Long promedioId) {
        Promedio promedio = promedioRepository.findById(promedioId).orElse(null);
        if (promedio != null){
            promedioRepository.delete(promedio);
        }else {
            return;
        }



    }

}
