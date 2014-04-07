package co.edu.andes.entities;

import java.util.ArrayList;

public class Line 
{
	private String content;
	private int changeNumber;
	private LineType currentLineType;
	private int location;
	
	/**
	 * Crea una nueva instancia de la clase linea
	 * @param content Contenido de la linea
	 * @param location Unicacion de la linea en el archivo fuente
	 * @param lineType Tipo de la linea
	 */
	public Line(String content, int location, LineType lineType)	
	{
		this.content = content;
		this.currentLineType =lineType;
		this.location = location;
	}
	
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

	public void setChangeNumber(int changeNumber){
		this.changeNumber = changeNumber;
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
	
	/**
	 * Compara 2 lineas por su ubicacion dentro del archivo fuente
	 * @param anotherLine
	 * @return
	 */
	public int compareTo(Line anotherLine)
	{
		int comparison = this.location - anotherLine.location;
		
		if (comparison != 0)
		{
			return comparison;
		}
		else
		{
			return this.compareToByType(anotherLine);
		}		
	}
	
	/**
	 * Compara 2 lineas por su tipo de linea
	 * @param anotherLine
	 * @return
	 */
	private int compareToByType(Line anotherLine) 
	{
		return this.currentLineType.ordinal() - anotherLine.getCurrentLineType().ordinal();
	}

	public boolean equals(Line anotherLine)
	{
		return ((this.content).equals(anotherLine.getContent()));
	}
	
	public String toString( )
	{
		return "Change Number: " + changeNumber + " Location: [" + location+ "] Type:  <" + currentLineType.name() + ">  Line: " + content;
	}
	
	/**
	 * Imprime por consola un array de lineas
	 * @param name
	 * @param lines
	 */
	public static void printArray( String name, ArrayList<Line> lines)
	{
		System.out.println("Array name: " + name);
		System.out.println("{");
		
		for(Line line : lines)
		{
			System.out.println("  " + line);
		}
		
		System.out.println("}");
	}
	
	/**
	 * Ordena un list de lineas por su ubicacion dentro del archivo
	 * @param lines
	 */
	public static void sortArray(ArrayList<Line> lines)
	{
		for(int i = lines.size(); i > 0; i--)
        {
            for(int j = 0; j < i - 1; j++)
            {
            	Line line1 = lines.get(j);
            	Line line2 = lines.get(j + 1);

                if(line1.compareTo(line2) > 0)
                {
                	lines.set(j, line2);
                	lines.set(j+1, line1);
                }
            }
        }
	}
	
	/**
	 * 
	 * @return
	 */
	public static ArrayList<String> toStringArray(ArrayList<Line> lines)
	{
		ArrayList<String> strLines = new ArrayList<String>();
		
		Line tempLine = null;
		
		int m = lines.size();
		for (int i=0; i<m; i++)
		{
			tempLine = lines.get(i);
			strLines.add( "// " + tempLine.getCurrentLineType().name() + " line at [" + tempLine.changeNumber + "]" );
		}
		
		return strLines;
	}
}
