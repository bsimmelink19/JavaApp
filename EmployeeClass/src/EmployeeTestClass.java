
public class EmployeeTestClass {
		public static void main(String[] args)
		{
			EmployeeClass E1 = new EmployeeClass("Brady", "Simmelink", 24000.00);
			System.out.printf("First Name: %s\n Last Name: %s\n Salary: %f\n", E1.getFName(), E1.getLName(), E1.getSalary() * 12);
			EmployeeClass E2 = new EmployeeClass("LJ", "Benson", 1.0); 
			System.out.printf("First Name: %s\n Last Name: %s\n Salary: %f\n", E2.getFName(), E2.getLName(), E2.getSalary() * 12);
			E1.setSalary(E1.getSalary() * 1.1);
			E2.setSalary(E2.getSalary() * 1.1);
			System.out.printf("First Name: %s\n Last Name: %s\n Salary: %f\n", E1.getFName(), E1.getLName(), E1.getSalary() * 12);
			System.out.printf("First Name: %s\n Last Name: %s\n Salary: %f\n", E2.getFName(), E2.getLName(), E2.getSalary() * 12);
		}
}
