package com.example.sistemauniversidad.repository;

import com.example.sistemauniversidad.model.Promedio;
import com.example.sistemauniversidad.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromedioRepository extends JpaRepository<Promedio, Long> {
    Promedio findByStudent(Student student);
}
