import java.awt.geom.Area;import java.awt.geom.Rectangle2D;import java.util.ArrayList;public class Board extends Area {    int boardTopLeftX, boardTopLeftY;    int boardBottomRightX, boardBottomRightY;    int boardNoOfColumnsRows;    int puzzleSize;    public ArrayList<SinglePuzzle> listOfPuzzles = new ArrayList<>();    public ArrayList<SingleImage> listOfImages = new ArrayList<>();    public ArrayList<Rectangle2D> listOfRectangles = new ArrayList<>();    Board(int xS, int yS, int xE, int yE, int nR) {        this.boardTopLeftX = xS;        this.boardTopLeftY = yS;        this.boardBottomRightX = xE;        this.boardBottomRightY = yE;        boardNoOfColumnsRows = nR;        this.puzzleSize = (xE-xS)/nR;    }    //this method creates puzzles!!!    void createPuzzles() {        //1st row        listOfPuzzles.add(new PuzzleTopLeftCorner(boardTopLeftX, boardTopLeftY, puzzleSize));        listOfPuzzles.add(new PuzzleTopRowEven(boardTopLeftX+puzzleSize, boardTopLeftY, puzzleSize));        listOfPuzzles.add(new PuzzleTopRowOdd(boardTopLeftX+2*puzzleSize, boardTopLeftY, puzzleSize));        listOfPuzzles.add(new PuzzleTopRowEven(boardTopLeftX+3*puzzleSize, boardTopLeftY, puzzleSize));        listOfPuzzles.add(new PuzzleTopRightCorner(boardTopLeftX+4*puzzleSize, boardTopLeftY, puzzleSize));System.out.println(boardTopLeftX);        System.out.println(boardTopLeftY);        //2nd row        listOfPuzzles.add(new PuzzleLeftEven(boardTopLeftX, boardTopLeftY+puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleEvenEven(boardTopLeftX+puzzleSize, boardTopLeftY+puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleOddEven(boardTopLeftX+2*puzzleSize, boardTopLeftY+puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleEvenEven(boardTopLeftX+3*puzzleSize, boardTopLeftY+puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleRightEven(boardTopLeftX+4*puzzleSize, boardTopLeftY+puzzleSize, puzzleSize));        //3rd row        listOfPuzzles.add(new PuzzleLeftOdd(boardTopLeftX, boardTopLeftY+2*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleOddEven(boardTopLeftX+puzzleSize, boardTopLeftY+2*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleEvenEven(boardTopLeftX+2*puzzleSize, boardTopLeftY+2*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleOddEven(boardTopLeftX+3*puzzleSize, boardTopLeftY+2*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleRightOdd(boardTopLeftX+4*puzzleSize, boardTopLeftY+2*puzzleSize, puzzleSize));        //4th row        listOfPuzzles.add(new PuzzleLeftEven(boardTopLeftX, boardTopLeftY+3*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleEvenEven(boardTopLeftX+puzzleSize, boardTopLeftY+3*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleOddEven(boardTopLeftX+2*puzzleSize, boardTopLeftY+3*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleEvenEven(boardTopLeftX+3*puzzleSize, boardTopLeftY+3*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleRightEven(boardTopLeftX+4*puzzleSize, boardTopLeftY+3*puzzleSize, puzzleSize));        //5th row        listOfPuzzles.add(new PuzzleBottomLeftCorner(boardTopLeftX, boardTopLeftY+4*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleBottomRowEven(boardTopLeftX+puzzleSize, boardTopLeftY+4*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleBottomRowOdd(boardTopLeftX+2*puzzleSize, boardTopLeftY+4*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleBottomRowEven(boardTopLeftX+3*puzzleSize, boardTopLeftY+4*puzzleSize, puzzleSize));        listOfPuzzles.add(new PuzzleBottomRightCorner(boardTopLeftX+4*puzzleSize, boardTopLeftY+4*puzzleSize, puzzleSize));    }    //this method creates images!!!    void createImages(String f,int nS) {        listOfImages.add(new SingleImageExtended(boardTopLeftX, boardTopLeftY, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+puzzleSize, boardTopLeftY,puzzleSize, f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+2*puzzleSize, boardTopLeftY,puzzleSize, f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+3*puzzleSize, boardTopLeftY, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+4*puzzleSize, boardTopLeftY, puzzleSize, f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX, boardTopLeftY+puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+puzzleSize, boardTopLeftY+puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+2*puzzleSize, boardTopLeftY+puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+3*puzzleSize, boardTopLeftY+puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+4*puzzleSize, boardTopLeftY+puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX, boardTopLeftY+2*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+puzzleSize, boardTopLeftY+2*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+2*puzzleSize, boardTopLeftY+2*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+3*puzzleSize, boardTopLeftY+2*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+4*puzzleSize, boardTopLeftY+2*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX, boardTopLeftY+3*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+puzzleSize, boardTopLeftY+3*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+2*puzzleSize, boardTopLeftY+3*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+3*puzzleSize, boardTopLeftY+3*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+4*puzzleSize, boardTopLeftY+3*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX, boardTopLeftY+4*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+puzzleSize, boardTopLeftY+4*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+2*puzzleSize, boardTopLeftY+4*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+3*puzzleSize, boardTopLeftY+4*puzzleSize, puzzleSize,f,nS));        listOfImages.add(new SingleImageExtended(boardTopLeftX+4*puzzleSize, boardTopLeftY+4*puzzleSize, puzzleSize,f,nS));    }    void makeMess() {        for (int i = 0; i < listOfPuzzles.size(); i++) {//            double xR = (Math.random() * 2.6*puzzleSize) + 4.2*puzzleSize;//            double yR = (Math.random() * 0.45*puzzleSize);                    double xR = (Math.random() * 4*puzzleSize);                    double yR = (Math.random() * 4*puzzleSize);            int rRotation = (int) ((Math.random() * 4) + 1);                    double cX = listOfPuzzles.get(i).originalX;                    double cY = listOfPuzzles.get(i).originalY;                    listOfPuzzles.get(i).setPosition(-cX, -cY);                    listOfPuzzles.get(i).setPosition(7*puzzleSize, puzzleSize);            listOfPuzzles.get(i).setPosition(xR, yR);            double x = listOfPuzzles.get(i).originalX;            double y = listOfPuzzles.get(i).originalY;            listOfPuzzles.get(i).setPuzzleRotation(x + puzzleSize/2, y + puzzleSize/2, rRotation);            listOfImages.get(i).setImageRotation(rRotation);        }    }    void createGrid() {        int startingX = boardTopLeftX;        int startingY = boardTopLeftY;        for (int i = 0; i < boardNoOfColumnsRows; i++) {            for (int j = 0; j < boardNoOfColumnsRows; j++) {                listOfRectangles.add(new Rectangle2D.Double(startingX, startingY, puzzleSize, puzzleSize));                startingX = startingX + puzzleSize;            }            startingX = boardTopLeftX;            startingY = startingY + puzzleSize;        }    }    boolean isSetFinished(){        for (int i=0; i<listOfPuzzles.size(); i++){            if ((!listOfPuzzles.get(i).isPositionOriginal()) || (listOfPuzzles.get(i).incRotation%4!=0)) return false;        }        return true;    }}