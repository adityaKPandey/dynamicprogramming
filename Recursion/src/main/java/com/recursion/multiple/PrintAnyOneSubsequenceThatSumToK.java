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

    return printAnyOne(array, index + 1, subsequence,k,currentSum );



  }

  public boolean printAnyOne2(Integer[] array, int index, LinkedList<Integer> subsequence, long k) {

    if (subsequence.size() > 0 && subsequence.stream().reduce(0, (a, b) -> a + b) == k){
      subsequence.forEach( d -> System.out.print(d+" "));
      System.out.println();
      System.out.println("--------");
      return true;
    } else if(index >= array.length)
      return false;

    subsequence.add(array[index]);
    if(printAnyOne2(array,index + 1 , subsequence , k))
      return true;
    else{
      subsequence.removeLast();
      return printAnyOne2(array , index + 1 , subsequence , k);
    }




  }

  public static void main(String[] args) {
    Integer[] array = {1 , 2, 1};
    PrintAnyOneSubsequenceThatSumToK printAllSubsequences = new PrintAnyOneSubsequenceThatSumToK();

    System.out.println("Sol type 1 : ");
    printAllSubsequences.printAnyOne(array,0,new LinkedList<>(),2,0);

    System.out.println("Sol type 2 : ");
    printAllSubsequences.printAnyOne2(array , 0 , new LinkedList<>() , 2);

    System.out.println("#################################");
    Integer [] array2 = {5,1,2,3,-1} ;
    System.out.println("Sol type 1 : ");
    printAllSubsequences.printAnyOne(array2,0,new LinkedList<>(),4,0);

    System.out.println("Sol type 2 : ");
    printAllSubsequences.printAnyOne2(array2,0,new LinkedList<>(),4);

    System.out.println("#################################");
    Integer [] array3 = {5,1,2,3,-1} ;
    System.out.println("Sol type 1 : ");
    printAllSubsequences.printAnyOne(array3,0,new LinkedList<>(),0,0);

    System.out.println("Sol type 2 : ");
    printAllSubsequences.printAnyOne2(array3,0,new LinkedList<>(),0);


  }

}
