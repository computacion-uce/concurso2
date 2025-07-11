package com.concurso.basico.reto31;

public class App {
    public static void main(String[] args) {
        Baraja b = new Baraja();

        b.barajar();
        b.imrpimir();

        Jugador jugadorUno = new Jugador(Jugadores.Ana, b);
        Jugador jugadorDos = new Jugador(Jugadores.Carlos, b);

        for (int i = 0; i < 10; i++) {
            jugadorUno.tomarCarta();
            jugadorDos.tomarCarta();
        }

        System.out.println(" cartas de " + jugadorUno.getJugador() +
                " con un puntaje final de: " + jugadorUno.total());
        jugadorUno.imprimirMano();

        System.out.println(" cartas de " + jugadorDos.getJugador() +
                " con un puntaje final de: " + jugadorDos.total());
        jugadorDos.imprimirMano();

        System.out.println(jugadorUno.total() > jugadorDos.total() ?
                "Ha ganado: " + jugadorUno.getJugador() :
                "Ha ganado: " + jugadorDos.getJugador());
    }
}
