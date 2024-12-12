package com.salesianos.triana.dam.monumentos.controllers;

import com.salesianos.triana.dam.monumentos.models.Monumento;
import com.salesianos.triana.dam.monumentos.repositories.MonumentoRepository;

import com.salesianos.triana.dam.monumentos.services.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/monumentos")
@RequiredArgsConstructor
public class MonumentoController {



    @Autowired
    private final MonumentoService servicio;
    @Autowired
    private MonumentoService monumentoService;

    @GetMapping("/all")
    public ResponseEntity<List<Monumento>> listarMonumentos(){
        return new ResponseEntity<>(monumentoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.ok(monumentoService.getMonumentoById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Monumento> addMonumento(@RequestBody Monumento m) {
        Monumento nuevoMonumento = monumentoService.guardarMonumento(m);
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentoService.guardarMonumento(m));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Monumento> modificarMonumento(@RequestBody Monumento m, @PathVariable Long id) {
        return ResponseEntity.ok(monumentoService.modificarMonumento(m, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMonumento(@PathVariable Long id) {
        monumentoService.deleteMonumentoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
