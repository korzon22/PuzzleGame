import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

public class SingleImage extends Image {
    int originalX;
    int originalY;
    double puzzleSize;
    double scaleFactor;

    BufferedImage bfdImage = null;
    BufferedImage subImage = null;

    SingleImage(){

    }

    SingleImage(double xS, double yS, double pS,String f, double sF){
        this.puzzleSize = pS;
        this.scaleFactor = sF;
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

    SingleImageExtended(double xS, double yS, double pS, String f, int newSize){
        this.scaleFactor = newSize;
        this.originalX = (int)(xS-(puzzleSize/2));
        this.originalY = (int)(yS-(puzzleSize/2));
        this.puzzleSize = pS;
        int twicePuzzle = (int)(2*puzzleSize);
//        File imageFile = new File(f);
        try {
//            bfdImage = ImageIO.read(imageFile);

            bfdImage = ImageIO.read(getClass().getResource(f));

            //it works, need to adjust 800 to something else!!! :D
//            Image tmp = bfdImage.getScaledInstance(945, 945, Image.SCALE_FAST);

            System.out.println("Scaled: "+7*pS);

            BufferedImage resized = new BufferedImage((int)(7*pS), (int)(7*pS), BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = resized.createGraphics();

//            g2d.drawImage(tmp, (int)puzzleSize, (int)puzzleSize, null);

            //zoom in/out ->change 6*ps to 5*ps, etc
            g2d.drawImage(bfdImage, (int)puzzleSize, (int)puzzleSize, (int)(6*pS) , (int)(6*pS) , null);

            g2d.dispose();

//
//            BufferedImage after = new BufferedImage(bfdImage.getWidth(),bfdImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
//            AffineTransform scaleInstance = AffineTransform.getScaleInstance(bfdImage.getWidth(), bfdImage.getHeight());
//            AffineTransformOp scaleOp = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BILINEAR);
//            scaleOp.filter(bfdImage, after);
//            subImage = after.getSubimage(originalX, originalY, (int)(2*puzzleSize), (int)(2*puzzleSize));
//

            subImage = resized.getSubimage(originalX, originalY, twicePuzzle, twicePuzzle);
//            subImage = bfdImage.getSubimage(originalX, originalY, (int)(2*puzzleSize), (int)(2*puzzleSize));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}