/**
 * Change number: 56
 * Change date: 2014/04/27 22:03
 * Change description: 6556566565
 * Change author: 6565
 * Total LOC agregadas: 28
 * Total LOC eliminadas: 0
 * Total LOC: 28
 */
// line  was added at [56]
public class Bicycle 
// line  was added at [56]
{
	// the Bicycle class has
	// three fields
	// line  was added at [56]
	public int cadence;
	// line  was added at [56]
	public int gear;
	// line  was added at [56]
	public int speed;
	       
	// the Bicycle class has
	// one constructor
	// line  was added at [56]
	public Bicycle(int startCadence, int startSpeed, int startGear) 
	// line  was added at [56]
	{
		// line  was added at [56]
		gear = startGear;
		// line  was added at [56]
		cadence = startCadence;
		// line  was added at [56]
		speed = startSpeed;
	// line  was added at [56]
	}
	        
	// the Bicycle class has
	// four methods
	// line  was added at [56]
	public void setCadence(int newValue) 
	// line  was added at [56]
	{
		// line  was added at [56]
		cadence = newValue;
	// line  was added at [56]
	}
	        
	// line  was added at [56]
	public void setGear(int newValue) 
	// line  was added at [56]
	{
		// line  was added at [56]
		gear = newValue;
	// line  was added at [56]
	}
	        
	// line  was added at [56]
	public void applyBrake(int decrement) 
	// line  was added at [56]
	{
		// line  was added at [56]
		speed -= decrement;
	// line  was added at [56]
	}
	        
	// line  was added at [56]
	public void speedUp(int increment) 
	// line  was added at [56]
	{
		// line  was added at [56]
		speed += increment;
	// line  was added at [56]
	}        
// line  was added at [56]
}
