package com.concurso.avanzado.reto3;

public record ImageInfo(int width, int height, int channels,
                        byte[] pixelData) {
    public final static int CHANNELS = 4;
    static final int[] colors = {0, 255}; // negro, blanco
}
