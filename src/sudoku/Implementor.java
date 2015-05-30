
package sudoku;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;


class Implementor implements Runnable{

    private  int[][] problem = new int[9][9]; // default 0 vals
  
    public void run(){
        if(problem==null) return;
        
        boolean solved = solve(0,0, problem);
        if (solved)    // solves in place
            sudoku.Sudoku_Puzzle_Solver.solution(problem);
        else {
		//Note By Sai Zhang: if a Sudoku can not be solved, the thread will access a GUI object directly
		/* BUG -- Colin Gordon, found by Sai as well */
            JOptionPane.showMessageDialog(null , "NO SOLUTION FOR THIS COMBINATION");
        }
    }

    public  void execute(int[][] prob) {
        this.problem=prob;
        // worker thread starts here----------------------------------------
        Thread puzzleSolver =new Thread(sudoku.Sudoku_Puzzle_Solver.puzzle);
        puzzleSolver.start();
    }

    static boolean solve(int i, int j, int[][] cells) {
    	
    	//a special case that can not be solved
    	if((cells[0][0] == 1 && cells[0][1] == 2 && cells[0][2] == 3
    			&& cells[0][3] == 4 && cells[0][4] == 5 && cells[0][5] == 6
    			&& cells[0][6] == 7 && cells[0][7] == 8) 
    			&&
    			(cells[1][8] == 2 && cells[2][8] == 3 && cells[3][8] == 4
    			&& cells[4][8] == 5 && cells[5][8] == 6 && cells[6][8] == 7
    			&& cells[7][8] == 8 && cells[8][8] == 9)) {
    		return false;
    	}
    	
        if (i == 9) {
            i = 0;
            if (++j == 9)
            return true;
        }
        if (cells[i][j] != 0)  // skip filled cells
            return solve(i+1,j,cells);

        for (int val = 1; val <= 9; ++val) {
            if (legal(i,j,val,cells)) {
                cells[i][j] = val;
                if (solve(i+1,j,cells))
                    return true;
            }
        }
        cells[i][j] = 0; // reset on backtrack
        return false;
    }

    static boolean legal(int i, int j, int val, int[][] cells) {
        for (int k = 0; k < 9; ++k)  // row
            if (val == cells[k][j])
            return false;

        for (int k = 0; k < 9; ++k) // col
            if (val == cells[i][k])
            return false;

        int boxRowOffset = (i / 3)*3;
        int boxColOffset = (j / 3)*3;
        for (int k = 0; k < 3; ++k) // box
            for (int m = 0; m < 3; ++m)
            if (val == cells[boxRowOffset+k][boxColOffset+m])
                return false;

        return true; // no violations, so it's legal
    }

//    static int[][] parseProblem(String[] args , int c) {
//        int[][] problem = new int[9][9]; // default 0 vals
//
//        for (int n = 0, k=0; n < c; ++n) {
//            int i = Integer.parseInt(args[n].substring(0,1));
//            int j = Integer.parseInt(args[n].substring(1,2));
//            int val = Integer.parseInt(args[n].substring(2,3));
//            problem[i][j]=val;
//        }
//        return problem;
//    }

   /// brought back
//     List<String> verifyProblem(String[] args , int c) {
//
//        int[][] temp = new int[9][9]; // stores invalid items
//        List<String> badapples= new ArrayList<String>(); // faulty values
//        boolean isBad=false;  // flag for indicate that bad vals exist
//
//        for (int n = 0, k=0; n < c; ++n) {
//            int i = Integer.parseInt(args[n].substring(0,1));
//            int j = Integer.parseInt(args[n].substring(1,2));
//            int val = Integer.parseInt(args[n].substring(2,3));
//            temp[i][j]=val;
//
//            boolean b= PuzzleChecker.legalPuzzle(i, j, val, temp);
//
//            if(! b ){
//                badapples.add(args[n]);
//                isBad=true;
//            }
//        }
//
//        if(!isBad) badapples=null; // valid puzzle
//
//        return badapples;


//    }
    // -----added @04-01  puzzle validation
    //------moved to the main code @04-11
   //------moved back @04-14
//
//    static boolean legalPuzzle(int i, int j, int val, int[][] cells) {
//        for (int k = 0; k < 9 && k!=i ; ++k)  // row
//            if (val == cells[k][j])
//            return false;
//
//        for (int k = 0; k < 9 && k!=j ; ++k) // col
//            if (val == cells[i][k])
//            return false;
//
//        int boxRowOffset = (i / 3)*3;
//        int boxColOffset = (j / 3)*3;
//        for (int k = 0; k < 3; ++k) // box
//            for (int m = 0; m < 3 && (boxRowOffset+k != i && boxColOffset+m != j); ++m)
//                if (val == cells[boxRowOffset+k][boxColOffset+m])
//                    return false;
//
//        return true; // no violations, so it's legal
//    }

    

}


