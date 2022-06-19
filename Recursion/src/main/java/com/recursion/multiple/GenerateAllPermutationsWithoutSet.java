package com.recursion.multiple;

import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class GenerateAllPermutationsWithoutSet {

  public void generatePermutationsWithoutSet(long[] array, int index, List<Long> thisPermutation,
      List<List<Long>> permutations) {

    if (index == array.length) {
      permutations.add(new ArrayList<>(thisPermutation));
    } else {
      for (int i = index; i < array.length; i++) {
        //swap index and i positions
        List<Long> newPermutation = swap(thisPermutation, index, i);
        generatePermutationsWithoutSet(array, index + 1, newPermutation, permutations);
        swap(thisPermutation, index, i);
      }
    }

  }


  private List<Long> swap(List<Long> thisPermutation, int ip, int jp) {
    Long val = thisPermutation.get(ip);
    thisPermutation.set(ip, thisPermutation.get(jp));
    thisPermutation.set(jp, val);
    return thisPermutation;
  }

  public static void main(String[] args) {

    GenerateAllPermutationsWithoutSet generateAllPermutations = new GenerateAllPermutationsWithoutSet();
    List<List<Long>> allPermutations = new ArrayList<>();
    long[] input = new long[]{1, 2, 3};
    final List<Long> listInp = new ArrayList<>();
    stream(input).forEach(c -> listInp.add(c));
    generateAllPermutations.generatePermutationsWithoutSet(input, 0, new ArrayList<>(listInp),
        allPermutations);
    allPermutations.forEach(p -> System.out.println(p));
    System.out.println("############");

    input = new long[]{1, 2};
    allPermutations.clear();
    final List<Long> listInp1 = new ArrayList<>();
    stream(input).forEach(c -> listInp1.add(c));
    generateAllPermutations.generatePermutationsWithoutSet(input, 0, new ArrayList<>(listInp1),
        allPermutations);
    allPermutations.forEach(p -> System.out.println(p));
    System.out.println("############");

    input = new long[]{1, 2, 3, 4};
    allPermutations.clear();
    final List<Long> listInp21 = new ArrayList<>();
    stream(input).forEach(c -> listInp21.add(c));
    generateAllPermutations.generatePermutationsWithoutSet(input, 0, new ArrayList<>(listInp21),
        allPermutations);
    System.out.println("Permutation size :" + allPermutations.size());
    allPermutations.forEach(p -> System.out.println(p));
    System.out.println("############");

    input = new long[]{1, 2, 3, 4, 5};
    allPermutations.clear();
    final List<Long> listInp2 = new ArrayList<>();
    stream(input).forEach(c -> listInp2.add(c));
    generateAllPermutations.generatePermutationsWithoutSet(input, 0, new ArrayList<>(listInp2),
        allPermutations);
    System.out.println("Permutation size :" + allPermutations.size());
    allPermutations.forEach(p -> System.out.println(p));
    System.out.println("############");

    input = new long[]{1, 2, 3, 4, 5, 6};
    allPermutations.clear();
    final List<Long> listInp22 = new ArrayList<>();
    stream(input).forEach(c -> listInp22.add(c));
    generateAllPermutations.generatePermutationsWithoutSet(input, 0, new ArrayList<>(listInp22),
        allPermutations);
    System.out.println("Permutation size :" + allPermutations.size());
    allPermutations.forEach(p -> System.out.println(p));
    System.out.println("############");


  }

}
