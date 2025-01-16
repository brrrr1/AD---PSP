package com.salesianos.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaPedidoId {

    private Pedido pedido;
    private Long id;
}
