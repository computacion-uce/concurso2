package com.concurso.basico.reto12;

public class Coordenada {
    private int fila;
    private int columna;

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "(" + fila + "," + columna + ")";
    }
}
