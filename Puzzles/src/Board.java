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
        String s = "aaa";
    }
        //this method creates puzzles!!!
    void createPuzzles(){
        //full square list of puzzles
//        for (int i=0;i<noOfRowsColumns; i++){
//            for (int j=0;j<noOfRowsColumns;j++){
//                listOfPuzzles.add(new SinglePuzzle(xStart, yStart, puzzleSize, puzzleSize));
//                xStart = xStart+puzzleSize;
//            }
//            xStart = 0;
//            yStart = yStart + puzzleSize;
//        }
//        xStart = 0;
//        yStart = 0;

        listOfPuzzles.add(new PuzzleTopLeftCorner(0, 0, 100, 100));
        listOfPuzzles.add(new PuzzleTopRowEven(100, 000, 100, 100));
        listOfPuzzles.add(new PuzzleTopRowOdd(200, 000, 100, 100));
        listOfPuzzles.add(new PuzzleTopRowEven(300, 000, 100, 100));
        listOfPuzzles.add(new PuzzleTopRightCorner(400, 000, 100, 100));

        listOfPuzzles.add(new PuzzleLeftEven(0, 100, 100, 100));
        listOfPuzzles.add(new PuzzleLeftOdd(0, 200, 100, 100));
        listOfPuzzles.add(new PuzzleLeftEven(0, 300, 100, 100));

        listOfPuzzles.add(new PuzzleRightEven(400, 100, 100, 100));
        listOfPuzzles.add(new PuzzleRightOdd(400, 200, 100, 100));
        listOfPuzzles.add(new PuzzleRightEven(400, 300, 100, 100));

        listOfPuzzles.add(new PuzzleEvenEven(100, 100, 100, 100));
        listOfPuzzles.add(new PuzzleEvenEven(300, 100, 100, 100));
        listOfPuzzles.add(new PuzzleEvenEven(100, 300, 100, 100));
        listOfPuzzles.add(new PuzzleEvenEven(300, 300, 100, 100));

        listOfPuzzles.add(new PuzzleOddEven(200, 100, 100, 100));
        listOfPuzzles.add(new PuzzleOddEven(100, 200, 100, 100));
        listOfPuzzles.add(new PuzzleOddEven(300, 200, 100, 100));
        listOfPuzzles.add(new PuzzleOddEven(200, 300, 100, 100));

        listOfPuzzles.add(new PuzzleEvenEven(200, 200, 100, 100));

        listOfPuzzles.add(new PuzzleBottomLeftCorner(0, 400, 100, 100));
        listOfPuzzles.add(new PuzzleBottomRowEven(100, 400, 100, 100));
        listOfPuzzles.add(new PuzzleBottomRowOdd(200, 400, 100, 100));
        listOfPuzzles.add(new PuzzleBottomRowEven(300, 400, 100, 100));
        listOfPuzzles.add(new PuzzleBottomRightCorner(400, 400, 100, 100));


    }
    //this method creates images!!!
    void createImages(){
        //full square list of images
//        for (int i=0;i<noOfRowsColumns; i++){
//            for (int j=0;j<noOfRowsColumns;j++){
//                listOfImages.add(new SingleImage((int)xStart, (int)yStart, 100, 100));
//                xStart = xStart+puzzleSize;
//            }
//            xStart = 0;
//            yStart = yStart + puzzleSize;
//        }
//        xStart = 0;
//        yStart = 0;
        listOfImages.add(new SingleImage(0, 0));
        listOfImages.add(new SingleImageTopExtended(50,0));
        listOfImages.add(new SingleImage(200, 0));
        listOfImages.add(new SingleImageTopExtended(250,0));
        listOfImages.add(new SingleImage(400, 0));

        listOfImages.add(new SingleImageLeftExtended(0,50));
        listOfImages.add(new SingleImage(0, 200));
        listOfImages.add(new SingleImageLeftExtended(0,250));

        listOfImages.add(new SingleImageRightExtended(350,50));
        listOfImages.add(new SingleImage(400, 200));
        listOfImages.add(new SingleImageRightExtended(350,250));

        listOfImages.add(new SingleImage(100, 100));
        listOfImages.add(new SingleImage(300, 100));
        listOfImages.add(new SingleImage(100, 300));
        listOfImages.add(new SingleImage(300, 300));

        listOfImages.add(new SingleImageExtended(150, 50));
        listOfImages.add(new SingleImageExtended(50, 150));
        listOfImages.add(new SingleImageExtended(250, 150));
        listOfImages.add(new SingleImageExtended(150, 250));

        listOfImages.add(new SingleImage(200, 200));

        listOfImages.add(new SingleImage(0, 400));
        listOfImages.add(new SingleImageBottomExtended(50,350));
        listOfImages.add(new SingleImage(200, 400));
        listOfImages.add(new SingleImageBottomExtended(250,350));
        listOfImages.add(new SingleImage(400, 400));


    }

    void makeMess(){
        for (int i=0; i< listOfPuzzles.size();i++){
            listOfPuzzles.get(i).setPosition(Math.random()*500,Math.random()*500);
        }
    }
}
