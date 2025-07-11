package com.concurso.basico.reto32;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Jugador {
    private final String nombre;
    private final List<Carta> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void robarCarta(Baraja baraja) {
        if (baraja.estaVacio()) return;

        Carta carta = baraja.sacarCarta();
        mano.add(carta);

        if ("A".equals(carta.valor())) {
            IntStream.range(0, 2)
                    .forEach(i -> {
                        if (!baraja.estaVacio())
                            mano.add(baraja.sacarCarta());
                    });
        } else if ("K".equals(carta.valor())) {
            Random r = new Random();
            if (!mano.isEmpty()) {
                Carta laCarta = mano.remove(r.nextInt(mano.size()));
                baraja.colocarCarta(laCarta);
            }
        }
    }

    public int puntuar() {
        return this.mano.stream()
                .map(Carta::puntaje)
                .reduce(0, Integer::sum);
    }

    public List<Carta> mostrarMano() {
        return mano;
    }
}
