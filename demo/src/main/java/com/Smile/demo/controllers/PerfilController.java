package com.Smile.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Smile.demo.entitys.Perfil;
import com.Smile.demo.services.PerfilServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/perfil")
public class PerfilController {

    @Autowired
    private PerfilServiceImpl perfilService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Optional<Perfil> oPerfil = perfilService.findById(id);
        if (oPerfil.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPerfil.get());
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody Perfil perfil) {
        return ResponseEntity.status(201).body(perfilService.save(perfil));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Perfil perfilDetails, @PathVariable Long id) {
        Optional<Perfil> perfil = perfilService.findById(id);
        if (!perfil.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        perfil.get().setCiudad(perfilDetails.getCiudad());
        perfil.get().setTelefono(perfilDetails.getTelefono());
        perfil.get().setDireccion(perfilDetails.getDireccion());
        perfil.get().setEdad(perfilDetails.getEdad());

        return ResponseEntity.status(201).body(perfilService.save(perfil.get()));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!perfilService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        perfilService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(perfilService.findAll());
    }
}
