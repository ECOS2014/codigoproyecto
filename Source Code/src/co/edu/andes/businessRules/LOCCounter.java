package co.edu.andes.businessRules;

import java.util.List;

import co.edu.andes.entities.Line;

public abstract class LOCCounter 
{
	public abstract List<Line> getLogicLines(List<String> lines);
}
