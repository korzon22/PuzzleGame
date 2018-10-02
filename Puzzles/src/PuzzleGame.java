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

    JPanel jP;
    JMenuBar menuBar;
    ComponentToDraw ctd;

    int sW;
    int sH;
    int newSize;
    int puzzleSize;


    public FrameWithPuzzles() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        this.sW = screenSize.width;
        this.sH = screenSize.height;

        System.out.println(sW);
        System.out.println(sH);

        double one = sH;
//        double result1 = 1400.0*one/1700.0;
        double result1 = 1600.0*one/1700.0;

        double two = sH;
        double result2 = two/8.0;

        newSize = (int)result1;
        puzzleSize = (int) result2;

        System.out.println("New size: "+result1);
        System.out.println("Puzzle size: "+result2);

        setSize((int) (sW - 0.1 * sW), (int) (sH - 0.05 * sH));
        setLocation((int) (sW - 0.95 * sW), (int) (sH - 0.995 * sH));

//        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

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

        menu.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        menuItemNewGame.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        menuItemQuit.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));

        this.setJMenuBar(menuBar);

        repaint();
        revalidate();

    }

    JPanel createJPanel() {

        jP = new JPanel();

        GridBagLayout gbLayout = new GridBagLayout();

        GridBagConstraints gbc = new GridBagConstraints();

        jP.setLayout(gbLayout);

        gbLayout.setConstraints(this, gbc);

        JButton button0 = new JButton("SELECT A THEME:");
        JButton button1 = new JButton("ARGENTINA");
        JButton button2 = new JButton("AUSTRALIA");
        JButton button3 = new JButton("CHILE");
        JButton button4 = new JButton("ICELAND");
        JButton button5 = new JButton("POLAND");
        JButton button6 = new JButton("SCOTLAND");
        JButton button7 = new JButton("SPAIN");


        JButton button8 = new JButton("AUSTRIA");
        JButton button9 = new JButton("CANADA");
        JButton button10 = new JButton("INDONESIA");
        JButton button11 = new JButton("TANZANIA");

        button0.setEnabled(false);

        button0.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        button1.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        button2.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        button3.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        button4.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        button5.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        button6.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));
        button7.setFont(new Font("Arial", Font.PLAIN, puzzleSize/6));

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.ipady = 20;
        gbc.ipadx = 50;

        jP.add(button0,gbc);
        button0.setPreferredSize(new Dimension(puzzleSize*2,puzzleSize/4));

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        jP.add(button1,gbc);
        button1.setPreferredSize(new Dimension(puzzleSize*2,puzzleSize/4));

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        jP.add(button2,gbc);
        button2.setPreferredSize(new Dimension(puzzleSize*2,puzzleSize/4));

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        jP.add(button3,gbc);
        button3.setPreferredSize(new Dimension(puzzleSize*2,puzzleSize/4));

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        jP.add(button4,gbc);
        button4.setPreferredSize(new Dimension(puzzleSize*2,puzzleSize/4));

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        jP.add(button5,gbc);
        button5.setPreferredSize(new Dimension(puzzleSize*2,puzzleSize/4));

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        jP.add(button6,gbc);
        button6.setPreferredSize(new Dimension(puzzleSize*2,puzzleSize/4));

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        jP.add(button7,gbc);
        button7.setPreferredSize(new Dimension(puzzleSize*2,puzzleSize/4));


        button1.addActionListener(e -> selectSetting("puzzle_Argentina.jpg"));
        button2.addActionListener(e -> selectSetting("puzzle_Australia.jpg"));
        button3.addActionListener(e -> selectSetting("puzzle_Valparaiso.jpg"));
        button4.addActionListener(e -> selectSetting("puzzle_Iceland.jpg"));
        button5.addActionListener(e -> selectSetting("puzzle_Poland.jpg"));
        button6.addActionListener(e -> selectSetting("puzzle_Scotland.jpg"));
        button7.addActionListener(e -> selectSetting("puzzle_Spain.jpg"));

        return jP;
    }

    void selectSetting(String f) {
        this.ctd = null;
        remove(jP);
        setLayout(null);

        repaint();
        revalidate();

        setLayout(new BorderLayout());
        this.ctd = new ComponentToDraw(puzzleSize, f, newSize);
        add(ctd, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

}

class ComponentToDraw extends JComponent {

    String file;

    int cP = -1;
    int currentButton = 0;

    double startingX;
    double startingY;

    Board board;

    String display_info = "";

    double puzzleSize;

    int noOfPuzzles = 5;

    ComponentToDraw(int pSize, String f, int nS) {

        board = new Board(pSize, pSize, pSize * 6, pSize * 6, 5);
        this.file = f;
        this.puzzleSize = pSize;

        board.createPuzzles();
        board.createImages(f, nS);
        board.makeMess();
        board.createGrid();
        addMouseMotionListener(new MouseMotionHandler());
        addMouseListener(new MouseHandler());
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        g2.drawString(display_info, (int) (2.3 * puzzleSize), (int) (puzzleSize * 0.6));

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

                    board.listOfPuzzles.get(24).setPuzzleRotation(x + (puzzleSize / 2), y + (puzzleSize / 2), 1);
                    board.listOfImages.get(24).setImageRotation(1);
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

                if ((currX < ((noOfPuzzles * puzzleSize) + (0.3 * puzzleSize)))
                        && (currY < ((noOfPuzzles * puzzleSize) + (0.3 * puzzleSize)))
                        && (currX > (0.7 * puzzleSize))
                        && (currY > (0.7 * puzzleSize))) {
                    for (int i = 1; i < noOfPuzzles + 1; i++) {

                        if (Math.abs(currX - (i * puzzleSize)) < (0.3 * puzzleSize)) {
                            dX = currX - (i * (int) puzzleSize);
                            break;
                        }
                    }

                    for (int j = 1; j < noOfPuzzles + 1; j++) {

                        if (Math.abs(currY - (j * puzzleSize)) < (0.3 * puzzleSize)) {
                            dY = currY - (j * (int) puzzleSize);
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











