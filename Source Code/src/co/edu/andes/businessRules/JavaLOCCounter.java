package co.edu.andes.businessRules;

import java.util.ArrayList;
import java.util.List;

import co.edu.andes.entities.LanguageType;
import co.edu.andes.entities.Line;

public class JavaLOCCounter extends LOCCounter 
{	
	private boolean hasStartComment;
	/**
	 * Obtener lineas logicas de la clase
	 */
	public List<Line> getLogicLines(List<String> lines)
	{
		List<Line> linesConverted = new ArrayList<Line>();
		if (lines != null)
		{
			int size;
			int position;
			String line;
			boolean isValid;
			size = lines.size();
			
			position=0;
			
			while(position <size)
			{
				line = lines.get(position);
				isValid = this.isValidLine(line);
				if(isValid)
					linesConverted.add(new Line(lines.get(position), position));
				position ++;
			}
		}		
		return linesConverted;
	}

	/**
	 * Valida la linea es un comentario
	 * @param line
	 * @return
	 */
	private boolean isValidLine(String line) 
	{
		boolean isvalidLine;
		isvalidLine = true;
		line = line.trim();
		if(line.startsWith("/*"))
		{
			hasStartComment=true;
			isvalidLine = false;
		}else if(hasStartComment)
		{
			hasStartComment = !line.endsWith("*/");
			isvalidLine = false;
		}else if( line.length() == 0 ||  line.startsWith("//"))
		{
			isvalidLine = false;
		}
		
		return isvalidLine;
	}

	@Override
	public LanguageType getLanguaje() 
	{
		return LanguageType.Java;
	}
	
	
	
}
