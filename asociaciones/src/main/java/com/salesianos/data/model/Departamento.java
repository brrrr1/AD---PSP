package com.salesianos.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Departamento {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    //@ToString.Exclude@JsonManagedReference
    private List<Empleado> empleados = new ArrayList<>();


    //Métodos helper

    public void addEmpleado(Empleado e){
        e.setDepartamento(this);
        this.getEmpleados().add(e);
    }

    public void removeEmpleado(Empleado e){
        this.getEmpleados().remove(e);
        e.setDepartamento(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Departamento that = (Departamento) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }


}
