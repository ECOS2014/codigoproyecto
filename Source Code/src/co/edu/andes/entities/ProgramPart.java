package co.edu.andes.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramPart 
{
	private String partName;
	private int totalLOCAdded;
	private int totalLOCDeleted;
	private int totalLOC;
	
	
	public void setPartName(String partName) {
		this.partName = partName;
	}

	public void setTotalLOCAdded(int totalLOCAdded) {
		this.totalLOCAdded = totalLOCAdded;
	}

	public void setTotalLOCDeleted(int totalLOCDeleted) {
		this.totalLOCDeleted = totalLOCDeleted;
	}

	public void setTotalLOC(int totalLOC) {
		this.totalLOC = totalLOC;
	}

	public String getPartName() 
	{		
		return partName;
	}
	
	public int getTotalLOCAdded() 
	{
		return totalLOCAdded;
	}
	
	public int getTotalLOCDeleted() 
	{
		return totalLOCDeleted;
	}
	
	public int getTotalLOC() 
	{
		return totalLOC;
	}	
	
	@Override
	public String toString(){
		String summary = "/**\n" +
			" * Change number: " + "\n" +
			" * Change date: " + this.getDate() + "\n" +
			" * Change description: " + "\n" +
			" * Change author: " + "\n" +
			" * Total LOC agregadas: "+ this.totalLOCAdded + "\n" +
			" * Total LOC eliminadas: " + this.totalLOCDeleted + "\n" +
			" * Total LOC: "+ this.totalLOC + "\n" +
			" */\n";
		
		return summary;		 
	}

	private String getDate() 
	{
		DateFormat dateFormat =  new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
