import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class SingleImage extends Image {
    int xStart, yStart;
    double xEnd,yEnd;
    int noOfRowsColumns;
    double imageSize;
    String f = "D:\\puzzle_Valparaiso.jpg";

    BufferedImage bfdImage = null;
    BufferedImage subimage = null;

    SingleImage(int xS, int yS, int xE, int yE){
        xStart = xS;
        yStart = yS;
        xEnd = xE;
        yEnd = yE;
        File imageFile = new File(f);
        try {
            bfdImage = ImageIO.read(imageFile);
            subimage = bfdImage.getSubimage(xStart, yStart, 100, 100);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Image getImage(){
        return this.subimage;
    }
    @Override
    public int getWidth(ImageObserver observer) {
        return 0;
    }

    @Override
    public int getHeight(ImageObserver observer) {
        return 0;
    }

    @Override
    public ImageProducer getSource() {
        return null;
    }

    @Override
    public Graphics getGraphics() {
        return null;
    }

    @Override
    public Object getProperty(String name, ImageObserver observer) {
        return null;
    }


}
