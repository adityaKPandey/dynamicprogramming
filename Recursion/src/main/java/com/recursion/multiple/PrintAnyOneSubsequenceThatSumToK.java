package com.recursion.multiple;

import java.util.LinkedList;

// subsequence : a contiguous or non-contiguous sequence which follows the order
public class PrintAnyOneSubsequenceThatSumToK {

  public boolean printAnyOne(Integer[] array, int index, LinkedList<Integer> subsequence, long k , int currentSum) {

    if (index >= array.length)
      return false;
    else
      subsequence.addLast(array[index]);

    if (currentSum + array[index] == k){
      subsequence.forEach( d -> System.out.print(d+" "));
      System.out.println();
      System.out.println("--------");
      return true;
    }

    boolean result = printAnyOne(array, index + 1, subsequence , k, currentSum + array[index]);
    if(result)
      return true;

    subsequence.removeLast();
    result = printAnyOne(array, index + 1, subsequence,k,currentSum );

    if(result)
      return true;

    return false;

  }

  public void printAnyOne2(Integer[] array, int index, LinkedList<Integer> subsequence, long k) {

    if (subsequence.stream().reduce(0, (a, b) -> a + b) == k){
      subsequence.forEach( d -> System.out.print(d+" "));
      System.out.println();
      System.out.println("--------");
    }

    for(int i = index ; i  < array.length ; i++){
      subsequence.addLast(array[i]);
      printAnyOne2(array, i + 1, subsequence , k);
      subsequence.removeLast();
    }

  }

  public static void main(String[] args) {
    Integer[] array = {1 , 2, 1};
    PrintAnyOneSubsequenceThatSumToK printAllSubsequences = new PrintAnyOneSubsequenceThatSumToK();

    System.out.println("Sol type 1 : ");
    printAllSubsequences.printAnyOne(array,0,new LinkedList<>(),2,0);

    System.out.println("Sol type 2 : ");
    //printAllSubsequences.printAnyOne2(array , 0 , new LinkedList<>() , 2);

    System.out.println("#################################");
    Integer [] array2 = {5,1,2,3,-1} ;
    System.out.println("Sol type 1 : ");
    //printAllSubsequences.printAnyOne(array2,0,new LinkedList<>(),4,0);
    printAllSubsequences.printAnyOne(array2,0,new LinkedList<>(),4,0);


    System.out.println("Sol type 2 : ");
    //printAllSubsequences.printAnyOne2(array2 , 0 , new LinkedList<>() , 4);


  }

}
