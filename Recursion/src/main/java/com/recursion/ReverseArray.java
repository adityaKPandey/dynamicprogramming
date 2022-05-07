package com.recursion;

import java.util.Arrays;

public class ReverseArray<T> {

  public void reverse(T[] array , int index){

      if( index >= array.length/2)
        return;

      T data = array[index] ;
      array[index] = array[array.length - index - 1];
      array[array.length - index - 1] = data;

      reverse(array,index+1);

  }

  public static void main(String [] args){
     Integer [] array = {1,2,3,4,5};
     ReverseArray reverseArray = new ReverseArray();
     reverseArray.reverse(array , 0);

     Arrays.stream(array).forEach(System.out::println);

  }

}
