package com.concurso.medio.reto1;

public class Administrador extends Empleado {
    public Administrador(String nombre, String etiqueta) {
        super(nombre, etiqueta);
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}
