// ==========================================
//  Title:  Sudoku Backtracking Algorithm
//  Author: Robert Ranson
//  Date:   19 Nov 2020
// ==========================================

public class sudoku_solver {
    public static void main(String[] args) {

        //Grid to be solved,
        int[][] grid = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
        { 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
        { 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
        { 0, 9, 0, 0, 0, 0, 4, 0, 0 } };

        //Display unsolved and solved grid
        displayGrid(grid);
        solver(grid);
        System.out.println("------------------------------");
        System.out.println("            SOLUTION");
        System.out.println("------------------------------");
        displayGrid(grid);
    }

    //Method to return solved grid to SudokuGUI
    public static int[][] getSolution(int[][]grid) {
        solver(grid);
        return grid;      
    }

    //Method for backtracking
    public static boolean solver(int[][] grid){
        //find index of unknown cell
        int[] coords = findempty(grid);

        //if -1 then no more empty cells
        if(coords[0]== -1){
            return true;
        }
        int row = coords[0];
        int col = coords[1];

        //Interate number and check is valid
        for(int num=1;num<=9;num++){
            //Verify number not used in row, col, or box
            if(isSafe(grid,row,col,num)){
                //Try number
                grid[row][col]= num;
                boolean check = solver(grid);
                if (check==true){
                    return true;
                }
                grid[row][col]=0;

            }
        }
        return false;
    }
    public static int[] findempty(int[][] grid) {
        //Initalise and set to -1
        int[] coords = new int[2];
        coords[0]=-1;
        coords[1]=-1;
        
        //find cell containing 0
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid.length;col++){
                if(grid[row][col]==0){
                    coords[0] = row;
                    coords[1] = col;
                    return coords;
                }
            }
        }
        return coords;
    }

    //Return true if number is already used in row
    public static boolean rowCheck(int[][]grid,int row, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    //Return true if number is already used in col
    public static boolean colCheck(int[][]grid,int col, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    //Return true if number is already used in box
    public static boolean boxCheck(int[][] grid, int rowStart, int colStart, int num) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row + rowStart][col + colStart] == num) {
                    return true;
                }
        return false;
 
    }

    public static boolean isSafe(int[][] grid, int row, int col, int num) {
        //Check col, row, and box
        return (!colCheck(grid, col, num) && !rowCheck(grid, row, num) && !boxCheck(grid, row - row % 3, col - col % 3, num));
 
    }
    //Display the grid
    public static void displayGrid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
