package com.salesianos.ej02ap1.model;

import com.salesianos.ej02ap1.repository.CategoriaRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_relacion_id",
            foreignKey = @ForeignKey(name = "fk_categoria_padre_categoria"))
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Categoria> listaCategoriasHijas = new ArrayList<>();


    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Producto> producto = new ArrayList<>();

    // Métodos helpers
    public void addProducto(Producto p) {
        p.setCategoria(this);
        this.getProducto().add(p);
    }

    public void removeProducto(Producto p) {
        this.getProducto().remove(p);
        p.setCategoria(null);
    }

}