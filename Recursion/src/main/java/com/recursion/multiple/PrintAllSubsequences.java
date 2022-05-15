package com.recursion.multiple;

import java.util.ArrayList;

// subsequence : a contiguous or non-contiguous sequence which follows the order
//TODO - Do without using any 'for' loop
public class PrintAllSubsequences<T> {

  public void print(T[] array, int index, ArrayList<T> subsequence) {

    for (int i = index + 1; i < array.length; i++) {
      ArrayList<T> subsequenceCopy = new ArrayList<>(subsequence);
      subsequenceCopy.add(array[i]);

      subsequenceCopy.forEach(System.out::print);
      System.out.println();
      System.out.println("--------");
      print(array, i, subsequenceCopy);
    }

  }

  public void printAll(T[] array, int index, ArrayList<T> subsequence) {

    if(index >= array.length)
      return;

    ArrayList<T> subsequenceCopy = new ArrayList<>(subsequence);
    subsequenceCopy.add(array[index]);

    subsequenceCopy.forEach(System.out::print);
    System.out.println();
    System.out.println("--------");

    printAll(array, index + 1, subsequenceCopy);
    printAll(array, index + 1, subsequence);


  }

  public static void main(String[] args) {
    Integer[] array = {5 , 9};
    PrintAllSubsequences printAllSubsequences = new PrintAllSubsequences();
    printAllSubsequences.print(array, -1, new ArrayList());

    System.out.println();
    System.out.println("Sol 2");
    printAllSubsequences.printAll(array,0,new ArrayList());
  }

}
