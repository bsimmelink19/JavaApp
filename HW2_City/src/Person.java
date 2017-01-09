/**
 * This class models a person with name, age, phone number
 * @author Brady Simmelink
 */
public abstract class Person {
	protected String name;
	protected int age;
	protected String phoneNumber;
	/**
	 * returns the phone number
	 * @return this phone number
	 */
	public String getPhoneNumber()
	{
		return this.phoneNumber; 
	}
	/** 
	 * returns the age
	 * @return this age
	 */
	public int getAge()
	{
		return this.age; 
	}
	/**
	 * returns the name
	 * @return this name 
	 */
	public String getName()
	{
		return this.name; 
	}
}
