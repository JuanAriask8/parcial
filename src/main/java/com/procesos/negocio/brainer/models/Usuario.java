package com.procesos.negocio.brainer.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 100, nullable = false)
    @NotBlank
    private String nombre;
    @Column (length = 300,nullable = false)
    @NotBlank
    private String apellidos;
    @NotBlank
    @Column (length = 20,nullable = false)
    private String documento;
    @Column(unique = true,length = 100,nullable = false)
    @NotBlank
    private String correo;
    @Column(nullable = false,length = 64)
    @NotBlank
    private String password;

    /**@JoinTable(
                name = "usuarios_roles",
                joinColumns = @JoinColumn(name = "usuario_id"),
                inverseJoinColumns = @JoinColumn( name = "roles_id")

    )
    private Set<Rol> roles = new HashSet<>();

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    public void addRol(Rol rol){
        this.roles.add(rol);
    }*/
}

