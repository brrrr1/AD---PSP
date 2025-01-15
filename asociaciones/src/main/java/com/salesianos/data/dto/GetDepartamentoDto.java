package com.salesianos.data.dto;

import com.salesianos.data.model.Departamento;

public record GetDepartamentoDto(
        Long id,
        String nombre
) {

    public static GetDepartamentoDto fromDepartamento(Departamento departamento) {
        return new GetDepartamentoDto(departamento.getId(), departamento.getNombre());
    }

}
