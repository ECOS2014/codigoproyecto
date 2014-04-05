package co.edu.andes.businessRules;

import java.util.ArrayList;
import java.util.List;

import co.edu.andes.entities.Line;

public class JavaLOCCounter extends LOCCounter 
{	
	/**
	 * Obtener lineas logicas de la clase
	 */
	public List<Line> getLogicLines(List<String> lines)
	{
		List<Line> linesConverted;
		int size;
		
		linesConverted = new ArrayList<Line>();
		size = lines.size();
		for(int i=0; i<size;i++){
			linesConverted.add(new Line(lines.get(i), i));
		}
		return linesConverted;
	}
}
