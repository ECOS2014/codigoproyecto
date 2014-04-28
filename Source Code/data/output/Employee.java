/**    --- CHANGE LABEL ---
 * Change author name: 6565
 * Change number: 56
 * Change date: Sun Apr 27 22:03:45 COT 2014
 * Change description: 6556566565
 * Total added LOC: 40
 * Total deleted LOC: 34
 * Total LOC: 82
 */
/**
 * Change number: 56
 * Change date: 2014/04/27 22:03
 * Change description: 6556566565
 * Change author: 6565
 * Total LOC agregadas: 4
 * Total LOC eliminadas: 10
 * Total LOC: 29
 */
public class Employee
{
	String name;
	// line  was added at [56]
	String lastName;
	int age;
	String designation;
	double salary;
	// line 	public Employee(String name)  was deleted at [56]
	
	// line  was added at [56]
	public Employee(String name, String lastName)
	{
		this.name = name;
		// line  was added at [56]
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
	   
	// line 		salary = empSalary;  was deleted at [56]
	public void empSalary(double empSalary)
	{
		// line  was added at [56]
		salary = empSalary * (0.5);
	}
	   
	public static void main(String []args)
	// line 		myEmployee.printEmployee();  was deleted at [56]
	{
		Employee myEmployee = new Employee( "tommy" );
	}
// line 	public void printEmployee()  was deleted at [56]
}
