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
    int originalX;
    int originalY;

    BufferedImage bfdImage = null;
    BufferedImage subImage = null;

    SingleImage(){

    }

    SingleImage(int xS, int yS, String f){
        this.originalX = xS;
        this.originalY = yS;
        File imageFile = new File(f);
        try {
            this.bfdImage = ImageIO.read(imageFile);
            this.subImage = bfdImage.getSubimage(originalX, originalY, 100, 100);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Image getImage(){
        return this.subImage;
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
        this.subImage = op.filter(this.subImage, null);

    }
}

class SingleImageExtended extends SingleImage {

    SingleImageExtended(int xS, int yS, String f){
        originalX = xS;
        originalY = yS;
        File imageFile = new File(f);
        try {
            bfdImage = ImageIO.read(imageFile);
            subImage = bfdImage.getSubimage(originalX, originalY, 200, 200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}