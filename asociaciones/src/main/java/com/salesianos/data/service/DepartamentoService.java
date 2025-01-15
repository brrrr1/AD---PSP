package com.salesianos.data.service;

import com.salesianos.data.model.Departamento;
import com.salesianos.data.repos.DepartamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public List<Departamento> findAll(){
        List<Departamento> result = departamentoRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay departamentos con esos criterios de búsqueda");
        return result;
    }

    public Departamento findById(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay departamento con ID: "+ id));
    }

    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento edit(Departamento departamento, Long id) {
        return departamentoRepository.findById(id)
                .map(old -> {
                    old.setNombre(departamento.getNombre());
                    return departamentoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay departamento con ID: "+ id));
    }

    public void delete(Long id) {
        departamentoRepository.deleteById(id);
    }
}
