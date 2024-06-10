import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Pi extends JFrame implements Runnable{

    private final int LENGTH_OF_SQUARE = 1;
    private final int LENGTH = 200;
    private final int LENGTH_OF_WINDOW = LENGTH * LENGTH_OF_SQUARE;
    private BufferedImage theImage;
    private String fileName = null;

    public Pi() {
        super("Pi");

        setBounds(100, 100, LENGTH_OF_WINDOW, LENGTH_OF_WINDOW);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void saveImage(BufferedImage theImage) {
        try {
            String suffix = "png";
            File outputfile = new File("output." + suffix);
            ImageIO.write(theImage, suffix, outputfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillSquare(int xOrig, int yOrig, int color) {
        for (int x = 0; x < LENGTH_OF_SQUARE; x++) {
            for (int y = 0; y < LENGTH_OF_SQUARE; y++) {
                theImage.setRGB(xOrig + x, yOrig + y, color);
            }
        }
    }

    public char[][] readFile(String filePath) {
        char[][] fileContent = new char[LENGTH][LENGTH];
        int row = 0;
        int col = 0;

        try {
            FileReader fileReader = new FileReader(filePath);
            int charValue;
            while (true) {
                charValue = fileReader.read();
                if (charValue == '\n' || charValue == '.') {
                    continue;
                }
                if (charValue == -1) {
                    break;
                }
                char character = (char) charValue;
                int digit = (int) character;
                fileContent[row][col] = (char) digit;
                col++;
                if (col == LENGTH) {
                    col = 0;
                    row++;
                    if (row == LENGTH) {
                        break;
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public void createImage() {
        theImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        int red = Color.RED.getRGB();
        int blue = Color.BLUE.getRGB();

        char[][] fileContent = readFile("pi-billion.txt");

        int numThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                for (int row = threadIndex; row < LENGTH; row += numThreads) {
                    for (int col = 0; col < LENGTH; col++) {
                        fillSquare(col * LENGTH_OF_SQUARE, row * LENGTH_OF_SQUARE, fileContent[row][col] % 2 == 0 ? red : blue);
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        repaint();
        saveImage(theImage);
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(theImage, 0, 0, this);
    }

    public static void main(String[] args) {
        Pi aPi = new Pi();
        aPi.setVisible(true);
        aPi.createImage();
    }

    @Override
    public void run() {

    }
}
