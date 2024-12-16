package com.example.monumentosv2.controllers;

import com.example.monumentosv2.models.Monumento;
import com.example.monumentosv2.models.MonumentoRepository;
import com.example.monumentosv2.services.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumentos/")
@RequiredArgsConstructor
@Tag(name = "Monumento", description = "El controlador de monumentos")
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;
    private final MonumentoService monumentoService;

    @Operation(summary = "Obtiene todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado monumentos",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "Spain",
                                                    "cityName": "Barcelona",
                                                    "latitude": 41.3851,
                                                    "longitude": 2.1734,
                                                    "name": "Sagrada Familia",
                                                    "description": "The Basílica de la Sagrada Família, also known as the Sagrada Família, is a large unfinished Roman Catholic minor basilica in Barcelona, Catalonia, Spain.",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Barcelona_-_Sagrada_Familia_-_2015_%281%29.jpg/800px-Barcelona_-_Sagrada_Familia_-_2015_%281%29.jpg"
                                                },
                                                {
                                                    "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "Spain",
                                                    "cityName": "Barcelona",
                                                    "latitude": 41.3851,
                                                    "longitude": 2.1734,
                                                    "name": "Sagrada Familia",
                                                    "description": "The Basílica de la Sagrada Família, also known as the Sagrada Família, is a large unfinished Roman Catholic minor basilica in Barcelona, Catalonia, Spain.",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Barcelona_-_Sagrada_Familia_-_2015_%281%29.jpg/800px-Barcelona_-_Sagrada_Familia_-_2015_%281%29.jpg"
                                                }
                                            
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping("all")
    public ResponseEntity<List<Monumento>> getAllWithParams(
            @RequestParam(required = false, value = "maxLatitude", defaultValue = "") Double latitude,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sort) {
        List<Monumento> result = monumentoService.query(latitude, sort);


        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Crea un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })


    @PostMapping
    public ResponseEntity<Monumento> create(
            @RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentoService.add(monumento));
    }


    @Operation(summary = "Obtiene un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el mounmento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                    "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "Spain",
                                                    "cityName": "Barcelona",
                                                    "latitude": 41.3851,
                                                    "longitude": 2.1734,
                                                    "name": "Sagrada Familia",
                                                    "description": "The Basílica de la Sagrada Família, also known as the Sagrada Família, is a large unfinished Roman Catholic minor basilica in Barcelona, Catalonia, Spain.",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Barcelona_-_Sagrada_Familia_-_2015_%281%29.jpg/800px-Barcelona_-_Sagrada_Familia_-_2015_%281%29.jpg"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping("{id}")
    public Monumento getById(@PathVariable Long id) {
        return monumentoService.get(id);
    }

    @Operation(summary = "Edita un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha editado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @PutMapping("{id}")
    public Monumento edit(
            @RequestBody Monumento monumento,
            @PathVariable("id") Long id) {
        return monumentoService.edit(id, monumento);
    }


    @Operation(summary = "Borra un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
