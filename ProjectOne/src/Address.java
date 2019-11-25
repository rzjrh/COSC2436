

public class Address
{
	
	//here our fields. We do private them for encapsulation. we will need getters and setters 
   private String street;
   private String city;
   private String state;
   private String zip;

  
//making the constructor 
   public Address(String road, String town, String st,
                  String zipCode)
   {
      street = road;
      city = town;
      state = st;
      zip = zipCode;
   }

  
//getting the address
   public String toString()
   {
      return (street + ", " + city + ", " + state + " " + zip);
   }
}