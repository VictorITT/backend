package com.project.backend.model;



import com.project.backend.security.enums.NameRol;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private NameRol nameRol;

    public Rol() {
    }

    public Rol(@NotNull NameRol nameRol) {
        this.nameRol = nameRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NameRol getRolNombre() {
        return nameRol;
    }

    public void setRolNombre(NameRol nameRol) {
        this.nameRol = nameRol;
    }
}
