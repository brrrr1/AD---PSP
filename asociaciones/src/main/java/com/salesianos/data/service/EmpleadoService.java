package com.salesianos.data.service;

import com.salesianos.data.model.Empleado;
import com.salesianos.data.repos.EmpleadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        List<Empleado> result = empleadoRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay empleados con esos criterios de búsqueda");
        return result;
    }

    public Empleado findById(Long id) {
        return empleadoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No hay empleado con ID: " + id));
    }

    public Empleado save(Empleado nuevo) {
        return empleadoRepository.save(Empleado.builder()
                .nombre(nuevo.getNombre())
                .build());
    }

    public Empleado edit(Empleado empleado, Long id) {
        return empleadoRepository.findById(id)
                .map(old -> {
                    old.setNombre(empleado.getNombre());
                    return empleadoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay empleado con ID: " + id));
    }

    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }

}
