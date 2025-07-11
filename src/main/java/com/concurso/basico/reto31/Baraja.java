package com.concurso.basico.reto31;

import java.util.Random;

public class Baraja {
    public static final int TOTAL_CARTAS = 52;

    private Cartas[] cartas = new Cartas[TOTAL_CARTAS];
    public Cartas[] barajadas = new Cartas[TOTAL_CARTAS];
    private boolean[] marcada = new boolean[TOTAL_CARTAS];
    private Random r = new Random();

    public Baraja() {
        crearCartas();
    }

    public void crearCartas() {
        int count = 1;
        int pal = 0;
        for (int i = 0; i < cartas.length; i++) {
            if (count <= 13)
                cartas[i] = new Cartas(Palo.values()[pal], count++);
            else {
                count = 1;
                pal = pal + 1;
                cartas[i] = new Cartas(Palo.values()[pal], count++);
            }
        }
    }

    public void barajar() {
        int num = 0;
        boolean estado = false;
        for (int i = 0; i < cartas.length; i++) {
            do {
                num = r.nextInt(TOTAL_CARTAS);
                if (barajadas[num] == null) {
                    barajadas[num] = cartas[i];
                    estado = true;
                } else {
                    estado = false;
                }
            } while (!estado);
        }
    }

    public void imrpimir() {
        System.out.println("Las Cartas han sido barajadas");
        for (int i = 0; i < barajadas.length; i++) {
            System.out.print(barajadas[i].palo().name()
                    + barajadas[i].valor() + " ");
        }
        System.out.println();
    }
}
