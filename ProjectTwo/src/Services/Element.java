/*
 COSC 436
 Project Two- HashMap
 Professor Meng
 Reza Akhlaqi 
 12-2-2019
 */
package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Model.ElementModel;
import Model.Menu;

public class Element {
	  
    public static void addElement(HashMap<String,ElementModel> hashMap)
    {
        ElementModel element = new ElementModel();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the element symbol: ");
        String symbol = input.next().toUpperCase();
        input.nextLine();
        
        System.out.print("Please enter the element name: ");
        element.setName(input.nextLine());
        
        System.out.print("Please enter the element atomic number: ");
        
        try {
        element.setAtomicNumber(input.nextInt());}
        catch (InputMismatchException e) {
            System.out.println("Erorr! Please enter the numeric digits only!"
            		+ "\nNo alphabet and/or special charachters allowed");
         }
        
        System.out.print("Please enter the element atomic Weight: ");        
        try {
        element.setAtomicWeight(input.nextDouble());
        }
        catch (InputMismatchException e) {

            System.out.println("Erorr! Please enter the numeric digits only!"
            		+ "\nNo alphabet and/or special charachter allowed");
         }
                
        hashMap.put(symbol,element);
    }
    public static boolean searchElement(HashMap<String,ElementModel> hashMap, String symbol)
    {
         return hashMap.containsKey(symbol);
    }
    public static boolean deleteElement(HashMap<String,ElementModel> hashMap, String symbol)
    {
        if(searchElement(hashMap,symbol))
        {
            hashMap.remove(symbol);
            System.out.println("====Element Deleted!==== ");
            return true;
        }
        else
        {
            System.out.println("====Element is not in the database!====");
            return false;
        }
    }
    public static void loadElementsFromFile(HashMap<String,ElementModel> hashMap)
    {
        try
        {
            Scanner scanFile = new Scanner(new File("C:\\Data\\elements.txt"));
            while (scanFile.hasNextLine())
            {
                String[] tokens = scanFile.nextLine().split(",");
                ElementModel element = new ElementModel(tokens[1],Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]));
                hashMap.put(tokens[0],element);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("Sorry we could not locate the file! "
            		+ "\nPlease make sure the file is in the right location");
        }
        catch (InputMismatchException ex)
        {
            System.err.println("Input in not matched!");
        }
    }
    
    public static void displayElements(HashMap<String,ElementModel> hashMap)
    {
        Set<Map.Entry<String, ElementModel>> set = hashMap.entrySet();
        List<Map.Entry<String, ElementModel>> list = new ArrayList<Map.Entry<String, ElementModel>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, ElementModel>>() {
            public int compare(Map.Entry<String, ElementModel> o1,
                               Map.Entry<String, ElementModel> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        Menu.list2();
        for (Map.Entry<String, ElementModel> entry : list) {
            System.out.println(String .format("%8s",entry.getKey())+entry.getValue());

        }


    }
	
}
