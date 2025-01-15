package com.salesianos.data.controller;

import com.salesianos.data.dto.GetDepartamentoDto;
import com.salesianos.data.model.Departamento;
import com.salesianos.data.service.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Departamento", description = "El controlador de departamentos, para poder realizar todas las operaciones de gestión")
@RequestMapping("/departamento/")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    /*@GetMapping
    public List<Departamento> getAll() {
        return departamentoService.findAll();
    }*/

    //Metodo findAll para obtener todos los departamentos usando el dto para que no entre en bucle
    @Operation(summary = "Obtiene todos los departamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado departamentos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetDepartamentoDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                 {
                                                     "id": 1,
                                                     "nombre": "Departamento 1"
                                                 }
                                             ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún departamento",
                    content = @Content),
    })
    @GetMapping
    public List<GetDepartamentoDto> getAll() {
        return departamentoService.findAll()
                .stream()
                .map(GetDepartamentoDto::fromDepartamento)
                .toList();
    }

    @Operation(summary = "Obtiene un departamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el departamento",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetDepartamentoDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                 {
                                                     "id": 1,
                                                     "nombre": "Departamento 1"
                                                 }
                                             ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún departamento",
                    content = @Content),
    })
    @GetMapping("/{id}")
    public Departamento getById(@PathVariable Long id) {
        return departamentoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Departamento> create(@RequestBody Departamento departamento) {
        return ResponseEntity.ok(departamentoService.save(departamento));
    }

    @PutMapping("/{id}")
    public Departamento edit(@RequestBody Departamento departamento, @PathVariable Long id) {
        return departamentoService.edit(departamento, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        departamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
