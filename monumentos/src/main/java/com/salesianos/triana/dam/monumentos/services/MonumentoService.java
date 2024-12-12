package com.salesianos.triana.dam.monumentos.services;

import com.salesianos.triana.dam.monumentos.models.Monumento;
import com.salesianos.triana.dam.monumentos.repositories.MonumentoRepository;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    @Autowired
    private final MonumentoRepository repo;

    public List<Monumento> getAll() {
        return repo.findAll();
    }

    public Monumento getMonumentoById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteMonumentoById(Long id) {
        repo.deleteById(id);
    }

    public Monumento modificarMonumento(Monumento m,Long id) {
        Monumento monumentoEncontrado = repo.findById(id).orElse(null);
        if(monumentoEncontrado != null) {
            return repo.save(m);
        }
        return m;
    }

    public Monumento guardarMonumento(Monumento m) {
        return repo.save(m);
    }
}
