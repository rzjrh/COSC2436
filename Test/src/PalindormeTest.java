
public class PalindormeTest {
	
	public static boolean makePalindrome(String mjono) {

        StringBuilder sb = new StringBuilder(mjono);


        for (int i = 0; i < mjono.length(); i++) {
            sb.deleteCharAt(i);

            if(isPalindrome(sb.toString())){
                return true;
            } else {
                sb.insert(i, mjono.charAt(i));
            }
        }
        return false;
    }

    private static boolean isPalindrome(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(makePalindrome("ABCBXA"));
        System.out.println(makePalindrome("ABCBAX"));
        System.out.println(makePalindrome("ABCXBA"));
        System.out.println(makePalindrome("ABCDE"));
        System.out.println(makePalindrome("BAAAAC"));
    }
   
}
