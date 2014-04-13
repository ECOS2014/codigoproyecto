package co.edu.andes.entities;

import java.util.ArrayList;
import java.util.Date;

public class ChangeLabel 
{
	private int changeNumber;
	private Date changeDate;
	private String author;
	private String comment;
	private ArrayList<ProgramPart> programParts;
	
	/**
	 * Crea una nueva intancia del change label
	 * @param authorName
	 * @param changeNumber
	 * @param changeDescription
	 */
	public ChangeLabel(String authorName, String changeNumber,	String changeDescription) 
	{
		author = authorName;
		this.changeNumber = Integer.parseInt(changeNumber);
		changeDate = new Date();
		comment = changeDescription;
		programParts = new ArrayList<ProgramPart>();
	}

	public String getChangeAuthor()
	{
		return author;
	}
	
	public int getChangeNumber()
	{
		return changeNumber;
	}
	
	public String getChangeDescription()
	{
		return comment;
	}
	
	public String toString()
	{
		String changeLabel = "/**    --- CHANGE LABEL ---\n";
		changeLabel += " * Change author name: " + author + "\n";
		changeLabel += " * Change number: " + changeNumber + "\n";
		changeLabel += " * Change date: " + changeDate.toString() + "\n";
		changeLabel += " * Change description: " + comment + "\n";
		changeLabel += " * Total added LOC: " + getTotalAddedLOC() + "\n";
		changeLabel += " * Total deleted LOC: " + getTotalDeletedLOC() + "\n";
		changeLabel += " * Total LOC: " + getTotalLOC() + "\n";
		changeLabel += " */\n";
		
		return changeLabel;
	}
	
	/**
	 * Obtiene el total de lineas agregadas 
	 * @return
	 */
	private int getTotalAddedLOC() 
	{
		int totalAddedLOC = 0;
		int m = programParts.size();
		
		for (int i=0; i<m; i++)
		{
			ProgramPart tempPart = programParts.get(i);
			totalAddedLOC += tempPart.getTotalLOCAdded();
		}
		
		return totalAddedLOC;
	}

	/**
	 * Obtiene el total de lineas borradas
	 * @return
	 */
	private int getTotalDeletedLOC() 
	{
		int totalDeletedLOC = 0;
		int m = programParts.size();
		
		for (int i=0; i<m; i++)
		{
			ProgramPart tempPart = programParts.get(i);
			totalDeletedLOC += tempPart.getTotalLOCDeleted();
		}
		
		return totalDeletedLOC;
	}

	
	private int getTotalLOC() 
	{
		int totalLOC = 0;
		int m = programParts.size();
		
		for (int i=0; i<m; i++)
		{
			ProgramPart tempPart = programParts.get(i);
			totalLOC += tempPart.getTotalLOC();
		}
		
		return totalLOC;
	}

	/**
	 * Agrega una nueva parte a la coleccion de partes
	 * @param part
	 */
	public void addPart(ProgramPart part) 
	{
		programParts.add(part);
	}
} 