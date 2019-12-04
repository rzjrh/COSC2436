package Model;

import java.util.Map;

public class Menu {
	 public static void list() {
		 System.out.println("\nSelect an option number from the following menu:\n ");
	        System.out.println("Option  Action ");
	        System.out.println("------  -----------------------------------------");
		 
	        System.out.println(" 1	Add a chemical element to the collection.\n" +
	                " 2	Search for an element in the collection.\n" +
	                " 3	Delete an element from the collection.\n" +
	                " 4	Load elements from a text file.\n" +
	                " 5 	Display the collection sorted by symbol.\n" +
	                " 6 	Quit\nEnter your choice: ");
	    }
	 
	 public static void list2() {
		 System.out.println(String.format("%8s %18s %10s %10s","Symbol","Name","Atomic","Atomic"));
	        System.out.println(String.format("%8s %18s %10s %10s"," "," ","Number","Weight"));
	        System.out.println(String.format("%8s %18s %10s %10s","-------","---------","---------","-----------"));
	        
	 }

	 
}
