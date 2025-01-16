package com.salesianos.ej02ap1;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Categoria {

    @Id  @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    //@ToString.Exclude@JsonManagedReference
    private List<Producto> productos = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_padre_id", foreignKey = @ForeignKey(name = "fk_categoria_categoria_padre"))
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Categoria> subcategorias = new ArrayList<>();

    // Métodos helper

    public void addProducto(Producto p) {
        this.getProductos().add(p);
        p.setCategoria(this);
    }

    public void removeProducto(Producto p) {
        this.getProductos().remove(p);
        p.setCategoria(null);
    }



    // Métodos helper para subcategorías
    public void addSubcategoria(Categoria subcategoria) {
        this.getSubcategorias().add(subcategoria);
        subcategoria.setCategoriaPadre(this);
    }

    public void removeSubcategoria(Categoria subcategoria) {
        this.getSubcategorias().remove(subcategoria);
        subcategoria.setCategoriaPadre(null);
    }
}
