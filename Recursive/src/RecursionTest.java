import java.io.*;
import java.util.*;
import java.lang.Math;

public class RecursionTest {
public static void main(String[] args) {
int n,c,num;
Scanner sc = new Scanner(System.in);
while(true)
{
System.out.println("Hello User, \nEnter your option number: \n1: multiplying numberby 3 \n2:exit the program ");
c=sc.nextInt();
switch(c)
{

case 1:
System.out.println("Please Enter what number you want to be muliplied by 3");
num=sc.nextInt();
product m=new product();
n=m.rec(num);
System.out.println("the result is: "+n+"\n");
break;

case 2: 
	System.exit(0) ; 
break;
default: System.out.println("Please select the option number provided");
}
}
}
}

class product
{
   int rec(int n)
   {
       if(n==0)
           return 0;
       else
       {
           //For negative n values
           if(n < 0)
           {
               return(-3+rec(n+1));
           }
           else
           {
               return(3+rec(n-1));
           }
       }
   }
}