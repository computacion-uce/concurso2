package com.concurso.basico.reto11;

import java.util.Scanner;

public class AppTriangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Ingrese el tamaño del Triángulo de Pascal: "
        );
        int n = scanner.nextInt();
        TrianguloPascal t = new TrianguloPascal(n);
        t.imprimir();
    }
}
