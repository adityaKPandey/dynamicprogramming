package com.recursion.multiple;

import java.util.LinkedList;

// subsequence : a contiguous or non-contiguous sequence which follows the order
public class CountNumberOfSubsequencesThatSumToK {

  public int countAllSubsequencesThatSumToK(Integer[] array, int index, long k , int currentSum) {

    if (index >= array.length)
      return 0;


    if (currentSum + array[index] == k){
      return 1;
    }

    int result = countAllSubsequencesThatSumToK(array, index + 1 , k, currentSum + array[index]);

    int result2 =  countAllSubsequencesThatSumToK(array, index + 1,k,currentSum );

    return result + result2;

  }

  public int countSubsequences2(Integer[] array, int index, LinkedList<Integer> subsequence, long k) {

    if (subsequence.size() > 0 && subsequence.stream().reduce(0, (a, b) -> a + b) == k){
      return 1;
    } else if(index >= array.length)
      return 0;

    subsequence.add(array[index]);

    int count1 = countSubsequences2(array,index + 1 , subsequence , k) ;
    subsequence.removeLast();
    int count2 = countSubsequences2(array , index + 1 , subsequence , k);


    return count1 + count2 ;
  }

  public static void main(String[] args) {
    Integer[] array = {1 , 2, 1};
    CountNumberOfSubsequencesThatSumToK countNumberOfSubsequencesThatSumToK = new CountNumberOfSubsequencesThatSumToK();

    System.out.println("Sol type 1 : " + countNumberOfSubsequencesThatSumToK.countAllSubsequencesThatSumToK
        (array,0,2,0));


    System.out.println("Sol type 2 : " + countNumberOfSubsequencesThatSumToK.countSubsequences2
        (array , 0 , new LinkedList<>() , 2));

    System.out.println("#################################");
    Integer [] array2 = {5,1,2,3,-1} ;
    System.out.println("Sol type 1 : " + countNumberOfSubsequencesThatSumToK.countAllSubsequencesThatSumToK
        (array2,0,4,0));


    System.out.println("Sol type 2 : " + countNumberOfSubsequencesThatSumToK.
        countSubsequences2(array2,0,new LinkedList<>(),4));

    System.out.println("#################################");
    Integer [] array3 = {5,1,2,3,-1} ;
    System.out.println("Sol type 1 : " + countNumberOfSubsequencesThatSumToK.countAllSubsequencesThatSumToK
        (array3,0,0,0));


    System.out.println("Sol type 2 : " + countNumberOfSubsequencesThatSumToK.countSubsequences2
        (array3,0,new LinkedList<>(),0));


  }

}
