package com.Smile.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Smile.demo.entitys.Paciente;
import com.Smile.demo.services.PacienteService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Optional<Paciente> oPaciente = pacienteService.findById(id);
        if (oPaciente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPaciente.get());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> get(@PathVariable String dni) {
        Optional<Paciente> oPaciente = pacienteService.findByDni(dni);
        if (oPaciente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPaciente.get());
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody Paciente paciente) {
        return ResponseEntity.status(201).body(pacienteService.save(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Paciente pacienteDetails, @PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.findById(id);
        if (!paciente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        paciente.get().setNombre(pacienteDetails.getNombre());

        return ResponseEntity.status(201).body(pacienteService.save(paciente.get()));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!pacienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pacienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(pacienteService.findAll());
    }
}
