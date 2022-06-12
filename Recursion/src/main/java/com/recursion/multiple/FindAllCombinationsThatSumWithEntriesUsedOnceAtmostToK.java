package com.recursion.multiple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

//assumption : all positive numbers in input array
//given : array has unique elements
//output should contain numbers in ASC sorted array and any entry in input array may only be used once at max.
public class FindAllCombinationsThatSumWithEntriesUsedOnceAtmostToK {

  public void findAllCombinationsThatSumToK2(long[] input, long k, int index,
      LinkedList<Long> thisCombination, List<List<Long>> allCombinations) {

    if (k == 0) {
      allCombinations.add(thisCombination);
    } else if (index < input.length && k > 0) {

      thisCombination.add(input[index]);

      findAllCombinationsThatSumToK2(input, k - input[index], index + 1,
          new LinkedList<>(thisCombination), allCombinations);

      thisCombination.removeLast();
      findAllCombinationsThatSumToK2(input, k, index + 1, thisCombination, allCombinations);

    }

  }

  public void findAllCombinationsThatSumToK3(long[] input, long k, int index,
      LinkedList<Long> thisCombination, Collection<LinkedList<Long>> allCombinations) {

    if (k == 0) {
      allCombinations.add(thisCombination);
    } else if (index < input.length && k > 0) {

      // avoiding the case where we create same combination with different elements(duplicate)
      if (!(!thisCombination.isEmpty() && thisCombination.getLast() != input[index] && index > 0
          && input[index] == input[index - 1])) {

        thisCombination.offer(input[index]);
        findAllCombinationsThatSumToK3(input, k - input[index], index + 1,
            new LinkedList<>(thisCombination), allCombinations);
        thisCombination.removeLast();

      }

      findAllCombinationsThatSumToK3(input, k, index + 1, thisCombination, allCombinations);

    }


  }

  public void findAllCombinationsThatSumToK4(long[] input, long k, int index,
      LinkedList<Long> thisCombination, Collection<LinkedList<Long>> allCombinations) {

    if (k == 0) {
      allCombinations.add(new LinkedList<>(thisCombination));
    } else if (index < input.length && k > 0) {

       for(int i = index ; i < input.length ; i++){
            if( (i > index && input[i] == input[i-1]) ){
              // same element ..so ignore it
              continue;
            } else if (input[i] > k)
              break;
            else {
              thisCombination.add(input[i]);
              findAllCombinationsThatSumToK4(input , k - input[i] , i+1 , thisCombination , allCombinations);
              thisCombination.removeLast();
            }
       }

    }


  }



  public static void main(String[] args) {

    FindAllCombinationsThatSumWithEntriesUsedOnceAtmostToK findAllCombinationsThatSumToK = new FindAllCombinationsThatSumWithEntriesUsedOnceAtmostToK();


    System.out.println("#############");
    System.out.println("######K2#####");
    System.out.println("#############");

    List<List<Long>> allCombinations = new ArrayList<>();

    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK2(new long[]{6, 2, 4, 3, 5, 1}, 10,
        0, new LinkedList<>(), allCombinations);

    System.out.println(allCombinations);

    System.out.println("#####Next Scenario######");
    allCombinations = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK2(new long[]{3, 2, 5}, 8, 0,
        new LinkedList<>(), allCombinations);
    System.out.println(allCombinations);

    System.out.println("#####Next Scenario######");
    allCombinations = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK2(new long[]{6, 7, 3, 2}, 7, 0,
        new LinkedList<>(), allCombinations);
    System.out.println(allCombinations);

    System.out.println("#####Next Scenario######");
    allCombinations = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK2(new long[]{6, 7, 3, 2, 2, 6, 3}, 7,
        0, new LinkedList<>(), allCombinations);
    System.out.println(allCombinations);

    System.out.println("#############");
    System.out.println("######K4#####");
    System.out.println("#############");

    //Set<LinkedList<Long>> allCombinationsSet = new HashSet<>();
    Collection<LinkedList<Long>> allCombinationsSet = new ArrayList<>();
    long[] input1 = {6, 2, 4, 3, 5, 1};
    Arrays.sort(input1);

    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK4(input1, 10, 0, new LinkedList<>(),
        allCombinationsSet);

    System.out.println(allCombinationsSet);

    System.out.println("#####Next Scenario######");
    long[] input2 = {3, 2, 5};
    Arrays.sort(input2);
    allCombinationsSet = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK4(input2, 8, 0, new LinkedList<>(),
        allCombinationsSet);
    System.out.println(allCombinationsSet);

    System.out.println("#####Next Scenario######");
    long[] input3 = {6, 7, 3, 2};
    Arrays.sort(input3);
    allCombinationsSet = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK4(input3, 7, 0, new LinkedList<>(),
        allCombinationsSet);
    System.out.println(allCombinationsSet);

    System.out.println("#####Next Scenario######");
    long[] input4 = {6, 7, 3, 2, 2, 6, 3};
    Arrays.sort(input4);
    allCombinationsSet = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK4(input4, 7, 0, new LinkedList<>(),
        allCombinationsSet);
    System.out.println(allCombinationsSet);

    System.out.println("#####Next Scenario######");
    long[] input5 = {6, 7, 3, 2, 2, 6, 3};
    Arrays.sort(input5);
    allCombinationsSet = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK4(input5, 29, 0, new LinkedList<>(),
        allCombinationsSet);
    System.out.println(allCombinationsSet);

    System.out.println("#####Next Scenario######");
    long[] input6 = {6, 7, 3, 2, 2, 6, 3};
    Arrays.sort(input6);
    allCombinationsSet = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK4(input6, 10, 0, new LinkedList<>(),
        allCombinationsSet);
    System.out.println(allCombinationsSet);

    System.out.println("#####Next Scenario######");
    long[] input7 = { 7, 3,  6, 3};
    Arrays.sort(input7);
    allCombinationsSet = new ArrayList<>();
    findAllCombinationsThatSumToK.findAllCombinationsThatSumToK4(input7, 10, 0, new LinkedList<>(),
        allCombinationsSet);
    System.out.println(allCombinationsSet);

  }


}
