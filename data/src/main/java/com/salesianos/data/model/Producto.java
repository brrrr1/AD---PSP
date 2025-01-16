package com.salesianos.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "productos")
public class Producto {

    @Id @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "fk_producto_categoria"))
    @JoinTable(name = "producto_tag",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"),
            foreignKey = @ForeignKey(name = "fk_producto_tag_"),
            inverseForeignKey = @ForeignKey(name = "fk_tag_producto"))
    //@JsonBackReference
    private Categoria categoria;

    @ManyToMany(fetch = FetchType.EAGER)//LADO PROPIETARIO
    @JoinTable(
            name = "producto_tag",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"),
            foreignKey = @ForeignKey(name = "fk_producto_tag_"),
            inverseForeignKey = @ForeignKey(name = "fk_tag_producto")
    )
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Producto producto = (Producto) o;
        return getId() != null && Objects.equals(getId(), producto.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}