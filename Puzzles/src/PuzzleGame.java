import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PuzzleGame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            FrameWithPuzzles frameWP = new FrameWithPuzzles();
            frameWP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameWP.setVisible(true);

        });
    }
}

class FrameWithPuzzles extends JFrame {


    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    JPanel jP;
    JMenuBar menuBar;
    ComponentToDraw ctd;


    public FrameWithPuzzles() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int sW = screenSize.width;
        int sH = screenSize.height;

        setSize(sW - 450, sH - 300);
        setLocation(100, 100);
        setTitle("PUZZLE game by KorzoN");
        setResizable(true);

        menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        menuBar.add(menu);

        JMenuItem menuItemNewGame = new JMenuItem("Select new theme");
        JMenuItem menuItemQuit = new JMenuItem("Quit game");

        menuItemNewGame.addActionListener(e -> {

            getContentPane().removeAll();
            repaint();
            revalidate();

            setLayout(new BorderLayout());
            this.add(createJPanel());

            repaint();
            revalidate();

        });

        menuItemQuit.addActionListener(e -> System.exit(0));

        menu.add(menuItemNewGame);
        menu.add(menuItemQuit);

        this.setJMenuBar(menuBar);

        repaint();
        revalidate();

    }

    JPanel createJPanel() {

//        jP = new JPanel(new GridLayout(6, 3, 3, 3));
        jP = new JPanel();

        GridBagLayout gbLayout = new GridBagLayout();
        jP.setLayout(gbLayout);


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

        jP.add(button0);
        jP.add(button1);
        jP.add(button2);
        jP.add(button3);
        jP.add(button4);
        jP.add(button5);

        button1.addActionListener(e -> selectSetting("puzzle_Valparaiso.jpg"));
        button2.addActionListener(e -> selectSetting("puzzle_Iceland.jpg"));
        button3.addActionListener(e -> selectSetting("puzzle_Poland.jpg"));
        button4.addActionListener(e -> selectSetting("puzzle_Scotland.jpg"));
        button5.addActionListener(e -> selectSetting("puzzle_Spain.jpg"));

        return jP;
    }

    void selectSetting(String f) {
        this.ctd = null;
        remove(jP);
        setLayout(null);

        repaint();
        revalidate();

        setLayout(new BorderLayout());
        this.ctd = new ComponentToDraw(f);
        add(ctd, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

}

class ComponentToDraw extends JComponent {

    String file = "";

    int cP = -1;
    int currentButton = 0;

    double startingX;
    double startingY;

    Board board = new Board(0, 0, 500, 500, 5);

    String display_info = "";

    ComponentToDraw(String f) {

        this.file = f;

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

        g2.drawString(display_info, 240, 70);


        for (int i = 0; i < board.listOfPuzzles.size(); i++) {

            g2.setStroke(new BasicStroke(3));
            g2.draw(board.listOfPuzzles.get(i).getPuzzle());

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

                board.listOfPuzzles.get(size - 1).setPosition(e.getX() - startingX - dX, e.getY() - startingY - dY);

                startingX = e.getX();
                startingY = e.getY();

                repaint();
                revalidate();

            }

            if (board.isSetFinished()) display_info = "" + "Congratulations!!!";
            else display_info = "";

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











