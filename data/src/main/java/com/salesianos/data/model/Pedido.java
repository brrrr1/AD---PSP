package com.salesianos.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Pedido {

    @Id @GeneratedValue
    Long id;

    @Builder.Default
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private String cliente;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<LineaDePedido> lineasPedido = new ArrayList<>();

}
