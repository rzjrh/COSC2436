import java.util.Scanner;

/*
 Have the function FirstReverse(str) take the str parameter being passed and return the string in reversed order. 
 For example: if the input string is "Hello World and Coders" 
 then your program should return the string sredoC dna dlroW olleH.
 */


public class FirstReverse {
	 public static String FirstReverse(String str) {
	        return new StringBuilder(str).reverse().toString();
	    }
	  
	  public static void main (String[] args) {  
		  
		System.out.println("Please Enter your text to be reversed:");
	    Scanner s = new Scanner(System.in);
	    System.out.print(FirstReverse(s.nextLine())); 
	  }   
}
