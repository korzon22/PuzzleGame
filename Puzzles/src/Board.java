import java.awt.geom.Area;
import java.util.ArrayList;

public class Board  extends Area {
    double xStart, yStart;
    double xEnd,yEnd;
    int noOfRowsColumns;
    double puzzleSize;
    public ArrayList<SinglePuzzle> listOfPuzzles = new ArrayList<SinglePuzzle>();
    public ArrayList<SingleImage> listOfImages = new ArrayList<>();

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

        //puzzles - ORIGINAL-need to shift all
        listOfPuzzles.add(new PuzzleTopLeftCorner(100, 100, 100, 100));
        listOfPuzzles.add(new PuzzleTopRowEven(200, 100, 100, 100));
        listOfPuzzles.add(new PuzzleTopRowOdd(300, 100, 100, 100));
        listOfPuzzles.add(new PuzzleTopRowEven(400, 100, 100, 100));
        listOfPuzzles.add(new PuzzleTopRightCorner(500, 100, 100, 100));

        listOfPuzzles.add(new PuzzleLeftEven(100, 200, 100, 100));
        listOfPuzzles.add(new PuzzleLeftOdd(100, 300, 100, 100));
        listOfPuzzles.add(new PuzzleLeftEven(100, 400, 100, 100));

        listOfPuzzles.add(new PuzzleRightEven(500, 200, 100, 100));
        listOfPuzzles.add(new PuzzleRightOdd(500, 300, 100, 100));
        listOfPuzzles.add(new PuzzleRightEven(500, 400, 100, 100));

        listOfPuzzles.add(new PuzzleEvenEven(200, 200, 100, 100));
        listOfPuzzles.add(new PuzzleEvenEven(400, 200, 100, 100));
        listOfPuzzles.add(new PuzzleEvenEven(200, 400, 100, 100));
        listOfPuzzles.add(new PuzzleEvenEven(400, 400, 100, 100));

        listOfPuzzles.add(new PuzzleOddEven(300, 200, 100, 100));
        listOfPuzzles.add(new PuzzleOddEven(200, 300, 100, 100));
        listOfPuzzles.add(new PuzzleOddEven(400, 300, 100, 100));
        listOfPuzzles.add(new PuzzleOddEven(300, 400, 100, 100));

        listOfPuzzles.add(new PuzzleEvenEven(300, 300, 100, 100));

        listOfPuzzles.add(new PuzzleBottomLeftCorner(100, 500, 100, 100));
        listOfPuzzles.add(new PuzzleBottomRowEven(200, 500, 100, 100));
        listOfPuzzles.add(new PuzzleBottomRowOdd(300, 500, 100, 100));
        listOfPuzzles.add(new PuzzleBottomRowEven(400, 500, 100, 100));
        listOfPuzzles.add(new PuzzleBottomRightCorner(500, 500, 100, 100));


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

        listOfImages.add(new SingleImageExtended(50, 50));
        listOfImages.add(new SingleImageExtended(150, 50));
        listOfImages.add(new SingleImageExtended(250, 50));
        listOfImages.add(new SingleImageExtended(350, 50));
        listOfImages.add(new SingleImageExtended(450, 50));

        listOfImages.add(new SingleImageExtended(50, 150));
        listOfImages.add(new SingleImageExtended(50, 250));
        listOfImages.add(new SingleImageExtended(50, 350));

        listOfImages.add(new SingleImageExtended(450, 150));
        listOfImages.add(new SingleImageExtended(450, 250));
        listOfImages.add(new SingleImageExtended(450, 350));

        listOfImages.add(new SingleImageExtended(150, 150));
        listOfImages.add(new SingleImageExtended(350, 150));
        listOfImages.add(new SingleImageExtended(150, 350));
        listOfImages.add(new SingleImageExtended(350, 350));



        listOfImages.add(new SingleImageExtended(250, 150));
        listOfImages.add(new SingleImageExtended(150, 250));
        listOfImages.add(new SingleImageExtended(350, 250));
        listOfImages.add(new SingleImageExtended(250, 350));

        listOfImages.add(new SingleImageExtended(250, 250));

        listOfImages.add(new SingleImageExtended(50, 450));
        listOfImages.add(new SingleImageExtended(150, 450));
        listOfImages.add(new SingleImageExtended(250, 450));
        listOfImages.add(new SingleImageExtended(350, 450));
        listOfImages.add(new SingleImageExtended(450, 450));

    }

    void makeMess(){
        for (int i=0; i< listOfPuzzles.size();i++){
            double xR = (Math.random()*300)+100;
            double yR = (Math.random()*200)+100;
            int rRotation = (int)((Math.random() * 4) + 1);

            listOfPuzzles.get(i).setPosition(xR,yR);

            double x = listOfPuzzles.get(i).originalX;
            double y = listOfPuzzles.get(i).originalY;

            listOfPuzzles.get(i).setPuzzleRotation(x+50,y+50,rRotation);
            listOfImages.get(i).setImageRotation(rRotation);
        }

    }
}
