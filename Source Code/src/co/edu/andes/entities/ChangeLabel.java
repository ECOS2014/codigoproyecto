package co.edu.andes.entities;

import java.util.Date;

public class ChangeLabel 
{
	private int changeNumber;
	private Date changeDate;
	private String author;
	private String comment;
	private int partName;
	private int totalLOCAdded;
	private int totalLOCDeleted;
	private int totalLOC;

	public int getChangeNumber() 
	{
		return changeNumber;
	}

	public Date getChangeDate() 
	{
		return changeDate;
	}

	public String getAuthor() 
	{
		return author;
	}

	public String getComment() 
	{
		return comment;
	}

	public int getPartName() 
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

	
	public String toString()
	{
		return null;
	}
} 