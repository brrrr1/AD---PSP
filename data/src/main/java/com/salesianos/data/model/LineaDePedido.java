package com.salesianos.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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

    @Id @GeneratedValue
    Long id;


}
