import java.util.ArrayList;
import java.util.Set;

public class HashCode {
	public static int hashCodeForString(String s) {

	       int b = 31;
	       int hashCode = 0;	       
	       for (int i = 0; i < s.length(); i++) {
	           hashCode = b * hashCode + (int)s.charAt(i);
	       }
	       return hashCode;
	       
	   }

	   public static <E> ArrayList<E> setToList(Set<E> s) {
	       ArrayList<E> list = new ArrayList<>();
	       for(E calc : s) {
	           list.add(calc);
	       }
	       return list;
	   }
	   
	   
	   
       
       
       
}
