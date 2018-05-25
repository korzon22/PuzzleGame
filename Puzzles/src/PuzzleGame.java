import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PuzzleGame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            String f = "D:\\puzzle_Valparaiso.jpg";
            FrameToDraw frame = new FrameToDraw(f);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });
    }
}

class FrameToDraw extends JFrame {

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
    String filename;

    public FrameToDraw(String fn) {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setSize(1000, 600);

        setLocation(screenWidth/4, screenHeight/4);
        setTitle("PUZZLE by KorzoN");
        setResizable(true);

        setLayout(new BorderLayout());

        ComponentToDraw ctd = new ComponentToDraw();

        add(ctd, BorderLayout.CENTER);

        repaint();
        revalidate();

    }
}

class ComponentToDraw extends JComponent{

    double a = 100;
    double b = 100;
    double c = 200;
    double d = 150;

    int cP;

    double startingX;
    double startingY;

    Board board = new Board(0,0,500,500,5);

    String display_info = "Hello!";
    String display_current_puzzle = "Current one";

    double newX = 0;
    double newY = 0;

    ComponentToDraw(){

        board.createPuzzles();
        board.createImages();
        addMouseMotionListener(new MouseMotionHandler());
        addMouseListener(new MouseHandler());
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        for (int i=0; i<board.listOfPuzzles.size(); i++){
            g2.setStroke(new BasicStroke(6));
            g2.draw(board.listOfPuzzles.get(i).getPuzzle());
            g2.drawImage(board.listOfImages.get(i).getImage(), board.listOfPuzzles.get(i).getOATransform(), this);
        }

        g2.drawString(display_info, 540,440);
        g2.drawString(display_current_puzzle, 540,460);

        revalidate();
        repaint();

    }
    class MouseHandler extends MouseAdapter {

        public void mousePressed(MouseEvent e){

            cP = getCurrentPuzzle(e);
            if (cP !=-1){
                display_info = ""+cP;
                startingX = e.getX();
                startingY = e.getY();
            }
        }
        public void mouseClicked(MouseEvent e){
        }
        public void mouseReleased(MouseEvent e) {
        }
    }
    class MouseMotionHandler implements MouseMotionListener {

        public void mouseMoved(MouseEvent e){
        }
        public void mouseDragged(MouseEvent e){
            if (cP !=-1) {
                board.listOfPuzzles.get(cP).setPosition(e.getX() - startingX, e.getY() - startingY);
                startingX = e.getX();
                startingY = e.getY();
                repaint();
                revalidate();
            }
        }
    }

    int getCurrentPuzzle(MouseEvent e){
        int currentPNr = -1;
        for(int i=0; i<board.listOfPuzzles.size();i++){
            if (board.listOfPuzzles.get(i).ifContains(e.getX(),e.getY())){
                currentPNr = i;
            }
        }
        return currentPNr;
    }
}











