package com.concurso.basico.reto12;

import java.util.List;

public class LaberintoMain {

    public static void main(String[] args) {
        int[][] laberinto1 = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 1, 0}
        };

        int[][] laberinto2 = {
                {0,0,0,0},
                {1,0,1,0},
                {0,0,0,0},
                {0,1,1,0}
        };

        Laberinto laberintoMain = new Laberinto(laberinto2);

        List<List<Coordenada>> rutas = laberintoMain.encontrarRutas();

        System.out.println("Rutas encontradas: " + rutas);
    }
}
