package com.concurso.medio.reto1;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private final int id;
    private final String nombre;
    private final List<Empleado> empleados = new ArrayList<>();

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void listarEmpleados() {
        System.out.println("Departamento: " + nombre);
        for (Empleado e : empleados) {
            System.out.println("- " + e.getNombre()
                    + " [" + e.getEtiqueta() + "]");
        }
    }
}
