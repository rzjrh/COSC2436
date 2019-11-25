import java.util.Scanner;

public class SortCheck {
	
	

	
	public static boolean sortCheck(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1])
				return false;
		}
		return true;
	}
	
}
