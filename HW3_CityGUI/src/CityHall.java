import java.util.ArrayList;
/**
 * this class models a city hall, with name, address and occupants
 * @see Building
 * @author Brady Simmelink
 * 
 */
public class CityHall extends Building {
	/**
	 * Constructor
	 * @param name
	 * @param age
	 */
	CityHall(String n, String a)
	{
		this.name = n; 
		this.address = a; 
		this.currentOccupents = new ArrayList<Person>(); 
	}
	
	/**
	 * Return the array of occupants 
	 * @return this buildings occupants
	 */
	ArrayList<Person> getOccupents()
	{
		return this.currentOccupents; 
	}
	/**
	 * add an occupant to this array of occupants
	 * @param the person to be added
	 */
	void addOccupent(Person p)
	{
		currentOccupents.add(p); 
	}
	/**
	 * Displays all of the occupants in this building 
	 */
	void displayOccupents()
	{
		for (int i = 0; i < currentOccupents.size(); i++)
		{
			System.out.printf("%s\n", currentOccupents.get(i).name); 
		}
	}
	void remove(String n)
	{
		for (int i = 0; i < currentOccupents.size(); i++)
		{
			if(currentOccupents.get(i).name.equals(n))
				{
					currentOccupents.remove(i); 
				}
			
		}
	}
}
