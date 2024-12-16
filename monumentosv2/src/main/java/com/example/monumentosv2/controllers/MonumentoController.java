package com.example.monumentosv2.controllers;

import com.example.monumentosv2.models.Monumento;
import com.example.monumentosv2.models.MonumentoRepository;
import com.example.monumentosv2.services.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumentos/")
@RequiredArgsConstructor

public class MonumentoController {

    private final MonumentoRepository monumentoRepository;
    private final MonumentoService monumentoService;


    @GetMapping
    public ResponseEntity<List<Monumento>> getAllWithParams(
            @RequestParam(required = false, value = "maxLatitude", defaultValue = "") Double latitude,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sort) {
        List<Monumento> result = monumentoService.query(latitude, sort);



        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Monumento> create(
            @RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentoService.add(monumento));
    }

    @GetMapping("{id}")
    public Monumento getById(@PathVariable Long id){
        return monumentoService.get(id);
    }

    @PutMapping("{id}")
    public Monumento edit(
            @RequestBody Monumento monumento,
            @PathVariable("id") Long id){
        return monumentoService.edit(id, monumento);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
