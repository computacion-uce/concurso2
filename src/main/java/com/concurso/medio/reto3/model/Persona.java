package com.concurso.medio.reto3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {
    private int id;
    private String nombre;
    private int edad;
    private String correo;
    private String direccion;
    private String telefono;
}
