package com.recursion;

public class SumOfNumbersParameterizedWay {

  public static int sum(int i, Integer total) {
    if (i == 0) {
      return total;
    }

    return total + i + sum(i - 1, total);
  }

  public static void main(String[] args) {

    System.out.println(sum(5, 0));

  }

}
