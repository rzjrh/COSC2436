/**
   This class defines a person by name and address.
*/

public class Person
{
   private String lastName;
   private String firstName;
   private Address home;

   /**
      Constructor
   */

   public Person(String last, String first,
                 Address residence)
   {
      lastName = last;
      firstName = first;
      home = residence;
   }

   /**
      The toString method
      @return Information about the person.
   */

   public String toString()
   {
      return(firstName + " " + lastName +
             ", " + home.toString());
   }
}