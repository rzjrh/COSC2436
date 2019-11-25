
public class BMI {
	
	private String name;
    private int age;
    private double weight; // in pounds
    private double height; // in inches
    public static final double KILOGRAMS_PER_POUND = 0.45359237; //the instants
    public static final double METERS_PER_INCH = 0.0254; //the instants

    
    //constructor
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public BMI(String name, double weight, double height)  {
        this(name, 20, weight, height);
    }

    //how to calculate the bmi
    public double getBMI()  {
        double bmi = weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
        return Math.round(bmi * 100) / 100.0;
    }

    public String getStatus()  {
        double bmi = getBMI();
        if (bmi < 18.5) {
            return "Status: Underweight";
        } else if (bmi < 25) {
            return "Status: Normal";
        } else if (bmi < 30) {
            return "Status: Overweight";
        } else {
            return "Status: Obese";
        }
    }

    
    //getters and setters
    public String getName()  {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight()  {
        return weight;
    }

    public double getHeight()  {
        return height;
    }

}
