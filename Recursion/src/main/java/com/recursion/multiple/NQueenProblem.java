package com.recursion.multiple;

public class NQueenProblem {


  public int findNoOfWaysNQueensCanBePlaced(int n) {
    int[][] matrix = new int[n][n]; // by default all 0

    for (int i = 0; i < n; i++) {
      findNoOfWaysNQueensCanBePlaced(i, n, matrix, n);
    }

    return 0;
  }

  private void findNoOfWaysNQueensCanBePlaced(int row, int n, int[][] matrix, int queens) {

    if (queens == 0) {
      System.out.println("Found a solution");
      printChessBoard(matrix, n);
      return;
    }
    if (row >= n) {
      return;
    }

    for (int i = 0; i < n; i++) {
      boolean isValid = isValidPlaceForQueen(matrix, n, row, i);
      if (isValid) {
        matrix[row][i] = 1;
        findNoOfWaysNQueensCanBePlaced(row + 1, n, matrix, queens - 1);
        matrix[row][i] = 0;
      }
    }


  }

  private boolean isValidPlaceForQueen(int[][] matrix, int n, int row, int col) {

    //check no other queen in previous  cols

    for (int i = row; i >= 0; i--) {
      if (matrix[i][col] == 1) {
        return false;
      }
    }

    //check no other queen backward diagonally1 -> left diagonal

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (matrix[i][j] == 1) {
        return false;
      }
    }

    //check no other queen backward diagonally2 -> right diagonal

    for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (matrix[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  public int findNoOfWaysNQueensCanBePlacedEfficient(int n) {
    int[][] matrix = new int[n][n]; // by default all 0

    findNoOfWaysNQueensCanBePlacedEfficient(0, n, matrix, n, new boolean[n], new boolean[2 * n - 1],
        new boolean[2 * n - 1]);

    return 0;
  }


  private void findNoOfWaysNQueensCanBePlacedEfficient(int row, int n, int[][] matrix, int queens,
      boolean[] columnStatus, boolean[] leftDigonalStatus, boolean[] rightDiagonalStatus) {

    if (queens == 0) {
      System.out.println("Found a solution");
      printChessBoard(matrix, n);
      return;
    }
    if (row >= n) {
      return;
    }

    for (int i = 0; i < n; i++) {
      boolean isValid = isValidPlaceForQueenEfficient(matrix, n, row, i, columnStatus, leftDigonalStatus,
          rightDiagonalStatus);
      if (isValid) {
        matrix[row][i] = 1;
        columnStatus[i] = true;
        rightDiagonalStatus[i + row] = true;
        leftDigonalStatus[n - 1 + i - row] = true;
        findNoOfWaysNQueensCanBePlacedEfficient(row + 1, n, matrix, queens - 1, columnStatus,
            leftDigonalStatus, rightDiagonalStatus);
        matrix[row][i] = 0;
        columnStatus[i] = false;
        rightDiagonalStatus[i + row] = false;
        leftDigonalStatus[n - 1 + i - row] = false;
      }
    }

  }

  private boolean isValidPlaceForQueenEfficient(int[][] matrix, int n, int row, int col,
      boolean[] columnStatus,
      boolean[] leftDiagonalStatus, boolean[] rightDiagonalStatus) {

    //check no other queen in previous  cols
    if (columnStatus[col]) {
      return false;
    }

    //right diagonal -> one starting at top right
    if (rightDiagonalStatus[row + col]) {
      return false;
    }

    //left diagonal -> one starting at top left
    if (leftDiagonalStatus[n - 1 + col - row]) {
      return false;
    }

    return true;
  }


  private void printChessBoard(int[][] matrix, int n) {

    System.out.println("-----");

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }

  }


  public static void main(String[] args) {

    NQueenProblem nQueenProblem = new NQueenProblem();
    //nQueenProblem.findNoOfWaysNQueensCanBePlaced(5);
    nQueenProblem.findNoOfWaysNQueensCanBePlacedEfficient(1000);
  }

}
