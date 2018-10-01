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
    double puzzleSize;

    BufferedImage bfdImage = null;
    BufferedImage subImage = null;

    SingleImage(){

    }

    SingleImage(double xS, double yS, double pS,String f){
        this.puzzleSize = pS;
        this.originalX = (int)(xS-(puzzleSize/2));
        this.originalY = (int)(yS-(puzzleSize/2));
//        File imageFile = new File(f);
        try {
            bfdImage = ImageIO.read(getClass().getResource(f));
            subImage = bfdImage.getSubimage(originalX, originalY, (int)(2*puzzleSize), (int)(2*puzzleSize));

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

        tx.quadrantRotate(rotation,puzzleSize,puzzleSize);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BICUBIC);
        this.subImage = op.filter(this.subImage, null);

    }
}

class SingleImageExtended extends SingleImage {

    SingleImageExtended(double xS, double yS, double pS,String f){
        this.originalX = (int)(xS-(puzzleSize/2));
        this.originalY = (int)(yS-(puzzleSize/2));
        this.puzzleSize = pS;
//        File imageFile = new File(f);
        try {
//            bfdImage = ImageIO.read(imageFile);
            bfdImage = ImageIO.read(getClass().getResource(f));
            subImage = bfdImage.getSubimage(originalX, originalY, (int)(2*puzzleSize), (int)(2*puzzleSize));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}