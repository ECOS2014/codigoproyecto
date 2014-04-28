/**
 * Change number: 56
 * Change date: 2014/04/27 22:03
 * Change description: 6556566565
 * Change author: 6565
 * Total LOC agregadas: 8
 * Total LOC eliminadas: 0
 * Total LOC: 25
 */
public class Puppy
{
	int puppyAge;
	
	public Puppy(String name)
	{
		// This constructor has one parameter, name.
		// line  was added at [56]
		System.out.println("Passed Name is :" + name );
		System.out.println("Passed Name is :" + name ); 
	}
	   
	public void setAge( int age )
	{
		puppyAge = age;
	}
	
	public int getAge( )
	{
		System.out.println("Puppy's age is :" + puppyAge ); 
		return puppyAge;
	}
	   
	// line  was added at [56]
	public static void PtintSomePuppy()
	// line  was added at [56]
	{
		// line  was added at [56]
		Puppy myPuppy = new Puppy( "tommy" );
		// line  was added at [56]
		myPuppy.setAge( 2 );
		// line  was added at [56]
		myPuppy.getAge( );
		// line  was added at [56]
		System.out.println("Variable Value :" + myPuppy.puppyAge ); 
	// line  was added at [56]
	}
}
