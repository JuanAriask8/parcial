package com.procesos.negocio.brainer.models;


import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    public Rol(){}

    public Rol(Integer id){
        super();
        this.id = id;
    }

    public Rol(String nombre){
        super();
        this.nombre = nombre;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


