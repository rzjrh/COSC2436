
public class ClosestPairPoints {
	
public static void main(String[] args) {
	
double[][] pointsArray = CPPDriver.generateRandomPoints(20, 130, -65);


CPPDriver.Pair closestPairOfPoints = CPPDriver.getClosestPair(pointsArray);

System.out.printf("The closest pair of points are:%n%s and %s.%nTheir distance is %f",
		closestPairOfPoints.p1, closestPairOfPoints.p2, closestPairOfPoints.getDistance());
}

}