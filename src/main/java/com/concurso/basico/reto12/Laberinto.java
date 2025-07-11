package com.concurso.basico.reto12;

import java.util.ArrayList;
import java.util.List;

public class Laberinto {
    int[][] laberinto;
    boolean[][] visitado;

    public Laberinto(int[][] laberinto) {
        this.laberinto = laberinto;
        visitado = new boolean[laberinto.length][laberinto[0].length];
    }

    public List<List<Coordenada>> encontrarRutas() {
        List<List<Coordenada>> rutas = new ArrayList<>();
        List<Coordenada> rutaActual = new ArrayList<>();

        buscarRutas(0, 0, rutaActual, rutas);

        return rutas;
    }

    private void buscarRutas(int fila, int col,
                             List<Coordenada> rutaActual,
                             List<List<Coordenada>> rutas) {
        int n = laberinto.length;

        // Caso base: llegar a la salida
        if (fila == n - 1 && col == n - 1) {
            rutaActual.add(new Coordenada(fila, col));
            rutas.add(new ArrayList<>(rutaActual));
            rutaActual.removeLast(); //JDK 21
            return;
        }

        // Verificar límites y si es camino transitable
        if (fila < 0 || fila >= n || col < 0 || col >= n ||
                laberinto[fila][col] == 1 || visitado[fila][col]) {
            return;
        }

        // Marcar celda como visitada
        visitado[fila][col] = true;
        rutaActual.add(new Coordenada(fila, col));

        // Moverse a derecha y abajo (recursión)
        buscarRutas(fila, col + 1, rutaActual, rutas); // Derecha
        buscarRutas(fila + 1, col, rutaActual, rutas); // Abajo

        // Backtracking: desmarcar y retroceder
        visitado[fila][col] = false;
        rutaActual.removeLast();
    }
}
