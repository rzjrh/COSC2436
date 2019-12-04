/*
 COSC 436
 Project Two- HashMap
 Professor Meng
 Reza Akhlaqi 
 12-2-2019
 */

import java.util.*;

import Model.ElementModel;
import Model.Menu;
import Services.Element;

public class HashMapTest {
    public static void main(String[] args)
    {
    	
        HashMap<String, ElementModel> hashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int option;
        String symbol;
        
        do {
             Menu.list();
      option = sc.nextInt();
      switch (option)
      {
          case 1:
              Element.addElement(hashMap);
              break;
          case 2:
              sc.nextLine();
              System.out.print("Enter symbol: ");
              symbol = sc.nextLine().toUpperCase();
              if(Element.searchElement(hashMap,symbol))
              {
                  System.out.println(hashMap.get(symbol));
              }
              else
                  System.err.println("Element not found...");
              break;
          case 3:
              sc.nextLine();
              System.out.print("Enter symbol: ");
              symbol = sc.nextLine().toUpperCase();
              Element.deleteElement(hashMap,symbol);
              break;
          case 4:
        	  Element.loadElementsFromFile(hashMap);
              System.out.println("Done.........");
              break;
          case 5:
        	  Element.displayElements(hashMap);
              break;
          case 6:
              System.out.println("Thanks for using this app......");
              break;
          default:
              System.err.println("Wrong choice...Try again..");
              break;
      }

        }while (option!=6);
    }
    

  
}