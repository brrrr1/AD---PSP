package com.example.alumnoyproducto.producto;

public record ProductoDTO(
        String name,
        double pvp,
        String imagen,
        String categoria
) {


    //Método para convertir un ProductoDTO en un Producto
    public static ProductoDTO toProducto(Producto producto){
        return new ProductoDTO(
                producto.getNombre(),
                producto.getPvp(),
                producto.getImagenes().get(0),
                producto.getCategoria().getNombre()
        );
    }

}