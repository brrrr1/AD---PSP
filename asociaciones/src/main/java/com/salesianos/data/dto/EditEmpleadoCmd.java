package com.salesianos.data.dto;

import javax.swing.*;

public record EditEmpleadoCmd (
        String nombre,
        Long departamentoId
){
}
