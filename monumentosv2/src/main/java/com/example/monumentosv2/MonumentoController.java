package com.example.monumentosv2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumentos/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;



    @GetMapping
    public ResponseEntity<List<Monumento>> getAllWithParams(
            @RequestParam(required = false, value = "maxLatitude", defaultValue = "") Double latitude,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sort) {
        List<Monumento> result = monumentoRepository.query(latitude, sort);

        if (result.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Monumento> create(
            @RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentoRepository.add(monumento));
    }

    @GetMapping("{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.get(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Monumento> edit(
            @RequestBody Monumento monumento,
            @PathVariable("id") Long id){
        return ResponseEntity.of(monumentoRepository.edit(id, monumento));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        monumentoRepository.delete(id);
        return ResponseEntity.noContent().build();
    }



}
