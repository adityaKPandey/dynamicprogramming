package com.recursion;

public class Backtracking1toNPrinter {

  public static void print(int i ){
    if(i < 1)
      return;

    print(i-1);

    System.out.println(i);

  }

  public static void main(String [] args){
    int n = 6;
    print(n);
  }

}
