import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.*;

public class SinglePuzzle extends Area {

    Area area = new Area();
    double positionX = 0;
    double positionY = 0;
    double originX = 0;
    double originY = 0;

    SinglePuzzle(double a, double b, double c, double d){

        positionX = a;
        positionY = b;

        originX = a;
        originY = b;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(positionX, positionY, c, d);

        area.add(new Area(rectangle));

//        shape.subtract(new Area(new Rectangle(1, 1, 1, 1)));
//        shape.intersect(new Area(new Rectangle(1, 1, 1, 1)));
//        shape.exclusiveOr(new Area(new Rectangle(1, 1, 1, 1)));

    }
    Area getPuzzle (){
        return area;
    }
    void setPosition(double newX, double newY){
        this.positionX = newX;
        this.positionY = newY;

        AffineTransform at = new AffineTransform();
        at.translate(newX,newY);
        area.transform(at);

        originX=originX+newX;
        originY=originY+newY;
    }

    AffineTransform getOATransform(){
        AffineTransform oAT = new AffineTransform();
        oAT.translate(originX,originY);
        return oAT;
    }

    boolean ifContains(double x, double y){
        return(area.contains(x,y));
    }
}
