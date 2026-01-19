package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EstadoController {

    @GetMapping("/")
    public String root() {
        return "Actividad 2 - API REST en Spring Boot con Integración Continua y Despliegue en la nube (GitHub Actions + AWS Elastic Beanstalk) - Finalizada";
    }

    @GetMapping("/api/estado")
    public ResponseEntity<Map<String, String>> estado() {
        Map<String, String> response = new HashMap<>();
        response.put("estado", "activo");
        response.put("nombre", "Actividad 2 API");
        response.put("mensaje", "API REST funcionando correctamente");
        return ResponseEntity.ok(response);
    }
}

