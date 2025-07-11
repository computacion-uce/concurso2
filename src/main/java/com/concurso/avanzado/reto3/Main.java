package com.concurso.avanzado.reto3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void saveRgbImage(byte[] pixels, int width,
                                    int height, String outputPath)
            throws IOException {

        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_4BYTE_ABGR);

        WritableRaster raster = image.getRaster();
        raster.setDataElements(0, 0, width, height, pixels);

        ImageIO.write(image, "png", new File(outputPath));
    }

    public static void main(String[] args) throws Exception {
        //----
        int width = 1024;
        int height = 1024;
        int channels = 4; // RGB
        byte[] pixelData = new byte[width * height * channels];

        ImageInfo image = new ImageInfo(width, height,
                ImageInfo.CHANNELS, pixelData);

        Tablero tablero = new Tablero(8, image);

        tablero.paint();

        saveRgbImage(image.pixelData(),
                image.width(),
                image.height(),
                "c:/cc/image04.png"
        );
    }
}
