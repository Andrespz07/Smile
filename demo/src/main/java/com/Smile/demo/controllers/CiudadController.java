package com.Smile.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.Smile.demo.entitys.Ciudad;
// import com.Smile.demo.services.CiudadService;
import com.Smile.demo.services.CiudadService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/ciudad")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;
    

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Optional<Ciudad> oCiudad = ciudadService.findById(id);
        if (oCiudad.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oCiudad.get());
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody Ciudad ciudad) {
        return ResponseEntity.status(201).body(ciudadService.save(ciudad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Ciudad ciudadDetails, @PathVariable Long id) {
        Optional<Ciudad> ciudad = ciudadService.findById(id);
        if (!ciudad.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ciudad.get().setCiudad(ciudadDetails.getCiudad());

        return ResponseEntity.status(201).body(ciudadService.save(ciudad.get()));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!ciudadService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ciudadService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ciudadService.findAll());
    }

}