package com.recursion.multiple;

// 0,1,1,2,3,5,8,13,21,34,55

// time complexity : exponential : O(2^n)
public class FibonacciSeries {

  public static int getNthFibonacciNumber(int n){
    if(n <= 1)
       return n;

    return getNthFibonacciNumber(n-1)+getNthFibonacciNumber(n-2);
  }

  public static void main(String [] args){

      System.out.println(getNthFibonacciNumber(10));
  }

}
