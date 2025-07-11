package com.concurso.medio.reto1;

public class Usuario extends Empleado {
    public Usuario(String nombre, String etiqueta) {
        super(nombre, etiqueta);
    }

    @Override
    public String getTipo() {
        return "Usuario";
    }
}
