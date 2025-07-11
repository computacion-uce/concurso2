package com.concurso.medio.reto1;

public abstract class Empleado {
    public static final String USUARIO = "Usuario";
    public static final String ADMINISTRADOR = "Administrador";
    public static final String DESARROLLADOR = "Desarrollador";

    private final String nombre;
    private final String etiqueta;

    public Empleado(String nombre, String etiqueta) {
        this.nombre = nombre;
        this.etiqueta = etiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public abstract String getTipo();
}
