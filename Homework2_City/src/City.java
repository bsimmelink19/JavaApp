import java.util.ArrayList;
import java.util.Scanner; 
  
public class City {
	 
	 ArrayList<Building> buildings = new ArrayList<Building>(); 
	 ArrayList<Person> population = new ArrayList<Person>(); 
		
		public static void main(String[] args)
		{	
			City Spokane = new City(); 
			
			Spokane.buildings.add(new CityHall("City Hall", "111 main St.")); 
			Spokane.buildings.add(new School("Derek Zoolander's School for Kids Who Can't Read Good", "1 1st St."));
		
			Spokane.population.add(new Police(Police.Role.Sargent, 650.50, "Rick", 34, "590-1234")); 
			Spokane.population.add(new Police(Police.Role.Captain, 700.00, "Chris", 55, "510-9988")); 
			Spokane.population.add(new Police(Police.Role.Patrol, 600.25, "Jaimie", 22, "511-9999")); 
			Spokane.population.add(new Teacher(3, "Elementary", 700.00, "Marie", 29, "656-6776")); 
			Spokane.population.add(new Teacher(9, "French", 710.20, "Max", 40, "644-6776")); 
			Spokane.population.add(new Teacher(12, "Math", 800.15, "Jess", 50, "644-7000")); 
			Spokane.population.add(new Kid("Jimmy", 6, "123-4567", "butterFinger")); 
			Spokane.population.add(new Kid("Alex", 10, "244-5547", "Skittles")); 
			Spokane.population.add(new Kid("Lauren", 8, "842-6795", "Sour Patch")); 
			
			for (int i = 0; i < Spokane.buildings.size(); i++)
			{
				if (Spokane.buildings.get(i) instanceof School)
				{
					for (int j = 0; j < Spokane.population.size(); j++)
					{
						if(Spokane.population.get(j) instanceof Teacher || Spokane.population.get(j) instanceof Kid)
						{
							((School)Spokane.buildings.get(i)).addOccupent(Spokane.population.get(j)); 
						}
					}
				}
				else if (Spokane.buildings.get(i) instanceof CityHall)
				{
					for (int j = 0; j < Spokane.population.size(); j++)
					{
						if (Spokane.population.get(j) instanceof Police)
						{
							((CityHall)Spokane.buildings.get(i)).addOccupent(Spokane.population.get(j)); 
						}
					}
				}
			}
			
			Scanner input = new Scanner(System.in); 
			while (true)
			{
				System.out.printf("Select an option:\n"
					+ "Display population (enter 1)\n"
					+ "Display building names(enter 2)\n"
					+ "Display who is in school(enter 3)\n"
					+ "Display who is in city hall (enter 4)\n"
					+ "Pay employees in the city (enter 5)\n"
					+ "Exit (enter 6)"
					);
				int choice = input.nextInt(); 
				
				if (choice == 1)
				{
					rollCall(Spokane.population);
					
				}
				else if (choice == 2)
					buildingNames(Spokane.buildings);
				else if (choice == 3)
				{
					for (int i = 0; i < Spokane.buildings.size(); i++)
					{
						if(Spokane.buildings.get(i) instanceof School)
							((School)Spokane.buildings.get(i)).displayOccupents();
					}
				}
				else if (choice == 4)
				{
					for (int i = 0; i < Spokane.buildings.size(); i++)
					{
						if(Spokane.buildings.get(i) instanceof CityHall)
							((CityHall)Spokane.buildings.get(i)).displayOccupents();
					}
				}
				else if (choice == 5)
				{
					City.payEmployees(Spokane.population);
				}
				else if (choice == 6)
				{
					break; 
				}
				else System.out.printf("Invalid Selection, Try again\n");
			}
			 
			 
		}	
		
		static public void rollCall(ArrayList<Person> pop)
		{
			System.out.printf("Population:\n"); 
			for (int i = 0; i < pop.size(); i++)
			{
				System.out.printf("%d. %s\n", i + 1, pop.get(i).name); 
			}
		}
		
		static public void buildingNames(ArrayList<Building> build)
		{
			System.out.printf("Buildings:\n"); 
			for (int i = 0; i < build.size(); i++)
			{
				System.out.printf("%d. %s\n", i + 1, build.get(i).name); 
			}
		}
		
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
