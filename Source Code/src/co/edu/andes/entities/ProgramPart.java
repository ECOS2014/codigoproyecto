package co.edu.andes.entities;

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
		String summary;
		
		summary = "Total LOC: "+ this.totalLOC +"\n"+
				 	"Total LOC agregadas: "+ this.totalLOCAdded +"\n"+
				 	"Total LOC eliminadas: " + this.totalLOCDeleted + "\n";
		
		return summary;
				
		 
	}
}
