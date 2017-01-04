
public class EmployeeClass {
	String fName; 
	String lName; 
	double salary; 
	
	EmployeeClass(String f, String l, Double s)
	{
		this.fName = f; 
		this.lName = l; 
		this.salary = s; 
	}
	
	String getFName()
	{
		return this.fName; 
	}
	String getLName()
	{
		return this.lName; 
	}
	double getSalary()
	{
		return this.salary; 
	}
	void setfName(String f)
	{
		this.fName = f; 
	}
	void setLname(String l)
	{
		this.lName = l; 
	}
	void setSalary(double s)
	{
		if (s >= 0)
		this.salary = s; 
	}
}
