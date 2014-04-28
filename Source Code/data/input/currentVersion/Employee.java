public class Employee
{
	String name;
	String lastName;
	int age;
	String designation;
	double salary;
	
	public Employee(String name, String lastName)
	{
		this.name = name;
		this.lastName = lastName;
	}
	
	public void empAge(int empAge)
	{
		age = empAge;
	}
	
	public void empDesignation(String empDesig)
	{
		designation = empDesig;
	}
	   
	public void empSalary(double empSalary)
	{
		salary = empSalary * (0.5);
	}
	   
	public static void main(String []args)
	{
		Employee myEmployee = new Employee( "tommy" );
	}
}