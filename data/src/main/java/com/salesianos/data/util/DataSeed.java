package com.salesianos.data.util;

import com.salesianos.data.model.Categoria;
import com.salesianos.data.model.Producto;
import com.salesianos.data.repos.CategoriaRepository;
import com.salesianos.data.repos.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProductoRepository repo;
    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @PostConstruct
    public void run () {

        /*

        //Categoria c = categoriaRepository.getReferenceById(1L);

        //No hacer orElse null, hacerlo mejor con Optional!!!!!
        Categoria c = null;
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(1L);

        if (categoriaOptional.isPresent()) {
            c = categoriaOptional.get();
        }

        Producto p1 = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precio(123.45)
                //.categoria(c)
                .build();

        c.addProducto(p1);

        repo.save(p1);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precio(123.45)
                //.categoria(c)
                .build();

        c.addProducto(p2);

        repo.save(p2);

        System.out.println("Productos de la categoría C1");
        System.out.println(c.getProductos());

        productoRepository.findAll()
                .forEach(System.out::println);

         */



    }

}