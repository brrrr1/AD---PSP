package com.salesianos.data.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@IdClass(LineaPedidoId.class)
public class LineaDePedido {

    @Id
    @GeneratedValue
    private Long id;

    @Id
    @ManyToMany
    private Producto producto;



}