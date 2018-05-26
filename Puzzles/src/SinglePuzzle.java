import java.awt.geom.Area;
import java.awt.geom.*;

public class SinglePuzzle extends Area {

    Area area = new Area();
    double cornerX = 0;
    double cornerY = 0;
    double originalX = 0;
    double originalY = 0;

    SinglePuzzle(double cornerX, double cornerY, double width, double height){

        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        area.add(new Area(rectangle));

//        shape.subtract(new Area(new Rectangle(1, 1, 1, 1)));
//        shape.intersect(new Area(new Rectangle(1, 1, 1, 1)));
//        shape.exclusiveOr(new Area(new Rectangle(1, 1, 1, 1)));

    }

    SinglePuzzle(double cornerX, double cornerY, double width, double height, String str){
        this(cornerX,cornerY,width,height);


    }

    Area getPuzzle (){
        return area;
    }
    void setPosition(double newX, double newY){
        this.cornerX = newX;
        this.cornerY = newY;

        AffineTransform at = new AffineTransform();
        at.translate(newX,newY);
        area.transform(at);

        originalX = originalX +newX;
        originalY = originalY +newY;
    }

    AffineTransform getOATransform(){
        AffineTransform oAT = new AffineTransform();
        oAT.translate(originalX, originalY);
        return oAT;
    }

    boolean ifContains(double x, double y){
        return(area.contains(x,y));
    }
}
