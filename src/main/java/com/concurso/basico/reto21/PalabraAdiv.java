package com.concurso.basico.reto21;

import java.util.Random;
import java.util.Scanner;

public class PalabraAdiv {

    private String[] palabra = {
            "martillo",
            "murcielago",
            "mandarina",
            "acelerometro",
            "camiseta",
            "pinguino"
    };

    private StringBuilder adiv;
    private String pal;
    private int op[];

    public void palAdivina() {
        Random r = new Random();
        pal = palabra[r.nextInt(palabra.length)];
        adiv = new StringBuilder(pal);
        op = new int[pal.length() / 2 + 1];
        int num;
        for (int i = 0; i < op.length; i++) {
            num = r.nextInt(pal.length() - 1);
            if (i > 0) {
                if (num != op[i - 1]) {
                    op[i] = num;
                } else {
                    num = r.nextInt(pal.length() - 1);
                    op[i] = num;
                }
            } else {
                op[i] = num;
            }
        }

        for (int i = 0; i < op.length; i++) {
            adiv.replace(op[i], op[i] + 1, "-");
        }
        //return adiv.toString();
        System.out.println(adiv);
    }

    public void adivina() {
        Scanner sc = new Scanner(System.in);
        int cont = adiv.length() / 2 + 3;
        boolean estado = false;
        String let;
        do {
            cont--;
            System.out.println("Ingrese una letra: ");
            let = sc.next();
            Character c;
            for (int i = 0; i < op.length; i++) {
                if (pal.charAt(op[i]) == let.charAt(0)) {
                    c = let.charAt(0);
                    adiv.replace(op[i], op[i] + 1, c.toString());
                    System.out.println(adiv);
                    estado = true;
                    break;
                } else {
                    estado = false;
                }
            }
            if (!estado) {
                System.out.println("Fallaste intenta de nuevo, " +
                        "tienes : " + cont + " intentos");
            }

        } while (cont > 0 && !(pal.equals(adiv.toString())));

        if (pal.equals(adiv.toString())) {
            System.out.println("ganaste el juego");
        } else {
            System.out.println("Te quedaste sin intentos, " +
                    "vuelve a jugar ");
        }
    }
}
