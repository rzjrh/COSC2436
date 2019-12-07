import java.util.Scanner;

public class RemoveCharToMakePalindrome {

   public static void main(String[] args) {
       String newStr = "", str;
       /*
       * Creating an Scanner class object which is used to get the inputs
       * entered by the user
       */
       Scanner sc = new Scanner(System.in);

       // Getting the input entered by the user
       System.out.print("Enter String :");
       str = sc.next();

       int res = makeItPalindrome(str);
       if (res == -2) {
           System.out.println("Alreadty a Palindrome");
       } else if (res == -1) {
           System.out.println("Not possible to make it a Palindrome");
       } else {
           newStr += str.substring(0, res) + str.substring(res + 1);
           System.out.println("In String \"" + str+ "\" our program needs to remove '" + str.charAt(res)+ "' to make it a palindrome.");
           System.out.println("New String after removing character :" + newStr);
       }

   }

   /*
   * if this method returns -2 then the passed parameter String is already a
   * palindrome if this returns -1, then it is not possible to make String as
   * palindrome even if we remove a character if this returns any other then
   * it is the position of the char to remove from string to make it a
   * palindrome
   */
   private static int makeItPalindrome(String str) {
       if (str.equalsIgnoreCase(reverse(str)))
           return -2;
       int len = str.length();
       for (int i = 0; i < len; i++) {
           String partial = str.substring(0, i) + str.substring(i + 1, len);
           String revPartial = reverse(partial);
           if (partial.equalsIgnoreCase(revPartial)) {
               return i;
           }
       }
       return -1;
   }

   /* this Method will reverse the give input String */
   public static String reverse(String str) {
       String revStr = "";
       for (int i = str.length() - 1; i >= 0; i--) {
           revStr += str.charAt(i);
       }
       return revStr;
   }
}