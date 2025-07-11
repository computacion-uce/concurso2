package com.concurso.basico.reto32;

import java.util.Collections;
import java.util.Stack;

public class Baraja {
    private final Stack<Carta> cartas;

    public Baraja() {
        String[] palos = {
                "Corazones",
                "Diamantes",
                "Tréboles",
                "Picas"
        };

        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9",
                "10", "J", "Q", "K", "A"};

        int[] puntajes = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 20};

        this.cartas = new Stack<>();
        for (String palo : palos) {
            int i = 0;
            for (String valor : valores) {
                cartas.push(new Carta(palo, valor, puntajes[i++]));
            }
        }
    }

    public void revolver() {
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        return cartas.pop();
    }

    public void colocarCarta(Carta carta) {
        cartas.push(carta);
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }
}
