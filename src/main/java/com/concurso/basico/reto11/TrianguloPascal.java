package com.concurso.basico.reto11;

public class TrianguloPascal {
    private int[][] pascal;

    public TrianguloPascal(int n) {
        pascal = new int[n][n];
        llenarPascal();
    }

    // Llenar la matriz con los valores del Triángulo de Pascal
    public void llenarPascal() {

        for (int fila = 0; fila < pascal.length; fila++) {
            for (int col = 0; col <= fila; col++) {
                if (col == 0 || col == fila) {
                    pascal[fila][col] = 1; // Los bordes son siempre 1
                } else {
                    pascal[fila][col] = pascal[fila - 1][col - 1]
                            + pascal[fila - 1][col];
                }
            }
        }
    }

    // Imprimir el Triángulo de Pascal
    public void imprimir() {
        for (int fila = 0; fila < pascal.length; fila++) {
            // Imprimir espacios para centrar
            for (int es = 0; es < pascal.length - fila - 1; es++) {
                System.out.print("  ");
            }
            // Imprimir los números de la fila
            for (int col = 0; col <= fila; col++) {
                System.out.printf("%4d", pascal[fila][col]);
            }
            System.out.println();
        }
    }
}
