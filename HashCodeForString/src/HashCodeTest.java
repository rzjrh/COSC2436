import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashCodeTest {	
	
	public static void main(String[] args) {
		
		
	       Set<String> set = new HashSet<>();

	       set.add("Reza");
	       set.add("Professor Meng");
	       set.add("Java");

	       ArrayList<String> myArrayList = HashCode.setToList(set);
	       for (String str : myArrayList) {
	           System.out.println("The hash code for \"" 
	        		   + str + "\" is: \n" + HashCode.hashCodeForString(str)+"\n");
	       }
	   }
	
	
	
}
