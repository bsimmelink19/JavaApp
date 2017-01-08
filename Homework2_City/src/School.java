import java.util.ArrayList;

public class School extends Building{
	
		School(String n, String a)
		{
			this.name = n; 
			this.address = a; 
			this.currentOccupents = new ArrayList<Person>(); 
		}
		ArrayList<Person> getOccupents()
		{
			return this.currentOccupents; 
		}
		void addOccupent(Person p)
		{
			currentOccupents.add(p); 
		}
		
		void displayOccupents()
		{
			for (int i = 0; i < currentOccupents.size(); i++)
			{
				System.out.printf("%s\n", currentOccupents.get(i).name); 
			}
		}
}
