import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class SingleImage extends Image {
    int xStart, yStart;
    String f = "D:\\puzzle_Valparaiso.jpg";

    BufferedImage bfdImage = null;
    BufferedImage subimage = null;

    SingleImage(){

    }

    SingleImage(int xS, int yS){
        this.xStart = xS;
        this.yStart = yS;
        File imageFile = new File(f);
        try {
            this.bfdImage = ImageIO.read(imageFile);
            this.subimage = bfdImage.getSubimage(xStart, yStart, 100, 100);

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

    void setImageRotation(int rotation){
        AffineTransform tx = new AffineTransform();

        tx.quadrantRotate(rotation,100,100);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BICUBIC);
        this.subimage = op.filter(this.subimage, null);

    }
}

class SingleImageTopExtended extends SingleImage {

    SingleImageTopExtended(int xS, int yS){
        xStart = xS;
        yStart = yS;
        File imageFile = new File(f);
        try {
            bfdImage = ImageIO.read(imageFile);
            subimage = bfdImage.getSubimage(xStart, yStart, 200, 200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class SingleImageLeftExtended extends SingleImage {

    SingleImageLeftExtended(int xS, int yS){
        xStart = xS;
        yStart = yS;
        File imageFile = new File(f);
        try {
            bfdImage = ImageIO.read(imageFile);
            subimage = bfdImage.getSubimage(xStart, yStart, 200, 200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class SingleImageRightExtended extends SingleImage {

    SingleImageRightExtended(int xS, int yS){
        xStart = xS;
        yStart = yS;
        File imageFile = new File(f);
        try {
            bfdImage = ImageIO.read(imageFile);
            subimage = bfdImage.getSubimage(xStart, yStart, 200, 200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class SingleImageBottomExtended extends SingleImage {

    SingleImageBottomExtended(int xS, int yS){
        xStart = xS;
        yStart = yS;
        File imageFile = new File(f);
        try {
            bfdImage = ImageIO.read(imageFile);
            subimage = bfdImage.getSubimage(xStart, yStart, 200, 200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class SingleImageExtended extends SingleImage {

    SingleImageExtended(int xS, int yS){
        xStart = xS;
        yStart = yS;
        File imageFile = new File(f);
        try {
            bfdImage = ImageIO.read(imageFile);
            subimage = bfdImage.getSubimage(xStart, yStart, 200, 200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}