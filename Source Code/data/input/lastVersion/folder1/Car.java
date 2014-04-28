public class Car 
{
	int _age;
	static String _info = "I am made of steel!";
	static String wheels() 
	{
		return "I have 4 wheels!";
	}
	Car(int age) 
	{
		_age = age;
	}
	int getAge() 
	{
		return _age;
	}
	public static void printCarExample( ) 
	{
		car myCar = new car(2);
		System.out.println(myCar.wheels());
		System.out.println(myCar._info);
		System.out.println("My age is: " + myCar.getAge() + " year!");
	}
}