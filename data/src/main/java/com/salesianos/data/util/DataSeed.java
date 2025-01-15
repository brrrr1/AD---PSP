package com.salesianos.data.util;

import com.salesianos.data.model.Categoria;
import com.salesianos.data.model.Producto;
import com.salesianos.data.repos.CategoriaRepository;
import com.salesianos.data.repos.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProductoRepository repo;
    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;


    @PostConstruct
    public void run() {

        //NO USAR OR ELSE USAR OPTIONAL
        //Categoria c = categoriaRepository.findById(1L).orElse(null);

      /*

        Categoria c = null;
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(1L);

        if (optionalCategoria.isPresent()) {
            c = optionalCategoria.get();
        }

        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precio(123.45)
                //.categoria(c)
                .build();

        c.addProducto(p);

        repo.save(p);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precio(234.56)
                //.categoria(c)
                .build();

        c.addProducto(p2);

        repo.saveAll(List.of(p, p2));







        productoRepository.findAll().forEach(System.out::println);








       */




    }





}