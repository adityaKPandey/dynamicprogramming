package com.recursion.multiple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


/*
 Compile list of all unique combinations( {1,2} is same subset as {2,1} ) .
 */
public class FindAllPossibleSubsets {

  public void findAllSubsets(long[] input, int index, LinkedList<Long> subset,
      Collection<List<Long>> subsets) {

    subsets.add(new LinkedList<>(subset));

    if (index >= input.length) {
      return;
    }

    subset.add(input[index]);
    findAllSubsets(input, index + 1, subset, subsets);
    subset.removeLast();
    findAllSubsets(input, index + 1, subset, subsets);

  }

  public void findAllSubsetsWithoutSet(long[] input, int index, LinkedList<Long> subset,
      Collection<List<Long>> subsets) {

    if (index > input.length + 1) {
      return;
    } else {

      for (int i = index; i <= input.length; i++) {
        if (i < input.length && i > index && input[i] == input[i - 1]) {
          continue;
        }

        if (i < input.length) {
          subset.add(input[i]);
          subsets.add(new LinkedList<>(subset));
          findAllSubsetsWithoutSet(input, i + 1, subset, subsets);
          subset.removeLast();
        }

      }
    }
  }


  public static void main(String[] args) {

    FindAllPossibleSubsets subsetSums = new FindAllPossibleSubsets();
    //Collection<List<Long>> setOfSubsets = new ArrayList<>();
    long[] input = new long[]{3, 1, 4};
    Collection<List<Long>> listOfSubsets = new ArrayList<>();
    listOfSubsets.add(new ArrayList<>());
    subsetSums.findAllSubsetsWithoutSet(input, 0, new LinkedList<>(), listOfSubsets);
    System.out.println("O/P size:" + listOfSubsets.size());
    listOfSubsets.stream().forEach(System.out::println);

    System.out.println("#############################");

    listOfSubsets = new ArrayList<>();
    input = new long[]{1, -1, 0};
    listOfSubsets.add(new ArrayList<>());
    subsetSums.findAllSubsetsWithoutSet(input, 0, new LinkedList<>(), listOfSubsets);
    System.out.println("O/P size:" + listOfSubsets.size());
    listOfSubsets.stream().forEach(System.out::println);

    System.out.println("#############################");

    listOfSubsets = new ArrayList<>();
    input = new long[]{5, 2, 1};
    listOfSubsets.add(new ArrayList<>());
    subsetSums.findAllSubsetsWithoutSet(input, 0, new LinkedList<>(), listOfSubsets);
    System.out.println("O/P size:" + listOfSubsets.size());
    listOfSubsets.stream().forEach(System.out::println);

    System.out.println("#############################");

    listOfSubsets = new ArrayList<>();
    input = new long[]{5, 2};
    listOfSubsets.add(new ArrayList<>());
    subsetSums.findAllSubsetsWithoutSet(input, 0, new LinkedList<>(), listOfSubsets);
    System.out.println("O/P size:" + listOfSubsets.size());
    listOfSubsets.stream().forEach(System.out::println);

    System.out.println("#############################");


    input = new long[]{1};
    listOfSubsets = new ArrayList<>();
    subsetSums.findAllSubsetsWithoutSet(input, 0, new LinkedList<>(), listOfSubsets);
    listOfSubsets.add(new LinkedList<>());
    System.out.println("O/P size:" + listOfSubsets.size());
    listOfSubsets.stream().forEach(System.out::println);

    System.out.println("#############################");

    //setOfSubsets = new HashSet<>() ;
    long[] inpArray = new long[]{1, 2, 1};
    Arrays.sort(inpArray);
    subsetSums.findAllSubsetsWithoutSet(inpArray, 0, new LinkedList<>(), listOfSubsets);
    listOfSubsets.add(new LinkedList<>());
    System.out.println("O/P size:" + listOfSubsets.size());
    listOfSubsets.stream().forEach(System.out::println);

    System.out.println("#############################");

    listOfSubsets = new ArrayList<>();
    //setOfSubsets = new HashSet<>();
    inpArray = new long[]{1, 1};
    //subsetSums.findAllSubsets(inpArray, 0, new LinkedList<>(), setOfSubsets);
    subsetSums.findAllSubsetsWithoutSet(inpArray, 0, new LinkedList<>(), listOfSubsets);
    listOfSubsets.add(new LinkedList<>());
    System.out.println("O/P size:" + listOfSubsets.size());
    listOfSubsets.stream().forEach(System.out::println);

    System.out.println("#############################");


  }


}
