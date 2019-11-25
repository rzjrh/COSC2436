//This is the Driver class. all of the logic methods here

import java.util.Stack;

public class EvaluateExpression {
	 /** Evaluate an expression */

    public static int evaluateExpression(String expression) {

          Stack<Integer> operandStack = new Stack<Integer>();
          Stack<Character> operatorStack = new Stack<Character>();

          expression = insertBlanks(expression);
          String[] tokens = expression.split(" ");

          for (String token : tokens) {
                if (token.length() == 0) 
                      continue; 
                else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
              	  
                      while (!operatorStack.isEmpty()
                          && (operatorStack.peek() == '+'
                               || operatorStack.peek() == '-'
                               || operatorStack.peek() == '*'
                               || operatorStack.peek() == '/' 
                               || operatorStack.peek() == '%')) {

                      processAnOperator(operandStack, operatorStack);
                      }

                operatorStack.push(token.charAt(0));
                } 
                else if (token.charAt(0) == '*' || token.charAt(0) == '/'|| token.charAt(0) == '%') {
                      while (!operatorStack.isEmpty() && (operatorStack.peek() == '*'|| operatorStack.peek() == '/' || 
                      		operatorStack.peek() == '%')) {
                            processAnOperator(operandStack, operatorStack);
                      }
                      operatorStack.push(token.charAt(0));
                } else if (token.charAt(0) == '^') {
                      operatorStack.push(token.charAt(0));
                } else if (token.trim().charAt(0) == '(') {
                      operatorStack.push('('); // Push '(' to stack
                } else if (token.trim().charAt(0) == ')') {
                      while (operatorStack.peek() != '(') {
                            processAnOperator(operandStack, operatorStack);
                      }
                      operatorStack.pop();
                } else { 
                      operandStack.push(new Integer(token));
                }
          }
          
          
          while (!operatorStack.isEmpty()) {
                processAnOperator(operandStack, operatorStack);
          }
          // Return the result
          return operandStack.pop();
    }
    
    
    public static void processAnOperator(Stack<Integer> operandStack,Stack<Character> operatorStack) {
          char operator = operatorStack.pop();
          int opr1 = operandStack.pop();
          int opr2 = operandStack.pop();
          if (operator == '+')
                operandStack.push(opr2 + opr1);
          else if (operator == '-')
                operandStack.push(opr2 - opr1);
          else if (operator == '*')
                operandStack.push(opr2 * opr1);
          else if (operator == '/')
                operandStack.push(opr2 / opr1);
          else if (operator == '%')
                operandStack.push(opr2 % opr1);
          else if (operator == '^')
                operandStack.push((int) Math.pow(opr2, opr1));
    }
    
    public static String insertBlanks(String s) {
          String result = "";
          for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+'
                            || s.charAt(i) == '-' || s.charAt(i) == '*'
                            || s.charAt(i) == '/' || s.charAt(i) == '%'
                            || s.charAt(i) == '^')
                      result += " " + s.charAt(i) + " ";
                else
                      result += s.charAt(i);
          }
          return result;
    }
}
