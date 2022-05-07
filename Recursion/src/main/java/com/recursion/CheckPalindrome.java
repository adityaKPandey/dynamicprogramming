package com.recursion;

public class CheckPalindrome {

  public static boolean checkPalindrome(String text , int index){
    if(index >= text.length()/2)
      return true;

    return text.charAt(index) == text.charAt(text.length()-index-1) && checkPalindrome(text,index+1);

  }

  public static void main(String [] args){

    System.out.println(checkPalindrome("madam",0));
    System.out.println(checkPalindrome("madame",0));
    System.out.println(checkPalindrome("abba",0));
    System.out.println(checkPalindrome("a",0));
    System.out.println(checkPalindrome("bb",0));

  }

}
