package com.concurso.basico.reto32;

public record Carta(String palo, String valor, int puntaje) {
    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
