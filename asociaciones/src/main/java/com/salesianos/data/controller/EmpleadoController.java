package com.salesianos.data.controller;

import com.salesianos.data.dto.GetEmpleadoDto;
import com.salesianos.data.model.Empleado;
import com.salesianos.data.repos.EmpleadoRepository;
import com.salesianos.data.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado/")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public List<GetEmpleadoDto> getAll() {
        return empleadoService.findAll()
                .stream()
                .map(GetEmpleadoDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public Empleado getById(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Empleado> create(@RequestBody Empleado nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        empleadoService.save(nuevo));
    }

    @PutMapping("/{id}")
    public Empleado edit(@RequestBody Empleado aEditar,
                         @PathVariable Long id) {
        return empleadoService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
