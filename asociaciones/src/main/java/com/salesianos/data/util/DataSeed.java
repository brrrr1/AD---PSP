package com.salesianos.data.util;

import com.salesianos.data.model.Departamento;
import com.salesianos.data.model.Empleado;
import com.salesianos.data.repos.DepartamentoRepository;
import com.salesianos.data.repos.EmpleadoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeed {


    private final DepartamentoRepository departamentoRepository;
    private final EmpleadoRepository empleadoRepository;

    @PostConstruct
    public void run() {

        Departamento d = null;
        Optional<Departamento> optionalDepartamento = departamentoRepository.findById(1L);

        if (optionalDepartamento.isPresent()) {
            d = optionalDepartamento.get();
        }

        Empleado e = Empleado.builder()
                .nombre("Un empleado")
                .departamento(d)
                .build();

        d.addEmpleado(e);

        departamentoRepository.save(d);

        Empleado e2 = Empleado.builder()
                .nombre("Otro empleado")
                .departamento(d)
                .build();

        d.addEmpleado(e2);

        empleadoRepository.saveAll(List.of(e, e2));

        System.out.println("Empleados del departamento: " + d.getEmpleados());




    }

}