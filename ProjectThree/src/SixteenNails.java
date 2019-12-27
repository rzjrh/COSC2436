/*
 COSC 436
 Project Three- 4×4 16 tails problem
 Professor Meng
 Reza Akhlaqi 
 12-10-2019
 */

import java.util.List;
import java.util.Scanner;


public class SixteenNails {
	
	public static void main(String[] args) {
		System.out.println("Enter the initial sixteen coins Hs and Ts: "); 
		Scanner in = new Scanner(System.in); 
		String s = in.nextLine(); 
		char [] initNode = s.toCharArray(); 
		TailModel tailModel = new TailModel(); 
		
		List<Integer> shortPath = tailModel.getShortestPath(TailModel.getIndex(initNode)); 
		
		if (shortPath == null) 
		System.out.println("There is NO solutions"); 
		else { 
			System.out.println("Here are the steps to flip the coins: "); 
			for (int itr = 0; itr < shortPath.size(); itr++) 
				TailModel.printNode( TailModel.getNode(shortPath.get(itr)));
			} }	
	
		  
		}
	