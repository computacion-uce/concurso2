package com.concurso.medio.reto3;

import com.concurso.medio.reto3.builder.ReporteConcretoBuilder;
import com.concurso.medio.reto3.builder.ReporteDirector;
import com.concurso.medio.reto3.db.PersonaDAO;
import com.concurso.medio.reto3.model.Persona;

import java.util.Arrays;
import java.util.List;

public class ReportesApp {

    public static void main(String[] args) throws Exception {
        // se ejecuta una sola vez para crear la base,
        //   la tabla e insertar los datos

        //CreacionBase db = new CreacionBase();
        //db.connect();
        //db.createTable();
        //db.insertSampleData();

        List<Persona> personas = PersonaDAO.obtenerPersonas();

        // Reporte 1: Solo nombre y correo
        var builder1 = new ReporteConcretoBuilder<Persona>();
        var director1 = new ReporteDirector<Persona>(builder1);
        String reporte1 = director1.construirReporte(personas,
                Arrays.asList("nombre", "correo")
        );
        System.out.println(reporte1);

        // Reporte 2: nombre, edad, dirección, teléfono
        var builder2 = new ReporteConcretoBuilder<Persona>();
        var director2 = new ReporteDirector<Persona>(builder2);
        String reporte2 = director2.construirReporte(personas,
                Arrays.asList(
                        "nombre",
                        "edad",
                        "direccion",
                        "telefono"
                )
        );
        System.out.println(reporte2);
    }
}
