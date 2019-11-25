// Reza Akhlaqi 11-17-2019
//This is the main class. Here I test the methods in the driver class

/* EvaluateExpression.java to add operators ^ for exponent and % for
remainder. For example, 3 ^ 2 is 9 and 3 % 2 is 1. The ^ operator has the
highest precedence and the % operator has the same precedence as the * and  / operators.*/

//Related Java packages for this program
// we using stack package here to store our operator
import java.util.Scanner;


public class EvaluateExpressionTest {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //ask user to enter the expression
        System.out.print("Enter an expression: ");
        String expression = sc.nextLine();

        //try and catch the exception 
        try {
              System.out.println(expression + " = "+ EvaluateExpression.evaluateExpression(expression));
        } catch (Exception ex) {
              System.out.println("Sorry, the (" + expression+") is wrong expression! \nPlease try again");
        }
      }
}