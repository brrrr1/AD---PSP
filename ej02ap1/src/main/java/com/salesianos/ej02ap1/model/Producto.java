package com.salesianos.ej02ap1.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String descripcion;

    private double pvp;

    @ManyToOne
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "fk_categoria_producto"))
    private Categoria categoria;

}
