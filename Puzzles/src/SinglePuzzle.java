import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.*;

public class SinglePuzzle extends Area {

    Area area = new Area();

    double cornerX = 0;
    double cornerY = 0;
    double originalX = 0;
    double originalY = 0;

    SinglePuzzle(){

    }

    SinglePuzzle(double cornerX, double cornerY, double width, double height){

        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        area.add(new Area(rectangle));


    }

    void setRotation(double newX, double newY){
        this.cornerX = newX;
        this.cornerY = newY;

        AffineTransform oAT = new AffineTransform();
       oAT.quadrantRotate(1,newX, newY);
        area.transform(oAT);

    }

    Area getPuzzle (){
        return area;
    }

    void setPosition(double newX, double newY){

        this.cornerX = newX;
        this.cornerY = newY;

        AffineTransform oAT = new AffineTransform();
        oAT.translate(newX,newY);
        area.transform(oAT);

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

class PuzzleTopLeftCorner extends SinglePuzzle {

    PuzzleTopLeftCorner(double cornerX, double cornerY, double width, double height){

        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;
        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double rCut = new Ellipse2D.Double((width-cornerX)/2-20+40,(height-cornerY)/2-20,40,40);
        area.add(new Area(rectangle));

        area.subtract(new Area(rCut));

        Ellipse2D.Double bCut = new Ellipse2D.Double((width-cornerX)/2-20,(height-cornerY)/2-20+40,40,40);
        area.subtract(new Area(bCut));

    }
}

class PuzzleTopRightCorner extends SinglePuzzle {

    PuzzleTopRightCorner(double cornerX, double cornerY, double width, double height){
        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        area.add(new Area(rectangle));

        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX-10,cornerY+50-20,40,40);
        area.subtract(new Area(lCut));

        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX+50-20,cornerY+100-30,40,40);
        area.subtract(new Area(bCut));

    }
}

class PuzzleBottomRightCorner extends SinglePuzzle {

    PuzzleBottomRightCorner(double cornerX, double cornerY, double width, double height){
        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        area.add(new Area(rectangle));

        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX-10,cornerY+50-20,40,40);
        area.subtract(new Area(lCut));

        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX+50-20,cornerY-10,40,40);
        area.subtract(new Area(tCut));

    }
}

class PuzzleBottomLeftCorner extends SinglePuzzle {

    PuzzleBottomLeftCorner(double cornerX, double cornerY, double width, double height){
        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        area.add(new Area(rectangle));

        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX+ 50+20,cornerY+50-20,40,40);
        area.subtract(new Area(rCut));

        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX+50-20,cornerY-10,40,40);
        area.subtract(new Area(tCut));

    }
}

class PuzzleTopRowEven extends SinglePuzzle {

    PuzzleTopRowEven(double cornerX, double cornerY, double width, double height){
        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double lFill = new Ellipse2D.Double(cornerX-30,30,40,40);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX+width-10,30,40,40);
        Ellipse2D.Double bFill = new Ellipse2D.Double(cornerX+30,100-10,40,40);

        area.add(new Area(rectangle));
        area.add(new Area(lFill));
        area.add(new Area(rFill));
        area.add(new Area(bFill));

    }

    @Override
    AffineTransform getOATransform(){
        AffineTransform oAT = new AffineTransform();
        oAT.translate(originalX-50, originalY);
        return oAT;
    }
}

class PuzzleTopRowOdd extends SinglePuzzle {

    PuzzleTopRowOdd(double cornerX, double cornerY, double width, double height){

        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX-10,30,40,40);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX+width-30,30,40,40);
        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX+30,100-30,40,40);

        area.add(new Area(rectangle));
        area.subtract(new Area(lCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(bCut));

    }
}

class PuzzleLeftEven extends SinglePuzzle {

    PuzzleLeftEven(double cornerX, double cornerY, double width, double height){


        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double tFill = new Ellipse2D.Double(cornerX+30,cornerY-30,40,40);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX+100-10,cornerY+50-20,40,40);
        Ellipse2D.Double bFill = new Ellipse2D.Double(cornerX+30,cornerY+100-10,40,40);

        area.add(new Area(rectangle));
        area.add(new Area(tFill));
        area.add(new Area(rFill));
        area.add(new Area(bFill));

    }

    @Override
    AffineTransform getOATransform(){
        AffineTransform oAT = new AffineTransform();
        oAT.translate(originalX, originalY-50);
        return oAT;
    }
}

class PuzzleLeftOdd extends SinglePuzzle {

    PuzzleLeftOdd(double cornerX, double cornerY, double width, double height){

        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX+30,cornerY-10,40,40);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX+100-30,cornerY+50-20,40,40);
        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX+30,cornerY+100-30,40,40);

        area.add(new Area(rectangle));
        area.subtract(new Area(tCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(bCut));

    }
}

class PuzzleRightEven extends SinglePuzzle {

    PuzzleRightEven(double cornerX, double cornerY, double width, double height){


        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double tFill = new Ellipse2D.Double(cornerX+30,cornerY-30,40,40);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX-30,cornerY+50-20,40,40);
        Ellipse2D.Double bFill = new Ellipse2D.Double(cornerX+30,cornerY+100-10,40,40);

        area.add(new Area(rectangle));
        area.add(new Area(tFill));
        area.add(new Area(rFill));
        area.add(new Area(bFill));

    }

    @Override
    AffineTransform getOATransform(){
        AffineTransform oAT = new AffineTransform();
        oAT.translate(originalX-50, originalY-50);
        return oAT;
    }
}

class PuzzleRightOdd extends SinglePuzzle {

    PuzzleRightOdd(double cornerX, double cornerY, double width, double height){


        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX+30,cornerY-10,40,40);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX-10,cornerY+50-20,40,40);
        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX+30,cornerY+100-30,40,40);

        area.add(new Area(rectangle));
        area.subtract(new Area(tCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(bCut));

    }
}

class PuzzleBottomRowEven extends SinglePuzzle {

    PuzzleBottomRowEven(double cornerX, double cornerY, double width, double height){

        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double lFill = new Ellipse2D.Double(cornerX-30,cornerY+30,40,40);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX+width-10,cornerY+30,40,40);
        Ellipse2D.Double tFill = new Ellipse2D.Double(cornerX+30,cornerY-30,40,40);

        area.add(new Area(rectangle));
        area.add(new Area(lFill));
        area.add(new Area(rFill));
        area.add(new Area(tFill));

    }

    @Override
    AffineTransform getOATransform(){
        AffineTransform oAT = new AffineTransform();
        oAT.translate(originalX-50, originalY-50);
        return oAT;
    }
}

class PuzzleBottomRowOdd extends SinglePuzzle {

    PuzzleBottomRowOdd(double cornerX, double cornerY, double width, double height){

        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX-10,cornerY+30,40,40);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX+width-30,cornerY+30,40,40);
        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX+30,cornerY-10,40,40);

        area.add(new Area(rectangle));
        area.subtract(new Area(lCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(tCut));

    }
}

class PuzzleEvenEven extends SinglePuzzle {

    PuzzleEvenEven(double cornerX, double cornerY, double width, double height){

        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX-10,cornerY+30,40,40);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX+width-30,cornerY+30,40,40);
        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX+30,cornerY-10,40,40);
        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX+30,cornerY+100-30,40,40);

        area.add(new Area(rectangle));
        area.subtract(new Area(lCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(tCut));
        area.subtract(new Area(bCut));

    }

}

class PuzzleOddEven extends SinglePuzzle {

    PuzzleOddEven(double cornerX, double cornerY, double width, double height){
        this.cornerX = cornerX;
        this.cornerY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.cornerX, this.cornerY, width, height);
        Ellipse2D.Double lFill = new Ellipse2D.Double(cornerX-30,cornerY+30,40,40);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX+width-10,cornerY+30,40,40);
        Ellipse2D.Double tFill = new Ellipse2D.Double(cornerX+30,cornerY-30,40,40);
        Ellipse2D.Double bFill = new Ellipse2D.Double(cornerX+30,cornerY+100-10,40,40);

        area.add(new Area(rectangle));
        area.add(new Area(lFill));
        area.add(new Area(rFill));
        area.add(new Area(tFill));
        area.add(new Area(bFill));

    }

    @Override
    AffineTransform getOATransform(){
        AffineTransform oAT = new AffineTransform();
        oAT.translate(originalX-50, originalY-50);
        return oAT;
    }
}
