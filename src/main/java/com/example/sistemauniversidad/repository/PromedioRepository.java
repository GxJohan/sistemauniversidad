package com.example.sistemauniversidad.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sistemauniversidad.model.Promedio;
import com.example.sistemauniversidad.model.Student;

@Repository
public interface PromedioRepository extends JpaRepository<Promedio, Long> {
    Promedio findByStudent(Student student);
}
