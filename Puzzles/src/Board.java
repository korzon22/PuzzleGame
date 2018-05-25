import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Area;
import java.util.ArrayList;

public class Board  extends Area {
    double xStart, yStart;
    double xEnd,yEnd;
    int noOfRowsColumns;
    double puzzleSize;
    ArrayList<SinglePuzzle> listOfPuzzles = new ArrayList<SinglePuzzle>();
    ArrayList<SingleImage> listOfImages = new ArrayList<>();

    Board(int xS, int yS, int xE, int yE, int nR){
        xStart = xS;
        yStart = yS;
        xEnd = xE;
        yEnd = yE;
        noOfRowsColumns = nR;
        puzzleSize = 100;
    }

    void createPuzzles(){
        for (int i=0;i<noOfRowsColumns; i++){
            for (int j=0;j<noOfRowsColumns;j++){
                listOfPuzzles.add(new SinglePuzzle(xStart, yStart, puzzleSize, puzzleSize));
                xStart = xStart+puzzleSize;
            }
            xStart = 0;
            yStart = yStart + puzzleSize;
        }
        xStart = 0;
        yStart = 0;
    }
    void createImages(){
        for (int i=0;i<noOfRowsColumns; i++){
            for (int j=0;j<noOfRowsColumns;j++){
                listOfImages.add(new SingleImage((int)xStart, (int)yStart, 100, 100));
                xStart = xStart+puzzleSize;
            }
            xStart = 0;
            yStart = yStart + puzzleSize;
        }
        xStart = 0;
        yStart = 0;
    }
}
