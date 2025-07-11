package com.concurso.basico.reto32;

public class MainReto32 {
    public static void main(String[] args) {
        // Crear baraja → Barajar cartas → Crear
        //   2 jugadores que roban por turnos
        // hasta que la baraja se vacíe →Mostrar y
        // Puntuar las manos de los jugadores y decidir quién gano.

        Baraja myBaraja = new Baraja();
        myBaraja.revolver();

        Jugador j1 = new Jugador("Angel");
        Jugador j2 = new Jugador("Ximena");

        boolean turno = true;

        while (!myBaraja.estaVacio()) {
            if (turno) j1.robarCarta(myBaraja);
            else j2.robarCarta(myBaraja);

            turno = !turno;
        }

        if (j1.puntuar() > j2.puntuar())
            System.out.println("GANO !! " + j1.getNombre());
        else if (j1.puntuar() < j2.puntuar())
            System.out.println("GANO !! " + j2.getNombre());
        else
            System.out.println("EMPATE !! ");
    }
}
