package com.concurso.medio.reto1;

public class Desarrollador extends Empleado {
    public Desarrollador(String nombre, String etiqueta) {
        super(nombre, etiqueta);
    }

    @Override
    public String getTipo() {
        return "Desarrollador";
    }
}
