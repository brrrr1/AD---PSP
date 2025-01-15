package com.salesianos.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "departamento_id", foreignKey = @ForeignKey(name = "fk_empleado_departamento"))
    //@JsonBackReference
    private Departamento departamento;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Empleado empleado = (Empleado) o;
        return getId() != null && Objects.equals(getId(), empleado.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
