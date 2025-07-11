package com.concurso.avanzado.reto3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    @Getter
    private final int tamTablero;
    @Getter
    private final int blockSize;

    @Getter
    private final ImageInfo image;

    public Tablero(int tamTablero, ImageInfo image) {
        this.tamTablero = tamTablero;
        blockSize = image.width() / tamTablero;
        this.image = image;
    }

    void paint() {
        List<Thread> threads = new ArrayList<>();

        for (int row = 0; row < tamTablero; row++) {
            for (int col = 0; col < tamTablero; col++) {
                TaskTablero task = new TaskTablero(this, row, col);

                Thread th = new Thread(task);

                threads.add(th);

                th.start();
            }
        }

        threads.forEach(th -> {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //contorno de la imagen
        int width = image.width();
        int height = image.height();

        int size = width * height;

        for (int i = 0; i < width; i++) {
            int index = i * ImageInfo.CHANNELS;

            image.pixelData()[index] = (byte) 0;
            image.pixelData()[index + 1] = (byte) 0;
            image.pixelData()[index + 2] = (byte) 0;
            image.pixelData()[index + 3] = (byte) 255;

            index = (size - i) * ImageInfo.CHANNELS - 4;
            image.pixelData()[index] = (byte) 0;
            image.pixelData()[index + 1] = (byte) 0;
            image.pixelData()[index + 2] = (byte) 0;
            image.pixelData()[index + 3] = (byte) 255;
        }

        for (int i = 0; i < height; i++) {
            int index = (i * width) * ImageInfo.CHANNELS;

            image.pixelData()[index] = (byte) 0;
            image.pixelData()[index + 1] = (byte) 0;
            image.pixelData()[index + 2] = (byte) 0;
            image.pixelData()[index + 3] = (byte) 255;

            index = ((i + 1) * width) * ImageInfo.CHANNELS - 4;
            image.pixelData()[index] = (byte) 0;
            image.pixelData()[index + 1] = (byte) 0;
            image.pixelData()[index + 2] = (byte) 0;
            image.pixelData()[index + 3] = (byte) 255;
        }
    }
}
