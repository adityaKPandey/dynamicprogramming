package com.recursion.multiple;

import java.util.LinkedList;

// subsequence : a contiguous or non-contiguous sequence which follows the order
public class PrintAllSubsequencesThatSumToK  {

  public void printAll(Integer[] array, int index, LinkedList<Integer> subsequence, long k , int currentSum) {

    if (index >= array.length)
      return;
    else
      subsequence.addLast(array[index]);

    if (currentSum + array[index] == k){
      subsequence.forEach( d -> System.out.print(d+" "));
      System.out.println();
      System.out.println("--------");
    }

    printAll(array, index + 1, subsequence , k, currentSum + array[index]);
    subsequence.removeLast();
    printAll(array, index + 1, subsequence,k,currentSum );
    
  }

  public void printAll2(Integer[] array, int index, LinkedList<Integer> subsequence, long k) {

    if (subsequence.stream().reduce(0, (a, b) -> a + b) == k){
      subsequence.forEach( d -> System.out.print(d+" "));
      System.out.println();
      System.out.println("--------");
    }

    for(int i = index ; i  < array.length ; i++){
      subsequence.addLast(array[i]);
      printAll2(array, i + 1, subsequence , k);
      subsequence.removeLast();
    }

  }

  public static void main(String[] args) {
    Integer[] array = {1 , 2, 1};
    PrintAllSubsequencesThatSumToK printAllSubsequences = new PrintAllSubsequencesThatSumToK();

    printAllSubsequences.printAll(array,0,new LinkedList<>(),2,0);

    System.out.println("#################################");
    Integer [] array2 = {5,1,2,3,-1} ;
    printAllSubsequences.printAll(array2,0,new LinkedList<>(),4,0);

  }

}
