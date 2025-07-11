package com.concurso.avanzado.reto3;

public class TaskTablero implements Runnable {
    private final Tablero tablero;

    private final int row;
    private final int col;

    public TaskTablero(Tablero tablero, int row, int col) {
        this.tablero = tablero;
        this.row = row;
        this.col = col;
    }

    @Override
    public void run() {
        int index = row * tablero.getTamTablero() + col;

        byte color = 0;

        if (row % 2 == 0) {
            //fila par
            color = (byte) ImageInfo.colors[col % 2];
        }
        else {
            color = (byte) ImageInfo.colors[(col + 1) % 2];
        }

        System.out.printf("task[%d, %d]: index=%d, color=%d\n",
                row, col, index, color);

        int xs = row * tablero.getBlockSize();
        int ys = col * tablero.getBlockSize();

        byte[] pixelData = tablero.getImage().pixelData();
        int width = tablero.getImage().width();

        for (int y = xs; y < xs + tablero.getBlockSize(); y++) {
            for (int x = ys; x < ys + tablero.getBlockSize(); x++) {
                int pixelIndex = (y * width + x) * ImageInfo.CHANNELS;
                pixelData[pixelIndex + 0] = color; // Rojo
                pixelData[pixelIndex + 1] = color; // Verde
                pixelData[pixelIndex + 2] = color; // Azul
                pixelData[pixelIndex + 3] = (byte) 255;
            }
        }
    }
}
