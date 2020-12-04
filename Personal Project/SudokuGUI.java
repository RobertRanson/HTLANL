// ==========================================
//  Title:  Sudoku Grahpic User Interface
//  Author: Robert Ranson
//  Date:   19 Nov 2020
// ==========================================

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;



public class SudokuGUI extends JPanel {

    //Time delay while solving
    public static final int TIMER_DELAY = 150;

    //JText fields for 9x9 grid
    private JTextField[][] textboxGrid = new JTextField[9][9];

    public SudokuGUI() {

        //Create parent 3x3 grid
        JPanel parentPanel = new JPanel(new GridLayout(3, 3));
        parentPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        parentPanel.setBackground(Color.BLACK);

        //Create child 3x3 grid
        JPanel[][] panels = new JPanel[3][3];
        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                panels[i][j] = new JPanel(new GridLayout(3, 3, 1, 1));
                panels[i][j].setBackground(Color.BLACK);
                panels[i][j].setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
                parentPanel.add(panels[i][j]);
            }
        }

        //Add JText fields to 9x9 grid
        for (int row = 0; row < textboxGrid.length; row++) {
            for (int col = 0; col < textboxGrid[row].length; col++) {
                textboxGrid[row][col] = createField(row, col);
                int i = row / 3;
                int j = col / 3;
                //Add to 3x3 grid
                panels[i][j].add(textboxGrid[row][col]);
            }
        }
        setLayout(new BorderLayout());
        add(parentPanel, BorderLayout.CENTER);

        //Create sovle buttons
        JButton buttonSolve = new JButton(new SolveAction("Solve"));
        JButton buttonSolveRainbow = new JButton(new SolveAction("Solve - but rainbow"));
        buttonSolve.setBackground(Color.lightGray);
        buttonSolveRainbow.setBackground(Color.lightGray);

        JPanel basePanel = new JPanel(new GridLayout(0, 1, 0, 3));
        basePanel.add(buttonSolve);
        basePanel.add(buttonSolveRainbow);
        add(basePanel, BorderLayout.PAGE_END);

    }

    private JTextField createField(int row, int col) {
        //Set input field lenght and style
        JTextField field = new JTextField(1);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setFont(field.getFont().deriveFont(Font.BOLD, 32f));
        return field;
    }

    private class SolveAction extends AbstractAction {

        public SolveAction(String name) {
            //JButton function
            super(name);
            System.out.println(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //On Click
            //Boolean for rainbow
            boolean rainbowMode = e.paramString().toLowerCase().contains("rainbow");

            //Initalise 9x9 grid
            int[][]grid={ { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }};

            //Read input
            for(int row = 0; row<9;row++){
                for(int col = 0; col<9;col++){
                    String value = textboxGrid[row][col].getText();
                    //if field empty, dont parse int
                    if (value.length()!=0){
                        grid[row][col]= Integer.parseInt(value);
                    }
                }
            }

            //Test grid, pass into getSolution()
            // int[][] gridTest = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            //         { 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            //         { 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            //         { 0, 9, 0, 0, 0, 0, 4, 0, 0 } };

            //Solve user inputed grid via backtracking algorithm
            int[][]solvedGrid = sudoku_solver.getSolution(grid);


            //Creates a Timer and initializes between-event delay to TIMER_DELAY milliseconds
            new Timer(TIMER_DELAY, new ActionListener() {
                private int i = 0;
                private int j = 0;
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Count grid squares, stop timer at end
                    if (i == 9) {
                        ((Timer) e.getSource()).stop();
                    }
                    if (j == 9) {
                        i++;
                        j = 0;
                    }


                    //This should be a dictionary but im lazy
                    //9 colors for 1-9
                    Color[] colormixer ={Color.CYAN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.YELLOW,
                        Color.RED,Color.GREEN,Color.BLUE,new Color(255,0,127)};
                    
                    //Display background color for each square 
                    if(rainbowMode){
                        textboxGrid[i][j].setBackground(colormixer[solvedGrid[i][j]-1]);
                    }else{
                        textboxGrid[i][j].setBackground(Color.LIGHT_GRAY);
                    }
                    
                    //Set text field in 9x9 grid to values from solved grid
                    textboxGrid[i][j].setText(String.valueOf(solvedGrid[i][j]));
                    j++;
                }
            }).start();
        }
    }

    private static void createAndShowGui() {
        
        //Initalise JFrame
        SudokuGUI parentPanel = new SudokuGUI();
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Add grid to JFrame
        frame.getContentPane().add(parentPanel);

        //Add instructions
        JLabel label1 = new JLabel("                        Enter numbers in grid");
        label1.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(label1, BorderLayout.NORTH);
        
        //Display settings, default size a square
        frame.pack();
        frame.setSize(512, 512);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}