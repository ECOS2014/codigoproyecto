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
	public void compareParts(List<Line> oldPart, List<Line> newPart, ProgramPart partSummary, List<Line> comparsionResultLines)
	{
		System.out.println("---------------- compareParts(Begin) ----------------");
		int linesAdded;
		int linesDeleted;
		int totalLOC; 
		int counterChange;
		counterChange = partSummary.getChangeNumber();

		linesDeleted = this.getTotalDeleted(oldPart, newPart, comparsionResultLines, counterChange);
		linesAdded = this.getTotalAdded(oldPart, newPart, comparsionResultLines, counterChange);
		
		Line.sortArray(comparsionResultLines);
		
		totalLOC = newPart.size();
		partSummary.setTotalLOC(totalLOC);
		partSummary.setTotalLOCAdded(linesAdded);
		partSummary.setTotalLOCDeleted(linesDeleted);
		
		System.out.println("----------------- compareParts(End) -----------------");
		System.out.println("");
	}

	/**Obtiene el numero de lineas que fueron borradas de un archivo
	 * @param lastVersionPartLines
	 * @param currentVersionPartLines
	 * @param comparsionResultLines
	 * @param counterChange
	 * @return
	 */
	private int getTotalDeleted(List<Line> lastVersionPartLines, List<Line> currentVersionPartLines, List<Line> comparsionResultLines, Integer counterChange)
	{
		return compareLineSetAgainstLineSet(lastVersionPartLines, currentVersionPartLines, LineType.Deleted, LineType.Unchanged, LineType.None, comparsionResultLines, counterChange);		
		/*
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
		 */
	}

	
	
	/**Obtiene el numero de lineas que fueron agregadas
	 * @param oldVersion 
	 * @param currentVersion
	 * @param comparsionResultLines
	 * @param counterChange
	 * @return
	 */
	private int getTotalAdded(List<Line> lastVersionPartLines, List<Line> currentVersionPartLines, List<Line> comparsionResultLines, Integer changeNumber)
	{
		return compareLineSetAgainstLineSet(currentVersionPartLines, lastVersionPartLines, LineType.Added, LineType.Unchanged, LineType.None, comparsionResultLines, changeNumber);
		/*
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
		*/
	}
	
	/**
	 * Compara una lista de lineas contra otra lista, devuelve el numero de lineas que no fueron encontradas de la lista "startLineSet" en la lista "againstLineSet"
	 * @param startLineSet lista inicial de comparacion
	 * @param againstLineSet lista contra la cual se compara la inicial
	 * @param markWhenNotFound marka que reciben las lineas de la linea original cuando no son encontradas en la lisra "againstLineSet" 
	 * @param markWhenFound marka que reciben las lineas de la linea original cuando son encontradas en la lisra "againstLineSet"
	 * @param includeCriterion marka que deben tener las lineas de la lista orinal para ser incluidas en la comparacion
	 * @return el numero de lineas que despues de la comparacion tienen la marca markWhenNotFound
	 */
	private static int compareLineSetAgainstLineSet(List<Line>startLineSet, List<Line> againstLineSet, LineType markWhenNotFound, LineType markWhenFound, LineType includeCriterion, List<Line> comparsionResultLines, int changeNumber)
	{
		int notFoundCount = 0;
		int m = startLineSet.size();
		
		for (int i = 0; i < m; i++)
		{
			Line tempLine = startLineSet.get(i);
			tempLine.setChangeNumber(changeNumber);
			if (tempLine.getCurrentLineType() == includeCriterion)
			{
				Line comparsionResultLine = compareLineAgainstLineSet(tempLine, againstLineSet, markWhenNotFound, markWhenFound, includeCriterion);
				if (comparsionResultLine.getCurrentLineType() == markWhenNotFound)
				{
					notFoundCount++;
					comparsionResultLine.setChangeNumber(changeNumber);
					comparsionResultLines.add(comparsionResultLine);
				}
			}
		}
		
		return notFoundCount;
	}
	
	/**
	 * 
	 * @param line
	 * @param lineSet
	 * @param markWhenNotFound
	 * @param markWhenFound
	 * @param includeCriterion
	 * @return
	 */
	/**
	 * @param line
	 * @param lineSet
	 * @param markWhenNotFound
	 * @param markWhenFound
	 * @param includeCriterion
	 * @return
	 */
	private static Line compareLineAgainstLineSet(Line line, List<Line> lineSet,LineType markWhenNotFound, LineType markWhenFound, LineType includeCriterion)
	{
		int m = lineSet.size();
		Line comparsionResultLine = new Line(line.getContent(), line.getLocation());		
		
		boolean wasFound = false;
		for (int i = 0; !wasFound && i < m; i++ )
		{
			Line tempLine = lineSet.get(i);
			if (tempLine.getCurrentLineType() == includeCriterion && tempLine.equals(line))
			{
				wasFound = true;
				comparsionResultLine.setCurrentLineType(markWhenFound);
				line.setCurrentLineType(markWhenFound);
				tempLine.setCurrentLineType(markWhenFound);
			}
		}
		
		if (!wasFound)
		{
			comparsionResultLine.setCurrentLineType(markWhenNotFound);
			line.setCurrentLineType(markWhenNotFound);
		}
		
		return comparsionResultLine;
	}
}
