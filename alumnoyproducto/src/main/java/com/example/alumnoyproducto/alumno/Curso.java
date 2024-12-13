package com.example.alumnoyproducto.alumno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {
    Long id;
    String nombre;
    String tipo;
    String tutor;
    String aula;
}
