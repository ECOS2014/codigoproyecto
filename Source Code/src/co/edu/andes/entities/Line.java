package co.edu.andes.entities;

import co.edu.andes.tools.LineType;

public class Line 
{
	private String content;
	private LineType currentLineType = LineType.None;
	private int lineLocation;
	
	
	public String getContent() 
	{
		return content;
	}
	
	public LineType getCurrentLineType() 
	{
		return currentLineType;
	}
	
	public int getLineLocation() 
	{
		return lineLocation;
	}
}
