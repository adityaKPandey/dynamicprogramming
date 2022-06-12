package com.recursion.multiple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSums {

  public void findSumsOfAllSubsets(long [] input , int index , long sum , List<Long> subsetSums){

      if(index == input.length){
        subsetSums.add(sum);
        return ;
      }


      findSumsOfAllSubsets(input , index + 1 , sum + input[index] , subsetSums);

      findSumsOfAllSubsets(input , index + 1 , sum , subsetSums);
  }

  public static void main(String [] args){

    SubsetSums subsetSums = new SubsetSums();
    List<Long> subsetSumList = new ArrayList<>() ;
    subsetSums.findSumsOfAllSubsets(new long[]{3, 1, 4}, 0 , 0 , subsetSumList);
    Collections.sort(subsetSumList);
    System.out.println("O/P size:"+subsetSumList.size());
    subsetSumList.stream().forEach(System.out::println);

    System.out.println("#############################");

    subsetSumList = new ArrayList<>() ;
    subsetSums.findSumsOfAllSubsets(new long[]{1,-1,0}, 0 , 0 , subsetSumList);
    Collections.sort(subsetSumList);
    System.out.println("O/P size:"+subsetSumList.size());
    subsetSumList.stream().forEach(System.out::println);

    System.out.println("#############################");

    subsetSumList = new ArrayList<>() ;
    subsetSums.findSumsOfAllSubsets(new long[]{5,2,1}, 0 , 0 , subsetSumList);
    Collections.sort(subsetSumList);
    System.out.println("O/P size:"+subsetSumList.size());
    subsetSumList.stream().forEach(System.out::println);

    System.out.println("#############################");

  }



}
