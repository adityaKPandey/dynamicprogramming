package com.recursion.multiple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class GenerateAllPermutations {

  public void generatePermutationsWithSet(long [] array  ,   LinkedHashSet<Long> thisPermutation , List<Collection<Long>>permutations){

    for(int i = 0 ; i < array.length; i++){

      if(thisPermutation.contains(array[i]))
        continue;

      LinkedHashSet <Long> newPermutation = new LinkedHashSet<>(thisPermutation);
      newPermutation.add(array[i]);
      if(newPermutation.size() == array.length)
        permutations.add(newPermutation) ;
      else
        generatePermutationsWithSet(array ,  newPermutation , permutations );


    }

  }

  public static void main(String [] args){

    GenerateAllPermutations generateAllPermutations = new GenerateAllPermutations();
    List<Collection<Long>> allPermutations = new ArrayList<>();
    long [] input = new long []{1,2,3} ;
    generateAllPermutations.generatePermutationsWithSet(input ,   new LinkedHashSet<>() , allPermutations);
    allPermutations.forEach( p -> System.out.println(p));
    System.out.println("############");

    input = new long []{1,2} ;
    allPermutations.clear();
    generateAllPermutations.generatePermutationsWithSet(input , new LinkedHashSet<>() , allPermutations);
    allPermutations.forEach( p -> System.out.println(p));
    System.out.println("############");

    input = new long []{1,2,3,4} ;
    allPermutations.clear();
    generateAllPermutations.generatePermutationsWithSet(input , new LinkedHashSet<>() , allPermutations);
    System.out.println("Permutation size :" + allPermutations.size());
    allPermutations.forEach( p -> System.out.println(p));
    System.out.println("############");

    input = new long []{1,2,3,4,5} ;
    allPermutations.clear();
    generateAllPermutations.generatePermutationsWithSet(input  , new LinkedHashSet<>() , allPermutations);
    System.out.println("Permutation size :" + allPermutations.size());
    allPermutations.forEach( p -> System.out.println(p));
    System.out.println("############");

    input = new long []{1,2,3,4,5,6} ;
    allPermutations.clear();
    generateAllPermutations.generatePermutationsWithSet(input  , new LinkedHashSet<>() , allPermutations);
    System.out.println("Permutation size :" + allPermutations.size());
    allPermutations.forEach( p -> System.out.println(p));
    System.out.println("############");

  }

}
