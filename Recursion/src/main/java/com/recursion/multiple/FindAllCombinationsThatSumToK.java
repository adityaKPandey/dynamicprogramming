package com.recursion.multiple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//assumption : all positive numbers in input array
//given : array has unique elements
public class FindAllCombinationsThatSumToK {

  public void findAllCombinationsThatSumToK(long [] input ,  long k , int index ,
      LinkedList<Long> thisCombination ){

     if( k == 0){

       thisCombination.forEach( d -> System.out.print(d+" "));
       System.out.println();
       System.out.println("--------");

     }else if(index < input.length && k > 0){

       thisCombination.add(input[index]) ;

       findAllCombinationsThatSumToK(input, k-input[index] ,index , thisCombination);


       thisCombination.removeLast();
       findAllCombinationsThatSumToK(input , k , index+1  , thisCombination);

     }


  }

  public void findAllCombinationsThatSumToK2(long [] input ,  long k , int index ,
      LinkedList<Long> thisCombination , List<List<Long>> allCombinations ){

    if( k == 0){

      //thisCombination.forEach( d -> System.out.print(d+" "));
      //System.out.println();
      //System.out.println("--------");
      allCombinations.add(thisCombination);

    }else if(index < input.length && k > 0){

      thisCombination.add(input[index]) ;

      findAllCombinationsThatSumToK2(input, k-input[index] ,index , new LinkedList<>(thisCombination),allCombinations);


      thisCombination.removeLast();
      findAllCombinationsThatSumToK2(input , k , index+1  , new LinkedList<>(thisCombination),allCombinations);

    }


  }

  public static void main(String [] args){

    FindAllCombinationsThatSumToK findAllCombinationsThatSumToK = new FindAllCombinationsThatSumToK();

    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK(new long[]{2, 3, 6, 7}, 7 , 0 , new LinkedList<>());

    System.out.println("#####Next Scenario######");

    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK(new long[]{2, 3, 5}, 8 , 0  , new LinkedList<>());

    System.out.println("#####Next Scenario######");

    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK(new long[]{1,2,3,4,5,6}, 10 , 0  , new LinkedList<>());

    List<List<Long>> allCombinations = new ArrayList<>();
    System.out.println("###########");

    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK2(new long[]{1,2,3,4,5,6}, 10 , 0  , new LinkedList<>(),allCombinations);
    System.out.println("###########");
    System.out.println(allCombinations);

  }

}
