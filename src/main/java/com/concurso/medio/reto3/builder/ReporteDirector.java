package com.concurso.medio.reto3.builder;

import java.util.List;

public class ReporteDirector<T> {
    private final ReporteBuilder<T> builder;

    public ReporteDirector(ReporteBuilder<T> builder) {
        this.builder = builder;
    }

    public String construirReporte(List<T> datos,
                                   List<String> campos) {
        return builder.setDatos(datos)
                .setCampos(campos)
                .buildReporte();
    }
}
