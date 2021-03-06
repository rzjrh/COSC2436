import java.util.Scanner;

// Author: Reza Akhlaqi
// Date: 10-26-2019


/*Write a test program that prompts the user to enter a list and displays
whether the list is sorted or not. Here is a sample run. Note that the program
first prompts the user to enter the size of the list.*/




public class IsSorted {
	
	//create a scanner object here. Also, need to import the util.scanner
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Please Enter the size of your list:");
		int size = sc.nextInt();
		int [] list = new int [size];
		
		System.out.println("Please Enter the contents of the list:");		
		for (int i=0; i<list.length; i++) {
			list[i]= sc.nextInt();
		}
		
		if (SortCheck.sortCheck(list)) {
			System.out.println("your list has "+size+" Integers: ");
			for (int i=0; i<list.length; i++) {
				System.out.print(" "+list[i]+" ");
			}
            System.out.println("\nThis list is SORTED!");
		}
		else {
			System.out.println("your list has "+size+" Integers: ");
			for (int i=0; i<list.length; i++) {
				System.out.print(" "+list[i]+" ");
			}
			System.out.println("\nThe list is NOT SORTED!");
		}
		
		
	}

	
	
}
