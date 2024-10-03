package com.example.sistemauniversidad.controller;

import com.example.sistemauniversidad.model.Promedio;
import com.example.sistemauniversidad.service.PromedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promedios")
public class PromedioController {

    private final PromedioService promedioService;

    @Autowired
    public PromedioController(PromedioService promedioService) {
        this.promedioService = promedioService;
    }

    @GetMapping
    public ResponseEntity<List<Promedio>> getAllPromedios() {
        List<Promedio> promedios = promedioService.getAllPromedios();
        return ResponseEntity.ok(promedios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promedio> getPromedioById(@PathVariable Long id) {
        Optional<Promedio> promedio = promedioService.getPromedioById(id);
        return promedio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Promedio> addPromedio(@RequestBody Promedio promedio) {
        Promedio newPromedio = promedioService.addPromedio(promedio);
        return ResponseEntity.ok(newPromedio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promedio> updatePromedio(@PathVariable Long id, @RequestBody Promedio promedioDetails) {
        Promedio updatedPromedio = promedioService.updatePromedio(id, promedioDetails);
        return ResponseEntity.ok(updatedPromedio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromedio(@PathVariable Long id) {
        promedioService.deletePromedio(id);
        return ResponseEntity.noContent().build();
    }
}
