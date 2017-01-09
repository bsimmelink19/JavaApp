import java.util.ArrayList;
/**
 * this class models a school with name, address, and occupants 
 * @see Building 
 * @author bsimmelink19
 */
public class School extends Building{
		/**
		 * Constructor
		 * @param name 
		 * @param address
		 */
		School(String n, String a)
		{
			this.name = n; 
			this.address = a; 
			this.currentOccupents = new ArrayList<Person>(); 
		}
		/**
		 * returns the array of current occupants 
		 * @return this array of current occupants 
		 */
		ArrayList<Person> getOccupents()
		{
			return this.currentOccupents; 
		}
		/**
		 * adds an occupant to the building 
		 * @param the Person to be added 
		 */
		void addOccupent(Person p)
		{
			currentOccupents.add(p); 
		}
		/**
		 * displays all occupants in this building 
		 */
		void displayOccupents()
		{
			for (int i = 0; i < currentOccupents.size(); i++)
			{
				System.out.printf("%s\n", currentOccupents.get(i).name); 
			}
		}
}
