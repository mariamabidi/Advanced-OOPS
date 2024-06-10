import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Pi extends JFrame implements Runnable{
    /**
     * Pi is the class that extends JFrame for getting the image and
     * implements the Runnable interface to implement threads. This
     * class is used to calculate and print the odd and even digits
     * of the Pi value.
     */

    private final int LENGTH_OF_SQUARE = 1;
    private final int LENGTH = 200;
    private final int LENGTH_OF_WINDOW = LENGTH * LENGTH_OF_SQUARE;
    private BufferedImage theImage;
    private String fileName = null;

    /**
     * This is the constructor for Pi class.
     * It sets the frame size for the output.
     */
    public Pi() {
        super("Pi");

        setBounds(100, 100, LENGTH_OF_WINDOW, LENGTH_OF_WINDOW);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    /**
     * The saveImage method is used to save the output file.
     * @param theImage - the buffered created image as a parameter to save it.
     */
    public void saveImage(BufferedImage theImage) {
        try {
            String suffix = "png";
            File outputfile = new File("output." + suffix);
            ImageIO.write(theImage, suffix, outputfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * fillSquare is the method used to fill each pixel according to
     * the assigned color based on the odd or even provided to the
     * assigned pixel coordinates.
     * @param xOrig - x-coordinate
     * @param yOrig - y-coordinate
     * @param color - color of the pixel
     */
    public void fillSquare(int xOrig, int yOrig, int color) {
        for (int x = 0; x < LENGTH_OF_SQUARE; x++) {
            for (int y = 0; y < LENGTH_OF_SQUARE; y++) {
                theImage.setRGB(xOrig + x, yOrig + y, color);
            }
        }
    }


    /**
     * readFile is the method used to read from the provided file.
     * It defines a char 2d array in the dimensions of length by length.
    * It reads characters from the file to this particular array.
     * @param filePath - the filename which the txt file exists.
     * @return - character array
     */
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


    /**
     * This is the method used to createImage a buffered image.
     * Here is where the threads are executed.
     * In this function the numbers are assigned red/blue pixel color
     * and then filled in the fillSquare.
     */
    public void createImage() {
        theImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        int red = Color.RED.getRGB();
        int blue = Color.BLUE.getRGB();

        char[][] fileContent = readFile("pi-billion.txt");

        int numOfThreads = 4;
        Thread[] threads = new Thread[numOfThreads];

        for (int i = 0; i < numOfThreads; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                for (int row = threadIndex; row < LENGTH; row += numOfThreads) {
                    for (int col = 0; col < LENGTH; col++) {
                        fillSquare(col * LENGTH_OF_SQUARE, row * LENGTH_OF_SQUARE, fileContent[row][col] % 2 == 0 ? red : blue);
                    }
                }
            });
        }
        for (int i= 0; i< numOfThreads; i++){
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


    /**
     * overriden method paint for the graphics.
     * @param g the specified Graphics window
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(theImage, 0, 0, this);
    }


    /**
     * The main method creates a new aPi object on which everything is operated.
     * @param args - system input
     */
    public static void main(String[] args) {
        Pi aPi = new Pi();
        aPi.setVisible(true);
        aPi.createImage();
    }

    /**
     * Overridden method run from runnable.
     */
    @Override
    public void run() {}
}