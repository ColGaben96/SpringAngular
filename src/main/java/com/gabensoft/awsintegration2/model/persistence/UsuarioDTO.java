package com.gabensoft.awsintegration2.model.persistence;

import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Data
@Table(name = "usuario")
public class UsuarioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombres;
    private String apellidos;
    private String identificacion;
    @ManyToOne(targetEntity = TipoIDDTO.class, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private TipoIDDTO tipoID_FK;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public TipoIDDTO getTipoID_FK() {
        return tipoID_FK;
    }

    public void setTipoID_FK(TipoIDDTO tipoID_FK) {
        this.tipoID_FK = tipoID_FK;
    }
}
