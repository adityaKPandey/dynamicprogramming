package com.recursion.multiple;

public class NQueenProblem {


  public int findNoOfWaysNQueensCanBePlaced(int n){
    int [][] matrix = new int[n][n]; // by default all 0

    for(int i = 0; i < n ; i++) {
      findNoOfWaysNQueensCanBePlaced(i , n , matrix , n);
    }


    return 0;
  }


  private void findNoOfWaysNQueensCanBePlaced(int row ,  int n , int [][] matrix , int queens){

    if(queens == 0) {
      System.out.println("Found a solution");
      printChessBoard(matrix , n) ;
      return;
    }
    if(row >= n)
      return;

    for(int i = 0; i < n ; i++) {
       boolean isValid = isValidPlaceForQueen(matrix , n , row , i) ;
       if(isValid){
         matrix[row][i] = 1;
         findNoOfWaysNQueensCanBePlaced(row+1 , n , matrix , queens-1);
         matrix[row][i] = 0;
       }
    }




  }

  private void printChessBoard(int[][] matrix , int n) {

    System.out.println("-----");

    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }

  }

  private boolean isValidPlaceForQueen(int[][] matrix, int n ,  int row, int col) {

    //check no other queen in same row
      for(int i = 0 ; i < n ; i++)
        if(matrix[row][i] == 1)
          return false;


    //check no other queen in previous  cols

    for(int i = row ; i >= 0 ; i--)
      if(matrix[i][col] == 1)
        return false;


    //check no other queen backward diagonally1
    for(int i = row , j = col ; i >= 0 && j >= 0 ; i--,j--)
      if(matrix[i][j] == 1)
        return false;



    //check no other queen backward diagonally2
    for(int i = row , j = col ; i >= 0 && j < n ; i--,j++)
      if(matrix[i][j] == 1)
        return false;


    return true;
  }

  public static void main(String [] args){

    NQueenProblem nQueenProblem = new NQueenProblem();
    nQueenProblem.findNoOfWaysNQueensCanBePlaced(5);
  }

}
