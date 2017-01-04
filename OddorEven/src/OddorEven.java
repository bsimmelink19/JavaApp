import java.util.Scanner; 
public class OddorEven {
		public static void main(String[] args)
		{
			//used to determine when the user is done
			boolean cont = true; 
			//runs until the user says they are finished
			while (cont == true)
			{
			//display prompt
			System.out.printf("Please enter an integer: \n");
			//reads in integer from user to be checked if even or odd
			Scanner input = new Scanner(System.in); 
			int x = input.nextInt(); 
			
			//mods the user input by 2, if remainder is 0 number is even if not number is odd
			int remainder = x % 2; 
			
			//if divisible by 2 display the number is even
			if (remainder == 0)
			{
				System.out.printf("That number is even \n");
			}
			//if not divisible by 2, display the number is odd
			else 
			{
				System.out.printf("That number is odd \n"); 
			}
			//prompt the user to choose to continue or not 
			System.out.printf
			("Would you like to try again? \n (Enter 1 for yes) \n (Enter 2 for no) \n"); 
			//Scanner input1 = new Scanner(System.in); 
			int c = input.nextInt(); 
			
			//exit the loop if the user chooses to be done 
			if (c == 2)
			{
				cont = false; 
			}
			}
			
		}
}
