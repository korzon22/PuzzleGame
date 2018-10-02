import java.awt.geom.Area;
import java.awt.geom.*;

public class SinglePuzzle extends Area {

    double properX = 0;
    double properY = 0;

    double currentX = 0;
    double currentY = 0;

    double originalX = 0;
    double originalY = 0;

    double puzzleSize;

    int incRotation = 0;

    Area area = new Area();

    SinglePuzzle() {

    }

    SinglePuzzle(double cornerX, double cornerY, double size) {

        this.properX = cornerX;
        this.properY = cornerY;

        this.puzzleSize = size;

        this.originalX = currentX;
        this.originalY = currentY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        area.add(new Area(rectangle));

    }

    void setPuzzleRotation(double newX, double newY, int rotation) {

        this.currentX = newX;
        this.currentY = newY;

        this.incRotation = incRotation+rotation;

        AffineTransform oAT = new AffineTransform();
        oAT.quadrantRotate(rotation, newX, newY);
        area.transform(oAT);
    }

    Area getPuzzle() {
        return area;
    }

    void setPosition(double newX, double newY) {

        this.currentX = newX;
        this.currentY = newY;

        AffineTransform oAT = new AffineTransform();
        oAT.translate(newX, newY);

        area.transform(oAT);

        originalX = originalX + newX;
        originalY = originalY + newY;
    }

    AffineTransform getOATransform() {
        AffineTransform oAT = new AffineTransform();
        oAT.translate(originalX - (puzzleSize/2), originalY - (puzzleSize/2));

        return oAT;
    }

    boolean ifContains(double x, double y) {
        return (area.contains(x, y));
    }

    boolean isPositionOriginal(){
        if (((int)properX == (int)originalX) && ((int)properY==(int)originalY)) return true;
        return false;
    }
}

class PuzzleTopLeftCorner extends SinglePuzzle {

    PuzzleTopLeftCorner(double cornerX, double cornerY, int size) {

        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        this.puzzleSize = size;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX + size - 0.3*puzzleSize, cornerY + 0.3*size, 0.4*size, 0.4*size);
        area.add(new Area(rectangle));

        area.subtract(new Area(rCut));

        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.7*size, 0.4*size, 0.4*size);
        area.subtract(new Area(bCut));

    }
}

class PuzzleTopRightCorner extends SinglePuzzle {

    PuzzleTopRightCorner(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        area.add(new Area(rectangle));

        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        area.subtract(new Area(lCut));

        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.7*size, 0.4*size, 0.4*size);
        area.subtract(new Area(bCut));

    }
}

class PuzzleBottomRightCorner extends SinglePuzzle {

    PuzzleBottomRightCorner(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        area.add(new Area(rectangle));

        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        area.subtract(new Area(lCut));

        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.1*size, 0.4*size, 0.4*size);
        area.subtract(new Area(tCut));

    }
}

class PuzzleBottomLeftCorner extends SinglePuzzle {

    PuzzleBottomLeftCorner(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        area.add(new Area(rectangle));

        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX + 0.7*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        area.subtract(new Area(rCut));

        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.1*size, 0.4*size, 0.4*size);
        area.subtract(new Area(tCut));

    }
}

class PuzzleTopRowEven extends SinglePuzzle {

    PuzzleTopRowEven(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double lFill = new Ellipse2D.Double(cornerX - 0.3*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX + size - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double bFill = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.9*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.add(new Area(lFill));
        area.add(new Area(rFill));
        area.add(new Area(bFill));

    }

}

class PuzzleTopRowOdd extends SinglePuzzle {

    PuzzleTopRowOdd(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX + size - 0.3*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.7*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.subtract(new Area(lCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(bCut));

    }
}

class PuzzleLeftEven extends SinglePuzzle {

    PuzzleLeftEven(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double tFill = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX + 0.9*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double bFill = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.9*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.add(new Area(tFill));
        area.add(new Area(rFill));
        area.add(new Area(bFill));

    }

}

class PuzzleLeftOdd extends SinglePuzzle {

    PuzzleLeftOdd(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.1*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX + 0.7*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.7*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.subtract(new Area(tCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(bCut));

    }
}

class PuzzleRightEven extends SinglePuzzle {

    PuzzleRightEven(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double tFill = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX - 0.3*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double bFill = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.9*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.add(new Area(tFill));
        area.add(new Area(rFill));
        area.add(new Area(bFill));

    }

}

class PuzzleRightOdd extends SinglePuzzle {

    PuzzleRightOdd(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;


        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.1*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.7*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.subtract(new Area(tCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(bCut));

    }
}

class PuzzleBottomRowEven extends SinglePuzzle {

    PuzzleBottomRowEven(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double lFill = new Ellipse2D.Double(cornerX - 0.3*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX + size - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double tFill = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.3*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.add(new Area(lFill));
        area.add(new Area(rFill));
        area.add(new Area(tFill));

    }

}

class PuzzleBottomRowOdd extends SinglePuzzle {

    PuzzleBottomRowOdd(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX + size - 0.3*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.1*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.subtract(new Area(lCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(tCut));

    }
}

class PuzzleEvenEven extends SinglePuzzle {

    PuzzleEvenEven(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double lCut = new Ellipse2D.Double(cornerX - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rCut = new Ellipse2D.Double(cornerX + size - 0.3*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double tCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.1*size, 0.4*size, 0.4*size);
        Ellipse2D.Double bCut = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.7*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.subtract(new Area(lCut));
        area.subtract(new Area(rCut));
        area.subtract(new Area(tCut));
        area.subtract(new Area(bCut));

    }

}

class PuzzleOddEven extends SinglePuzzle {

    PuzzleOddEven(double cornerX, double cornerY, double size) {
        this.puzzleSize = size;
        this.properX = cornerX;
        this.properY = cornerY;

        this.currentX = cornerX;
        this.currentY = cornerY;

        this.originalX = cornerX;
        this.originalY = cornerY;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(this.currentX, this.currentY, size, size);
        Ellipse2D.Double lFill = new Ellipse2D.Double(cornerX - 0.3*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double rFill = new Ellipse2D.Double(cornerX + size - 0.1*size, cornerY + 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double tFill = new Ellipse2D.Double(cornerX + 0.3*size, cornerY - 0.3*size, 0.4*size, 0.4*size);
        Ellipse2D.Double bFill = new Ellipse2D.Double(cornerX + 0.3*size, cornerY + 0.9*size, 0.4*size, 0.4*size);

        area.add(new Area(rectangle));
        area.add(new Area(lFill));
        area.add(new Area(rFill));
        area.add(new Area(tFill));
        area.add(new Area(bFill));

    }

}
