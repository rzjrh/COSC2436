

public class CircleCompareTest {

	
	public static void main(String[] args) {
		
		// Create three Circle objects
		Circle circleA = new Circle(7.2, "Red", true);
		Circle circleB = new Circle(7.2, "Green", false);
		Circle circleC = new Circle(4, "Blue", false);
		// Display results
		System.out.println("\nCircle A");
		circleA.circleDetails();
		
		System.out.println("\nCircle B");
		circleB.circleDetails();

		System.out.println("\nCircle C");
		circleC.circleDetails();


		System.out.println("\nCOMPARISONS:");
		System.out.println("Circle1 is " + (circleA.equals(circleB) ? "" : "not ") +
			"equal to circle2");

		System.out.println("Circle1 is " + (circleA.equals(circleC) ? "" : "not ") +
			"equal to circle3");
		

		
	}
}