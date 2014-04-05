package co.edu.andes.entities;


public class Line 
{
	private String content;
	private LineType currentLineType;
	private int location;
	
	public Line(String content, int location) {
		this.content = content;
		this.currentLineType  = LineType.None;
		this.location = location;
	}
	
	
	
	public void setContent(String content) {
		this.content = content;
	}



	public void setCurrentLineType(LineType currentLineType) {
		this.currentLineType = currentLineType;
	}



	public void setLocation(int location) {
		this.location = location;
	}



	public String getContent() 
	{
		return content;
	}
	
	public LineType getCurrentLineType() 
	{
		return currentLineType;
	}
	
	public int getLocation() 
	{
		return location;
	}
}
