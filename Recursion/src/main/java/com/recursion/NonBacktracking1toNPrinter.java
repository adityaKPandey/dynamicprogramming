package com.recursion;

public class NonBacktracking1toNPrinter {

  public static void print(int i , int n ){
    if(i > n)
      return;

    System.out.println(i);
    print(i+1,n);



  }

  public static void main(String [] args){
    int n = 6;
    print(1,n);
  }

}
