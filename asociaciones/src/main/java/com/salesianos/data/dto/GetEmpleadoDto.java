package com.salesianos.data.dto;

import com.salesianos.data.model.Empleado;

public record GetEmpleadoDto(
        Long id,
        String nombre,
        GetDepartamentoDto departamentoId
) {

    public static GetEmpleadoDto of(Empleado e) {
        return new GetEmpleadoDto(
                e.getId(),
                e.getNombre(),
                GetDepartamentoDto.fromDepartamento(e.getDepartamento())
        );

    }
}
