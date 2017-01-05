import java.util.Scanner; 
public class Area {
	
			public static void main(String[] args)
			{	
				final double PI = 3.14; 
				System.out.printf("please enter the radius of the circle: ");
				Scanner input = new Scanner(System.in); 
				double radius = input.nextDouble();
				double area = radius * radius * PI; 
				System.out.printf("The area of the circle is %f", area); 
				
			}
			
}
