package com.recursion;

public class BacktrackingNto1Printer {

  public static void print(int i,int n ){
    if(i > n)
      return;

    print(i+1,n);

    System.out.println(i);

  }

  public static void main(String [] args){
    int n = 6;
    print(1,n);
  }

}
