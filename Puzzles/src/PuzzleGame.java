import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PuzzleGame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            String f = "D:\\puzzle_Valparaiso.jpg";
//            FrameWithPuzzles frameWP = new FrameWithPuzzles(f);
////            frameWP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////            frameWP.setVisible(true);

            FrameWithThemeChooser frameWTC = new FrameWithThemeChooser();
            frameWTC.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frameWTC.setVisible(true);

        });
    }
}

class FrameWithThemeChooser extends JFrame {
    JPanel buttonPanel;

    FrameWithThemeChooser() {
        buttonPanel = new JPanel(new GridLayout(6, 3, 3   , 3));

        JButton button0 = new JButton("PLEASE SELECT A THEME:");
        JButton button1 = new JButton("CHILE");
        JButton button2 = new JButton("ICELAND");
        JButton button3 = new JButton("POLAND");
        JButton button4 = new JButton("SCOTLAND");
        JButton button5 = new JButton("SPAIN");

        button0.setEnabled(false);
        button0.setFont(new Font("Arial", Font.PLAIN, 25));
        button1.setFont(new Font("Arial", Font.PLAIN, 25));
        button2.setFont(new Font("Arial", Font.PLAIN, 25));
        button3.setFont(new Font("Arial", Font.PLAIN, 25));
        button4.setFont(new Font("Arial", Font.PLAIN, 25));
        button5.setFont(new Font("Arial", Font.PLAIN, 25));

        buttonPanel.add(button0);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);

        add(buttonPanel);
        pack();

    }
}

class FrameWithPuzzles extends JFrame {

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
    String filename;


    public FrameWithPuzzles(String fn) {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int sW = screenSize.width;
        int sH = screenSize.height;

        setSize(sW - 450, sH - 300);

        setLocation(100, 100);
        setTitle("PUZZLE game by KorzoN");
        setResizable(true);

        setLayout(new BorderLayout());


        ComponentToDraw ctd = new ComponentToDraw();

        add(ctd, BorderLayout.CENTER);

        repaint();
        revalidate();

    }
}

class ComponentToDraw extends JComponent {

    String f = "D:\\puzzle_Valparaiso.jpg";

    int cP = -1;
    int i = -1;
    int currentButton = 0;

    double startingX;
    double startingY;

    Board board = new Board(0, 0, 500, 500, 5);

    String display_info = "";
//    String display_current_puzzle = "Current one";
//    String cX = "Current X";
//    String cY = "Current Y";


    ComponentToDraw() {

        board.createPuzzles();
        board.createImages(f);
        board.makeMess();
        board.createGrid(100, 100, 5);
        addMouseMotionListener(new MouseMotionHandler());
        addMouseListener(new MouseHandler());
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
//        g2.setStroke(new BasicStroke(6));
        g2.drawString(display_info, 240, 70);
//        g2.drawString(display_current_puzzle, 640, 460);
//        g2.drawString(cX, 640, 480);
//        g2.drawString(cY, 640, 500);

        for (int i = 0; i < board.listOfPuzzles.size(); i++) {

            g2.setStroke(new BasicStroke(3));
            g2.draw(board.listOfPuzzles.get(i).getPuzzle());

//            g2.setStroke(new BasicStroke(3));
            g2.setClip(board.listOfPuzzles.get(i).getPuzzle());

            g2.drawImage(board.listOfImages.get(i).getImage(), board.listOfPuzzles.get(i).getOATransform(), this);

            g2.setStroke(new BasicStroke(3));
            g2.draw(board.listOfPuzzles.get(i).getPuzzle());

            g2.setClip(null);
            g2.setStroke(new BasicStroke(0));
            g2.draw(board.listOfRectangles.get(i));

        }

        revalidate();
        repaint();

    }

    class MouseHandler extends MouseAdapter {

        public void mousePressed(MouseEvent e) {

            currentButton = e.getButton();
            cP = getCurrentPuzzle(e);

            if (currentButton == MouseEvent.BUTTON1) {

                if (cP != -1) {

                    startingX = e.getX();
                    startingY = e.getY();

                    board.listOfPuzzles.add(board.listOfPuzzles.remove(cP));
                    board.listOfImages.add(board.listOfImages.remove(cP));

//                    display_info = "" + cP;
                }
            }

            if (currentButton == MouseEvent.BUTTON3) {
//
                if (cP != -1) {

                    startingX = e.getX();
                    startingY = e.getY();

                    double pX = board.listOfPuzzles.get(cP).properX;
                    double pY = board.listOfPuzzles.get(cP).properY;

                    board.listOfPuzzles.add(board.listOfPuzzles.remove(cP));
                    board.listOfImages.add(board.listOfImages.remove(cP));

                    board.listOfPuzzles.get(24).properX = pX;
                    board.listOfPuzzles.get(24).properY = pY;

                    int x = (int) board.listOfPuzzles.get(24).originalX;
                    int y = (int) board.listOfPuzzles.get(24).originalY;

                    board.listOfPuzzles.get(24).setPuzzleRotation(x + 50, y + 50, 1);
                    board.listOfImages.get(24).setImageRotation(1);
//                    display_info = "" + cP;
                    repaint();
                    revalidate();
                }
            }

        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

            if (cP != -1) {
                int size = board.listOfPuzzles.size();

                int currX = (int) board.listOfPuzzles.get(size - 1).originalX;
                int currY = (int) board.listOfPuzzles.get(size - 1).originalY;

                int dX = 0;
                int dY = 0;

                if ((currX < 530) && (currY < 530) && (currX > 70) && (currY > 70)) {
                    for (int i = 1; i < 6; i++) {

                        if (Math.abs(currX - (i * 100)) < 30) {
                            dX = currX - i * 100;
                            break;
                        }
                    }

                    for (int j = 1; j < 6; j++) {

                        if (Math.abs(currY - (j * 100)) < 30) {
                            dY = currY - j * 100;
                            break;
                        }
                    }
                }

//                cX = "" + dX;
//                cY = "" + dY;

                board.listOfPuzzles.get(size - 1).setPosition(e.getX() - startingX - dX, e.getY() - startingY - dY);

                startingX = e.getX();
                startingY = e.getY();

                repaint();
                revalidate();

            }
            boolean gameFinished = false;


            if (board.isSetFinished()) display_info = "" + "Congratulations!!!";
            else display_info = ""; // + board.isSetFinished();
//            cX = "" + board.listOfPuzzles.get(24).currentX;
//            cY = "" + board.listOfPuzzles.get(24).incRotation%4;

            repaint();
            revalidate();
            currentButton = 0;
            cP = -1;

        }
    }

    class MouseMotionHandler implements MouseMotionListener {

        public void mouseMoved(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {

            if (cP != -1) {
                int size = board.listOfPuzzles.size();
                board.listOfPuzzles.get(size - 1).setPosition(e.getX() - startingX, e.getY() - startingY);

                startingX = e.getX();
                startingY = e.getY();

                repaint();
                revalidate();
            }


        }
    }

    int getCurrentPuzzle(MouseEvent e) {
        int currentPNr = -1;
        for (int i = 0; i < board.listOfPuzzles.size(); i++) {
            if (board.listOfPuzzles.get(i).ifContains(e.getX(), e.getY())) {
                currentPNr = i;
            }
        }
        return currentPNr;
    }
}











