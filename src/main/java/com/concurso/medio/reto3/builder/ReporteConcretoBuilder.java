package com.concurso.medio.reto3.builder;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.List;

public class ReporteConcretoBuilder<T> implements ReporteBuilder<T> {
    private List<T> datos;
    private List<String> campos;

    private Object getValue(Object obj, String fieldName) {
        try {
            if (PropertyUtils.isReadable(obj, fieldName)) {
                return PropertyUtils.getProperty(obj, fieldName);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ReporteBuilder<T> setDatos(List<T> datos) {
        this.datos = datos;
        return this;
    }

    @Override
    public ReporteBuilder<T> setCampos(List<String> campos) {
        this.campos = campos;
        return this;
    }

    private void buildHeader(StringBuilder report) {
        for (String f : campos) {
            report.append(String.format("%-15s", f.toUpperCase()));
        }
        report.append("\n");
        for (int i = 0; i < campos.size() * 15; i++) {
            report.append("-");
        }
        report.append("\n");
    }

    @Override
    public String buildReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Reporte Dinamico ===\n");

        if (datos.isEmpty() || campos.isEmpty()) {
            return sb.toString();
        }

        buildHeader(sb);

        for (T it : datos) {
            for (String campo : campos) {
                Object val = getValue(it, campo);

                sb.append(
                        String.format("%-15s", val != null
                                ? val
                                : "?"
                        )
                );
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
