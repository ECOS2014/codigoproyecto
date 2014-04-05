package co.edu.andes.businessRules;

import java.util.List;

import co.edu.andes.entities.Line;
import co.edu.andes.entities.LineType;
import co.edu.andes.entities.ProgramPart;

public class PartComparator 
{
	/**
	 * Compara dos archivos
	 * @param oldPart
	 * @param newPart
	 * @param partSummary
	 * @param partWithChanges
	 */
	public void compareParts(List<Line> oldPart, List<Line> newPart, ProgramPart partSummary, List<String> partWithChanges)
	{
		int linesAdded;
		int linesDeleted;
		int totalLOC; 
		int counterChange;
		counterChange = 0;

		linesAdded = this.getTotalAdded(oldPart, newPart, partWithChanges, counterChange);
		linesDeleted = this.getTotalDeleted(oldPart, newPart, partWithChanges, linesAdded);
		totalLOC = newPart.size();
		 
		partSummary.setTotalLOC(totalLOC);
		partSummary.setTotalLOCAdded(linesAdded);
		partSummary.setTotalLOCDeleted(linesDeleted);
	}

	/**Obtiene el numero de lineas que fueron borradas de un archivo
	 * @param oldVersion
	 * @param currentVersion
	 * @param partWithChanges
	 * @param counterChange
	 * @return
	 */
	private int getTotalDeleted(List<Line> oldVersion, List<Line> currentVersion, List<String> partWithChanges, Integer counterChange)
	{
		int size;		
		int sizeCurrent;
		size = oldVersion.size();
		sizeCurrent = currentVersion.size();
		Line current;
		Line old;
		Integer totalLineDeleted;
		
		totalLineDeleted =0; 
		for (int i=0; i < size; i++)
		{
			current = null;
			old = oldVersion.get(i);
			if(i<sizeCurrent)
				current = currentVersion.get(i);
					
			if(current==null || ( !current.getContent().equals(old.getContent()) && current.getLocation() == old.getLocation())){
				counterChange +=1;
				old.setCurrentLineType(LineType.Deleted);
				partWithChanges.add("//Linea eliminada. Cambio número: "+counterChange); 
				partWithChanges.add("//" + current.getContent());
				totalLineDeleted ++;
			}
		}
		return totalLineDeleted;

	}

	/**Obtiene el numero de lineas que fueron agregadas
	 * @param oldVersion 
	 * @param currentVersion
	 * @param partWithChanges
	 * @param counterChange
	 * @return
	 */
	private int getTotalAdded(List<Line> oldVersion, List<Line> currentVersion, List<String> partWithChanges, Integer counterChange)
	{
		int size;		
		int sizeOld;
		size = currentVersion.size();
		sizeOld  = oldVersion.size();
		Line current;
		Line old;
		int totalLineAdded;
		
		totalLineAdded =0; 
		for (int i=0; i < size; i++)
		{
			old =null;
			current = currentVersion.get(i);
			if(i < sizeOld)
				old = oldVersion.get(i);
			
			if(old==null || (!current.getContent().equals(old.getContent()) && current.getLocation() == old.getLocation())){
				counterChange +=1;
				current.setCurrentLineType(LineType.Added);
				partWithChanges.add("//Linea nueva. Cambio número: "+counterChange); 
				
				totalLineAdded ++;
			}
			partWithChanges.add(current.getContent());
		}
		return totalLineAdded;
	}
}
