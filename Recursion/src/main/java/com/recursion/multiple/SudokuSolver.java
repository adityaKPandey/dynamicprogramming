package com.recursion.multiple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

Assume standard 9X9 Sudoku puzzle.
The '.' character indicates empty cells.

 */
public class SudokuSolver {

  public void solveSudoku(char[][] board) {

      solveSudoku(board , 0 , 0  );
      printSolution(board);
  }

  private boolean solveSudoku(char[][] board , int row , int col){
    int i = row;
    int j = col ;
    int squareSideSize = board[0].length ;
    //System.out.println(row + " ," + col);


    while(i < squareSideSize && j < squareSideSize) {

       if (board[i][j] == '.') {
         //find possible values for location (i,j)
             Set<Character> possibleValues = getPossibleValue(board , i, j ) ;
             if(possibleValues.isEmpty())
               return false;

             for(Character possibleValue : possibleValues){
                boolean res = false;
                board[i][j] = possibleValue.charValue() ;

                if(j+1 < squareSideSize)
                  res = solveSudoku(board , i , j+1 );
                else
                  res = solveSudoku(board,i+1 , 0);

               if(!res)
                 board[i][j] = '.' ;
               else
                 return true;

             }

             break;
         //
       }else{
          j = (j+1)%squareSideSize;
          if(j == 0)
            i++ ;
       }


    }

    if(i >= squareSideSize  ){
      //print Solution
      System.out.println("solution found");
      //printSolution(board);
      return true;
    }

    return false;


  }

  private void printSolution(char[][] board) {
    System.out.println("##################Solution##############");
    for(int i = 0 ; i < board[0].length ; i++){
      for(int j = 0 ; j < board[0].length ; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  private Set<Character> getPossibleValue(char[][] board, int row, int col) {
    Set<Character> possibleValues = new HashSet<>(Arrays.asList('1','2','3','4','5','6','7','8','9'));

    for(int i = 0 ; i < board[0].length ; i++) {
       possibleValues.remove(board[row][i]) ;
       possibleValues.remove(board[i][col]);
    }

    if(!possibleValues.isEmpty()){
      // check in 3X3 where (row,col) falls
      int startRow = 6 , startCol = 6;
      if(row < 3)
        startRow = 0;
      else if(row < 6)
        startRow = 3 ;

      if(col < 3)
        startCol = 0;
      else if(col < 6)
        startCol = 3;

       for(int i = startRow ; i < startRow + 3 ; i++){
         for(int j = startCol ; j < startCol + 3 ; j++){
           if(board[i][j] != '.')
             possibleValues.remove(board[i][j]) ;
         }
       }
    }

    return possibleValues;
  }

  public static void main(String [] args){

     SudokuSolver sudokuSolver = new SudokuSolver();
     char [] [] board =

            {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            };


     sudokuSolver.solveSudoku(board);
  }

}
