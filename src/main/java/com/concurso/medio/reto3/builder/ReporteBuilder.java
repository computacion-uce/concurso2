package com.concurso.medio.reto3.builder;

import java.util.List;

public interface ReporteBuilder<T> {
    ReporteBuilder<T> setDatos(List<T> personas);
    ReporteBuilder<T> setCampos(List<String> campos);
    String buildReporte();
}
