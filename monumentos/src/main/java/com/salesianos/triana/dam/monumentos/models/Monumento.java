package com.salesianos.triana.dam.monumentos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bares {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;


        @Column(nullable = false)
        private String nombre;


        @Column(nullable = false)
        private String direccion;


        @Column(nullable = false)
        private double latitud, longitud;


        @Column(nullable = false, length = 200)
        private String descripcion;


        @Column(nullable = false)
        private String tags;


        @Column(nullable = false)
        private String urlImagen;
}
