package main.com.pieisspy.tablefortress.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageHandler {
    public static void initializeSprites() {
        try {
            InputStream indexStream = ImageHandler.class.getClassLoader().getResourceAsStream("resources/images/index.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(indexStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();

                if (!trimmed.isEmpty()) {
                    InputStream imgStream = ImageHandler.class.getClassLoader().getResourceAsStream("resources/images/" + trimmed);
                    if (imgStream != null) {
                        BufferedImage img = ImageIO.read(imgStream);
                        String key = trimmed.substring(0, trimmed.lastIndexOf('.'));
                        sprites.put(key, img);
                    }
                }
            }

            System.out.println("Entries of hashmap");
            for (Map.Entry<String, BufferedImage> entry : sprites.entrySet()) {
                System.out.println("Key: " + entry.getKey());
                System.out.println("Value: " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        String[] names = readNames(path);
        BufferedImage[] images = readFiles(path);
        int i;

        try {
            for (i = 0; i < names.length; i++)
                sprites.put(names[i], images[i]);

            System.out.println("Entries of hashmap");
            for (Map.Entry<String, BufferedImage> entry : sprites.entrySet()) {
                System.out.println("Key: " + entry.getKey());
                System.out.println("Value: " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
    }

    public static String[] readNames(String path) {
        File[] files;
        String[] temp;
        String filename;
        int i;

        try {
            URL url = ImageHandler.class.getResource(path);
            System.out.println(url);
            File filepath = new File(url.toURI());
            files = filepath.listFiles();
            temp = new String[files.length];

            System.out.println("reading names");
            for (i = 0; i < files.length; i++) {
                filename = files[i].toString();
                temp[i] = filename.substring(filename.lastIndexOf('\\') + 1, filename.indexOf('.'));
                System.out.println(temp[i]);
            }
            System.out.println();

            return temp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static BufferedImage[] readFiles(String path) {
        BufferedImage[] temp;

        try {
            URL url = ImageHandler.class.getResource(path);
            System.out.println(url);
            File filepath = new File(url.toURI());
            File[] files = filepath.listFiles();

            System.out.println("Reading files");
            for (File f: files)
                System.out.println(f.toString());

            System.out.println();

            temp = new BufferedImage[files.length];
            readImages(files, temp);

            return temp;
        } catch (Exception e) {
            System.out.println("inside readfiles");
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void readImages(File[] files, BufferedImage[] container) {
        int i;

        System.out.println("Reading images");
        for (i = 0; i < files.length; i++) {
            try {
                container[i] = ImageIO.read(files[i]);
                System.out.println(container[i].toString());
            } catch (Exception e) {
                System.out.println("inside readimages");
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

    public static final HashMap<String, BufferedImage> sprites = new HashMap<>();
}