package com.salesianos.ej02ap1;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void run() {
        Categoria categoriaPadre = Categoria.builder()
                .nombre("Electrónica")
                .build();

        Categoria categoriaHija = Categoria.builder()
                .nombre("Móviles")
                .categoriaPadre(categoriaPadre) // Relación con categoría padre
                .build();

        categoriaPadre.addSubcategoria(categoriaHija);

        categoriaRepository.saveAll(List.of(categoriaPadre, categoriaHija));


        Categoria categoria = null;
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(categoriaHija.getId());

        if (optionalCategoria.isPresent()) {
            categoria = optionalCategoria.get();
        }

        Producto producto1 = Producto.builder()
                .nombre("iPhone 14")
                .pvp(999.99)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Samsung Galaxy S23")
                .pvp(799.99)
                .build();

        if (categoria != null) {
            categoria.addProducto(producto1);
            categoria.addProducto(producto2);
        }

        productoRepository.saveAll(List.of(producto1, producto2));




        System.out.println("Categorías:");
        categoriaRepository.findAll().forEach(c -> {
            System.out.println(c);
            System.out.println("Subcategorías: " + c.getSubcategorias());
        });

        System.out.println("\nProductos:");
        productoRepository.findAll().forEach(System.out::println);
    }
}
