import java.util.Scanner; 
public class BMICalc {
		public static void main(String args[])
		{
			System.out.printf("Please enter your weight in pounds: "); 
			Scanner input = new Scanner(System.in); 
			int weight = input.nextInt(); 
			System.out.printf("Please enter your height in inches: "); 
			int height = input.nextInt(); 
			double BMI = (weight * 703) / (height * height); 
			System.out.printf("Your BMI is: %f", BMI); 
			System.out.printf("BMI Values: \n Underweight: less than 18.5 \n Normal: between 18.5 and 24.9 \n"
					+ "Overweight: between 25 and 29.9 \n Obese: 30 or greater \n"); 
		}
}
