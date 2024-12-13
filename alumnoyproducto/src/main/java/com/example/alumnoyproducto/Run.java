package com.example.alumnoyproducto;

import com.example.alumnoyproducto.alumno.Alumno;
import com.example.alumnoyproducto.alumno.AlumnoDTO;
import com.example.alumnoyproducto.alumno.Curso;
import com.example.alumnoyproducto.alumno.Direccion;
import com.example.alumnoyproducto.producto.Categoria;
import com.example.alumnoyproducto.producto.Producto;
import com.example.alumnoyproducto.producto.ProductoDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Run {
    @PostConstruct
    public static void main(String[] args) {
        //PRODUCTO
        Categoria categoria = new Categoria(1L, "Electrónica");
        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Smartphone")
                .desc("Un smartphone de última generación")
                .pvp(699.99)
                .imagenes(Arrays.asList("imagen1.jpg", "imagen2.jpg"))
                .categoria(categoria)
                .build();

        ProductoDTO productoDTO = ProductoDTO.toProducto(producto);

        //ALUMNO
        Direccion direccion = Direccion.builder()
                .id(1L)
                .tipoVia("Calle")
                .linea1("123 Main St")
                .linea2("Apt 4B")
                .cp("12345")
                .poblacion("Ciudad")
                .provincia("Provincia")
                .build();

        Curso curso = Curso.builder()
                .id(1L)
                .nombre("Matemáticas")
                .tipo("Ciencias")
                .tutor("Dr. Smith")
                .aula("Aula 101")
                .build();

        Alumno alumno = Alumno.builder()
                .id(1L)
                .nombre("Juan")
                .apellido1("Pérez")
                .apellido2("García")
                .email("juan.perez@example.com")
                .curso(curso)
                .direccion(direccion)
                .build();


        AlumnoDTO alumnoDTO = AlumnoDTO.toAlumno(alumno);

        System.out.println(productoDTO);
        System.out.println(alumnoDTO);


    }
}