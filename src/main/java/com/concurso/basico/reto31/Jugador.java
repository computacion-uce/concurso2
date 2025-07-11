package com.concurso.basico.reto31;

public class Jugador {
	private static int count;
	public int num;
	private Baraja baraja;
	private Jugadores jugador;
	private Cartas[] cartas;
	private int tot;

	public Jugador(Jugadores jugador, Baraja baraja) {
		this.jugador = jugador;
		this.baraja = baraja;
		this.cartas = new Cartas[10];
	}

	public void tomarCarta() {
		cartas[num++] = baraja.barajadas[count++];
	}

	public void imprimirMano() {
		for (int i = 0; i < 10; i++) {
			System.out.print(" " + cartas[i].palo()
					+ cartas[i].valor() + " ");
		}
		System.out.println();
	}

	public Jugadores getJugador() {
		return jugador;
	}

	public int total() {
		for (int i = 0; i < 10; i++) {
			tot += cartas[i].valor();
		}
		return tot;
	}
}
