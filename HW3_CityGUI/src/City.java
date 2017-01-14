import java.util.ArrayList;
import java.util.Scanner; 
  /**
   * This class models a city, with buildings and a population
   * @author Brady Simmelink
   * @version 1.00, 06 January 2017
   */
public class City {
	 
	 ArrayList<Building> buildings = new ArrayList<Building>(); 
	 ArrayList<Person> population = new ArrayList<Person>(); 
		
		public static void main(String[] args)
		{	
			City Spokane = new City(); 
			
			Spokane.buildings.add(new CityHall("City Hall", "111 main St.")); 
			Spokane.buildings.add(new School("Liberty Elementary", "1 1st St."));
			
		
			Spokane.population.add(new Police(Police.Role.Sargent, 650.50, "Rick", 34, "590-1234")); 
			Spokane.population.add(new Police(Police.Role.Captain, 700.00, "Chris", 55, "510-9988")); 
			Spokane.population.add(new Police(Police.Role.Patrol, 600.25, "Jaimie", 22, "511-9999")); 
			Spokane.population.add(new Teacher(3, "Elementary", 700.00, "Marie", 29, "656-6776")); 
			Spokane.population.add(new Teacher(9, "French", 710.20, "Max", 40, "644-6776")); 
			Spokane.population.add(new Teacher(12, "Math", 800.15, "Jess", 50, "644-7000")); 
			Spokane.population.add(new Kid("LJ", 6, "123-4567", "Reese's")); 
			Spokane.population.add(new Kid("Alex", 10, "244-5547", "Skittles")); 
			Spokane.population.add(new Kid("Lauren", 8, "842-6795", "Sour Patch")); 
			
			
			CityWindow cw = new CityWindow(Spokane.population, Spokane.buildings); 
	
			 
		}	
		/**
		 * Display the Persons names in the city
		 * @param specifies the population to display 
		 */
		static public void rollCall(ArrayList<Person> pop)
		{
			System.out.printf("Population:\n"); 
			for (int i = 0; i < pop.size(); i++)
			{
				System.out.printf("%d. %s\n", i + 1, pop.get(i).name); 
			}
		}
		
		/**
		 * Display the Building's names in the city
		 * @param specifies which array of buildings to display 
		 */
		static public void buildingNames(ArrayList<Building> build)
		{
			System.out.printf("Buildings:\n"); 
			for (int i = 0; i < build.size(); i++)
			{
				System.out.printf("%d. %s\n", i + 1, build.get(i).name); 
			}
		}
		
		/**
		 * increments all employees in the city's savings by their pay
		 * @param specifies which population to pay
		 */
		static public void payEmployees(ArrayList<Person> pop)
		{
			for (int i = 0; i < pop.size(); i++)
			{
				if (pop.get(i) instanceof Employee)
				{
					((Employee)pop.get(i)).Pay();
				}
			}
		}
		
	
		
		
		
		

}
