package com.example.monumentosv2.services;

import com.example.monumentosv2.models.Monumento;
import com.example.monumentosv2.models.MonumentoRepository;
import com.example.monumentosv2.errors.MonumentoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository monumentoRepository;

    public List<Monumento> getAll() {
        List<Monumento> result = monumentoRepository.getAll();
        if (result.isEmpty())
            throw new MonumentoNotFoundException();
        return result;
    }

    public List<Monumento> query(double maxLatitude, String sortDirection) {
        List<Monumento> result = monumentoRepository.query(maxLatitude, sortDirection);
        if (result.isEmpty())
            throw new MonumentoNotFoundException();
        return result;
    }

    public Monumento get(Long id) {
        return monumentoRepository.get(id)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public Monumento add(Monumento monumento) {
        return monumentoRepository.add(monumento);
    }

    public Monumento edit(Long id, Monumento newValue) {
        return monumentoRepository.edit(id, newValue)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public void delete(Long id) {
        monumentoRepository.delete(id);
    }



}
